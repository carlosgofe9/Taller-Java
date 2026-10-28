package com.axity.curso.retailservice.service;

import com.axity.curso.retailservice.dto.OrderItemRequestDTO;
import com.axity.curso.retailservice.dto.OrderRequestDTO;
import com.axity.curso.retailservice.dto.OrderResponseDTO;
import com.axity.curso.retailservice.exception.RecursoNoEncontradoException;
import com.axity.curso.retailservice.exception.StockInsuficienteException;
import com.axity.curso.retailservice.model.Order;
import com.axity.curso.retailservice.model.OrderItem;
import com.axity.curso.retailservice.model.OrderStatus;
import com.axity.curso.retailservice.model.Product;
import com.axity.curso.retailservice.repository.OrderRepository;
import com.axity.curso.retailservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    @Transactional
    public OrderResponseDTO crearPedido(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setCustomerEmail(orderRequestDTO.getCliente());
        order.setStatus(OrderStatus.EN_PROCESO);

        for (OrderItemRequestDTO itemDto : orderRequestDTO.getItems()) {
            Product producto = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con ID: " + itemDto.getProductId()));

            // 1. Verificación Sincrónica de Stock
            if (producto.getStock() < itemDto.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getName() 
                        + ". Disponible: " + producto.getStock() + ", Solicitado: " + itemDto.getCantidad());
            }

            // 2. Descuento de Inventario
            int nuevoStock = producto.getStock() - itemDto.getCantidad();
            producto.setStock(nuevoStock);
            productRepository.save(producto);

            // 3. Alerta Asíncrona si el stock es crítico (menor a 5 unidades)
            if (nuevoStock < 5) {
                notificationService.enviarAlertaStockMinimoAsync(producto.getSku(), nuevoStock);
            }

            // 4. Crear ítem usando la relación bidireccional helper (addItem)
            OrderItem orderItem = new OrderItem(producto, itemDto.getCantidad(), producto.getPrice());
            order.addItem(orderItem);
        }

        Order pedidoGuardado = orderRepository.save(order);

        // 5. Envío Asíncrono de Confirmación por Email
        notificationService.enviarConfirmacionCompraAsync(pedidoGuardado.getId(), pedidoGuardado.getCustomerEmail());

        return mappearADTO(pedidoGuardado);
    }

    @Override
    public OrderResponseDTO obtenerPorId(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con ID: " + id));
        return mappearADTO(order);
    }

    @Override
    public List<OrderResponseDTO> listarPedidos() {
        return orderRepository.findAll().stream()
                .map(this::mappearADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResponseDTO cancelarPedido(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con ID: " + id));

        order.setStatus(OrderStatus.CANCELADO);

        // Reversión lógica de stock
        for (OrderItem item : order.getItems()) {
            Product producto = item.getProduct();
            producto.setStock(producto.getStock() + item.getQuantity());
            productRepository.save(producto);
        }

        Order pedidoCancelado = orderRepository.save(order);
        return mappearADTO(pedidoCancelado);
    }

    // Método auxiliar de mapeo
    private OrderResponseDTO mappearADTO(Order order) {
        List<OrderItemRequestDTO> itemsDto = order.getItems().stream()
                .map(item -> new OrderItemRequestDTO(item.getProduct().getId(), item.getQuantity()))
                .collect(Collectors.toList());

        BigDecimal total = order.getItems().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new OrderResponseDTO(
                order.getId(),
                order.getCustomerEmail(),
                order.getStatus(),
                total,
                itemsDto
        );
    }
}