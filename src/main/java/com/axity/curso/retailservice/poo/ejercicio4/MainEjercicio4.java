package com.axity.curso.retailservice.poo.ejercicio4;

public class MainEjercicio4 {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 4: CLASES Y MÉTODOS ABSTRACTOS ===\n");

        // Instanciación de la factura concreta
        FacturaPersonaFisica factura = new FacturaPersonaFisica("UUID-98765-ABC", 1500.00, "ROGC990101HDFRLL09");

        // Demostración del método concreto heredado
        System.out.println("Folio Fiscal: " + factura.getFolioFiscal());
        System.out.println("Subtotal: $" + factura.getSubtotal());
        System.out.println("Total con 16% IVA: $" + String.format("%.2f", factura.calcularTotalConIVA()));
        System.out.println("-------------------------------------------------------------------\n");

        // Demostración del método abstracto implementado (XML)
        System.out.println("--- ESTRUCTURA XML GENERADA ---");
        System.out.println(factura.generarEstructuraXML());
    }
}