package com.axity.curso.retailservice.controller;

import com.axity.curso.retailservice.dto.ProductDTO;
import com.axity.curso.retailservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> crearProducto(@RequestBody ProductDTO productDTO) {
        ProductDTO creado = productService.crearProducto(productDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listarProductos() {
        List<ProductDTO> lista = productService.listarProductos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> obtenerProductoPorId(@PathVariable("id") Long id) {
        ProductDTO producto = productService.obtenerPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> actualizarProducto(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO actualizado = productService.actualizarProducto(id, productDTO);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Long id) {
        productService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}