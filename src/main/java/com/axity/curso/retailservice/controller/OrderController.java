package com.axity.curso.retailservice.controller;

import com.axity.curso.retailservice.dto.OrderRequestDTO;
import com.axity.curso.retailservice.dto.OrderResponseDTO;
import com.axity.curso.retailservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> crearPedido(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO creado = orderService.crearPedido(orderRequestDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> listarPedidos() {
        List<OrderResponseDTO> lista = orderService.listarPedidos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> obtenerPedidoPorId(@PathVariable("id") Long id) {
        OrderResponseDTO pedido = orderService.obtenerPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<OrderResponseDTO> cancelarPedido(@PathVariable("id") Long id) {
        OrderResponseDTO cancelado = orderService.cancelarPedido(id);
        return ResponseEntity.ok(cancelado);
    }
}