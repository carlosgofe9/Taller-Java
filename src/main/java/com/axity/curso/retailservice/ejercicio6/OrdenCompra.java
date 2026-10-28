package com.axity.curso.retailservice.ejercicio6;

public class OrdenCompra {

    private String orderId;
    private EstadoPedido estado;

    public OrdenCompra(String orderId, EstadoPedido estado) {
        this.orderId = orderId;
        this.estado = estado;
    }

    // Inner Class no estática
    public class DetalleLinea {

        private String sku;
        private int cantidad;

        public DetalleLinea(String sku, int cantidad) {
            this.sku = sku;
            this.cantidad = cantidad;
        }

        // Acceso directo al campo orderId de la clase contenedora externa
        @Override
        public String toString() {
            return "DetalleLinea [SKU=" + sku + ", Cantidad=" + cantidad + 
                   " | Perteneciente a la Orden ID=" + OrdenCompra.this.orderId + "]";
        }

        public String getSku() { return sku; }
        public int getCantidad() { return cantidad; }
    }

    // Getters y Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
}