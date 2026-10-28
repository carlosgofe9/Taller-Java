package com.axity.curso.retailservice.service;

import com.axity.curso.retailservice.dto.ProductDTO;
import com.axity.curso.retailservice.exception.PrecioInvalidoException;
import com.axity.curso.retailservice.exception.RecursoNoEncontradoException;
import com.axity.curso.retailservice.model.Product;
import com.axity.curso.retailservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO crearProducto(ProductDTO productDTO) {
        if (productDTO.getPrice() == null || productDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new PrecioInvalidoException("El precio del producto debe ser mayor a $0.00 MXN");
        }
        Product producto = mappearAEntidad(productDTO);
        Product productoGuardado = productRepository.save(producto);
        return mappearADTO(productoGuardado);
    }

    @Override
    public ProductDTO obtenerPorId(Long id) {
        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con el ID: " + id));
        return mappearADTO(producto);
    }

    @Override
    public List<ProductDTO> listarProductos() {
        return productRepository.findAll().stream()
                .map(this::mappearADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO actualizarProducto(Long id, ProductDTO productDTO) {
        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con el ID: " + id));

        if (productDTO.getPrice() == null || productDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new PrecioInvalidoException("El precio debe ser un valor positivo");
        }

        producto.setName(productDTO.getName());
        producto.setDescription(productDTO.getDescription());
        producto.setPrice(productDTO.getPrice());
        producto.setStock(productDTO.getStock());
        producto.setCategory(productDTO.getCategory());
        producto.setSku(productDTO.getSku());
        if (productDTO.getActive() != null) {
            producto.setActive(productDTO.getActive());
        }

        Product actualizado = productRepository.save(producto);
        return mappearADTO(actualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se puede eliminar. Producto no encontrado con ID: " + id));
        
        // Soft Delete (Desactivación lógica requerida en la especificación)
        producto.setActive(false);
        productRepository.save(producto);
    }

    // Métodos auxiliares de mapeo (Entity <-> DTO)
    private ProductDTO mappearADTO(Product producto) {
        return new ProductDTO(
                producto.getId(),
                producto.getName(),
                producto.getDescription(),
                producto.getPrice(),
                producto.getStock(),
                producto.getCategory(),
                producto.getSku(),
                producto.getActive()
        );
    }

    private Product mappearAEntidad(ProductDTO dto) {
        Product p = new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());
        p.setCategory(dto.getCategory());
        p.setSku(dto.getSku());
        if (dto.getActive() != null) {
            p.setActive(dto.getActive());
        }
        return p;
    }
}