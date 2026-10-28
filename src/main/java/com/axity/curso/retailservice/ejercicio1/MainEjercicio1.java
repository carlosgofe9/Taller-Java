package com.axity.curso.retailservice.ejercicio1;

public class MainEjercicio1 {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE INSTANCIACIÓN E IDENTIDAD EN MEMORIA ===\n");

        // Instanciación del Producto 1 (Usando constructor parametrizado)
        ProductoRetail producto1 = new ProductoRetail("PROD-101", "Pantalla Smart TV 55 Pulgadas", 8999.99, 10);

        // Instanciación del Producto 2 (Usando constructor por defecto + setters)
        ProductoRetail producto2 = new ProductoRetail();
        producto2.setSku("PROD-102");
        producto2.setDescripcion("Audífonos Bluetooth Noise Cancelling");
        producto2.setPrecioUnitario(1499.50);
        producto2.setExistencias(25);

        System.out.println("Referencia de producto1 en memoria: " + System.identityHashCode(producto1));
        System.out.println("Referencia de producto2 en memoria: " + System.identityHashCode(producto2));
        System.out.println("¿Ambos objetos apuntan a la misma dirección?: " + (producto1 == producto2));
        System.out.println("-------------------------------------------------------------------\n");

        // Prueba de métodos de negocio en Producto 1
        System.out.println("--- Estado inicial Producto 1 ---");
        System.out.println("SKU: " + producto1.getSku() + " | Precio: $" + producto1.getPrecioUnitario());
        producto1.aplicarDescuento(15); 
        System.out.println("");

        // Prueba de métodos de negocio en Producto 2
        System.out.println("--- Estado inicial Producto 2 ---");
        System.out.println("SKU: " + producto2.getSku() + " | Stock: " + producto2.getExistencias());
        producto2.reabastecer(15); 
    }
}