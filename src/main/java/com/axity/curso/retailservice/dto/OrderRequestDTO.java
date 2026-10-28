package com.axity.curso.retailservice.dto;

import java.util.List;

public class OrderRequestDTO {

    private String cliente;
    private List<OrderItemRequestDTO> items;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(String cliente, List<OrderItemRequestDTO> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public List<OrderItemRequestDTO> getItems() { return items; }
    public void setItems(List<OrderItemRequestDTO> items) { this.items = items; }
}