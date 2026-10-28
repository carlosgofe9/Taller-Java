package com.axity.curso.retailservice.lambdas.ejercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainEjercicio2Lambda {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 2: TRANSFORMACIÓN CON MAP Y COLLECT (STREAMS) ===\n");

        // 1. Definición de la lista inicial de precios de lista (List<Double>)
        List<Double> preciosLista = Arrays.asList(100.0, 250.50, 80.0, 1200.0, 450.0);

        // 2. Aplicación de la API Stream: map() con expresión Lambda y collect()
        List<Double> preciosConDescuento = preciosLista.stream()
                .map(precio -> precio * 0.85)
                .collect(Collectors.toList()); 

        // 3. Impresión de resultados en consola para verificar la transformación
        System.out.println("Lista de Precios Base (Original):");
        System.out.println(preciosLista);
        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("Lista de Precios con 15% de Descuento (Transformada):");
        System.out.println(preciosConDescuento);
    }
}