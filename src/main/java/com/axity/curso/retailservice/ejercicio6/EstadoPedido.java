package com.axity.curso.retailservice.ejercicio6;

public enum EstadoPedido {

    PENDIENTE(1, "Pedido registrado y pendiente de surtido"),
    EN_TRANSITO(2, "Pedido en ruta de entrega con la paquetería"),
    ENTREGADO(3, "Pedido entregado con éxito al cliente");

    private final int id;
    private final String descripcion;

    // Constructor privado del Enum
    EstadoPedido(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
}