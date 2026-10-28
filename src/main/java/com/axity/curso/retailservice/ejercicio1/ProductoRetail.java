package com.axity.curso.retailservice.ejercicio1;

public class ProductoRetail {

    // Atributos privados (Encapsulamiento)
    private String sku;
    private String descripcion;
    private double precioUnitario;
    private int existencias;

    // 1. Constructor por defecto (sin argumentos)
    public ProductoRetail() {
    }

    // 2. Constructor parametrizado con todos los atributos
    public ProductoRetail(String sku, String descripcion, double precioUnitario, int existencias) {
        this.sku = sku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.existencias = existencias;
    }

    // Método de negocio: aplicarDescuento
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            double descuento = this.precioUnitario * (porcentaje / 100.0);
            this.precioUnitario -= descuento;
            System.out.println("Descuento del " + porcentaje + "% aplicado al producto [" + sku + "]. Nuevo precio: $" + this.precioUnitario);
        } else {
            System.out.println("Porcentaje de descuento inválido.");
        }
    }

    // Método de negocio: reabastecer
    public void reabastecer(int cantidad) {
        if (cantidad > 0) {
            this.existencias += cantidad;
            System.out.println("Se reabastecieron " + cantidad + " unidades del producto [" + sku + "]. Stock actual: " + this.existencias);
        } else {
            System.out.println("La cantidad a reabastecer debe ser mayor a 0.");
        }
    }

    // Getters y Setters
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public int getExistencias() { return existencias; }
    public void setExistencias(int existencias) { this.existencias = existencias; }
}