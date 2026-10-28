package com.axity.curso.retailservice.dto;

public class OrderItemRequestDTO {

    private Long productId;
    private int cantidad;

    public OrderItemRequestDTO() {
    }

    public OrderItemRequestDTO(Long productId, int cantidad) {
        this.productId = productId;
        this.cantidad = cantidad;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}