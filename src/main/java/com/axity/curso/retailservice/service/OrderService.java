package com.axity.curso.retailservice.service;

import com.axity.curso.retailservice.dto.OrderRequestDTO;
import com.axity.curso.retailservice.dto.OrderResponseDTO;
import java.util.List;

public interface OrderService {
    OrderResponseDTO crearPedido(OrderRequestDTO orderRequestDTO);
    OrderResponseDTO obtenerPorId(Long id);
    List<OrderResponseDTO> listarPedidos();
    OrderResponseDTO cancelarPedido(Long id);
}