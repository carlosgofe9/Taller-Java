package com.axity.curso.retailservice.lambdas.ejercicio1;

import java.util.Arrays;
import java.util.List;

public class MainEjercicio1Lambda {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 1: FILTRADO CON FILTER Y FOREACH (STREAMS) ===\n");

        // 1. Crear lista con al menos 4 productos del catálogo de la tienda
        List<Producto> catalogo = Arrays.asList(
            new Producto("Leche Entera 1L", 28.50),
            new Producto("Aceite de Oliva 500ml", 125.00),
            new Producto("Detergente en Polvo 1kg", 65.00),
            new Producto("Paquete de Galletas", 18.00),
            new Producto("Café Soluble 200g", 98.50)
        );

        System.out.println("--- Catálogo Completo ---");
        catalogo.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------\n");

        // 2. Filtrado usando stream(), filter() con Lambda y forEach()
        System.out.println("--- Productos con Precio > $50.00 MXN ---");
        catalogo.stream()
                .filter(producto -> producto.getPrecio() > 50.00) // Lambda Predicate: evalúa la condición booleana
                .forEach(producto -> System.out.println("Producto: " + producto.getNombre() + " | Precio: $" + producto.getPrecio()));
    }
}