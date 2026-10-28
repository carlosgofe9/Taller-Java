package com.axity.curso.retailservice.lambdas.ejercicio5;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class MainEjercicio5Lambda {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 5: RESUMEN ESTADÍSTICO (INTSTREAM) ===\n");

        // 1. Crear lista de montos de tickets cobrados en enteros (List<Integer>)
        List<Integer> tickets = Arrays.asList(150, 450, 80, 1200, 320, 95, 680);

        System.out.println("Lista de Tickets Registrados en Caja:");
        System.out.println(tickets);
        System.out.println("-------------------------------------------------------------------\n");

        // 2. Transformar a IntStream y obtener objeto IntSummaryStatistics
        IntSummaryStatistics estadisticas = tickets.stream()
                .mapToInt(Integer::intValue) // Mapea de Stream<Integer> a IntStream primitivo
                .summaryStatistics();        // Genera el informe financiero completo en 1 solo paso

        // 3. Mostrar métricas financieras en consola
        System.out.println("--- INFORME FINANCIERO DE CIERRE DE CAJA ---");
        System.out.println("Total de Transacciones (Count): " + estadisticas.getCount());
        System.out.println("Venta Mínima:                  $" + estadisticas.getMin() + ".00 MXN");
        System.out.println("Venta Máxima:                  $" + estadisticas.getMax() + ".00 MXN");
        System.out.println("Venta Total Acumulada (Suma):  $" + estadisticas.getSum() + ".00 MXN");
        System.out.println("Ticket Promedio:               $" + String.format("%.2f", estadisticas.getAverage()) + " MXN");
    }
}