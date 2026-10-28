package com.axity.curso.retailservice.ejercicio3;

public class MainEjercicio3 {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 3: HERENCIA Y SOBREESCRITURA ===\n");

        // Instanciación de un Cajero
        Cajero cajero = new Cajero("NOM-001", "María López", 8000.0, 1500.0);

        // Instanciación de un Gerente de Tienda
        GerenteTienda gerente = new GerenteTienda("NOM-100", "Roberto Gómez", 25000.0, 8000.0);

        // Demostración del comportamiento en Cajero
        System.out.println("--- DATOS DEL CAJERO ---");
        System.out.println("Nómina: " + cajero.getNumNomina() + " | Nombre: " + cajero.getNombre());
        System.out.println("Sueldo Base: $" + cajero.getSueldoBase() + " | Comisión Caja: $" + cajero.getComisionCaja());
        System.out.println("Sueldo Neto Calculado: $" + cajero.calcularSueldoNeto());
        System.out.println("-------------------------------------------------------------------\n");

        // Demostración del comportamiento en Gerente
        System.out.println("--- DATOS DEL GERENTE ---");
        System.out.println("Nómina: " + gerente.getNumNomina() + " | Nombre: " + gerente.getNombre());
        System.out.println("Sueldo Base: $" + gerente.getSueldoBase() + " | Bono Metas: $" + gerente.getBonoMetasVenta());
        System.out.println("Sueldo Neto Calculado: $" + gerente.calcularSueldoNeto());
    }
}