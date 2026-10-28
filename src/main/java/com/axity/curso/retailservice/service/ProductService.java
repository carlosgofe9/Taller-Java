package com.axity.curso.retailservice.service;

import com.axity.curso.retailservice.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO crearProducto(ProductDTO productDTO);
    ProductDTO obtenerPorId(Long id);
    List<ProductDTO> listarProductos();
    ProductDTO actualizarProducto(Long id, ProductDTO productDTO);
    void eliminarProducto(Long id);
}