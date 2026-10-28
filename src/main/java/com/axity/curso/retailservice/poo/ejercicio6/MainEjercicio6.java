package com.axity.curso.retailservice.poo.ejercicio6;

public class MainEjercicio6 {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 6: ENUMS E INNER CLASSES ===\n");

        // 1. Demostración de Enum enriquecido
        OrdenCompra orden = new OrdenCompra("ORD-2026-99", EstadoPedido.EN_TRANSITO);

        System.out.println("--- ESTADO DEL PEDIDO (ENUM) ---");
        System.out.println("ID Orden: " + orden.getOrderId());
        System.out.println("Estado ID: " + orden.getEstado().getId());
        System.out.println("Estado Nombre: " + orden.getEstado().name());
        System.out.println("Estado Descripción: " + orden.getEstado().getDescripcion());
        System.out.println("-------------------------------------------------------------------\n");

        // 2. Instanciación de la Inner Class vinculada a la instancia de OrdenCompra
        OrdenCompra.DetalleLinea linea1 = orden.new DetalleLinea("PROD-8821", 3);
        OrdenCompra.DetalleLinea linea2 = orden.new DetalleLinea("PROD-4410", 1);

        System.out.println("--- DETALLES DE LÍNEA (INNER CLASS) ---");
        System.out.println(linea1);
        System.out.println(linea2);
    }
}