package com.axity.curso.retailservice.dto;

import com.axity.curso.retailservice.model.OrderStatus;
import java.math.BigDecimal;
import java.util.List;

public class OrderResponseDTO {

    private Long id;
    private String customerEmail;
    private OrderStatus status;
    private BigDecimal total;
    private List<OrderItemRequestDTO> items;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Long id, String customerEmail, OrderStatus status, BigDecimal total, List<OrderItemRequestDTO> items) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.status = status;
        this.total = total;
        this.items = items;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public List<OrderItemRequestDTO> getItems() { return items; }
    public void setItems(List<OrderItemRequestDTO> items) { this.items = items; }
}