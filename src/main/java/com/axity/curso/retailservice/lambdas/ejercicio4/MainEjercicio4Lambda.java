package com.axity.curso.retailservice.lambdas.ejercicio4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainEjercicio4Lambda {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 4: TOP 3 MÁS VENDIDOS (SORTED Y LIMIT) ===\n");

        // 1. Crear una lista con 5 artículos y sus unidades vendidas
        List<VentaArticulo> ventas = Arrays.asList(
            new VentaArticulo("Refresco de Cola 600ml", 150),
            new VentaArticulo("Agua Purificada 1L", 320),
            new VentaArticulo("Botana de Maíz 150g", 95),
            new VentaArticulo("Chocolate con Leche", 210),
            new VentaArticulo("Pan Dulce Pieza", 180)
        );

        System.out.println("--- Reporte General de Ventas ---");
        ventas.forEach(v -> System.out.println("Artículo: " + v.getArticulo() + " | Unidades: " + v.getUnidadesVendidas()));
        System.out.println("-------------------------------------------------------------------\n");

        // 2. Filtrado y ordenamiento descendente con Comparator Lambda y limit(3)
        System.out.println("--- TOP 3 ARTÍCULOS MÁS VENDIDOS ---");
        ventas.stream()
                .sorted(Comparator.comparingInt(VentaArticulo::getUnidadesVendidas).reversed()) // Orden descendente
                .limit(3) // Corta el flujo a los primeros 3 elementos
                .forEach(v -> System.out.println(" Top: " + v.getArticulo() + " (" + v.getUnidadesVendidas() + " unidades)"));
    }
}