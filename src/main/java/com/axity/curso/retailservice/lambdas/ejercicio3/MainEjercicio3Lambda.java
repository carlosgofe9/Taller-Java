package com.axity.curso.retailservice.lambdas.ejercicio3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainEjercicio3Lambda {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 3: DISTINCT Y SORTED (STREAMS) ===\n");

        // 1. Lista de SKUs con lecturas duplicadas y desordenadas del escáner
        List<String> skusEscaneados = Arrays.asList(
            "SKU-902", "SKU-101", "SKU-505", "SKU-101", "SKU-303", "SKU-902", "SKU-202"
        );

        System.out.println("Lista de SKUs Original (Con duplicados y desordenada):");
        System.out.println(skusEscaneados);
        System.out.println("-------------------------------------------------------------------\n");

        // 2. Procesamiento con API Stream: distinct() y sorted()
        List<String> skusDepurados = skusEscaneados.stream()
                .distinct() // Elimina elementos duplicados basándose en equals()
                .sorted()   // Ordena los elementos según su orden natural (alfabético)
                .collect(Collectors.toList()); // Recolecta el flujo en una nueva lista

        // 3. Impresión de la lista procesada
        System.out.println("Lista de SKUs Depurada (Únicos y ordenados alfabéticamente):");
        System.out.println(skusDepurados);
    }
}