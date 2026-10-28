package com.axity.curso.retailservice.ejercicio5;

public interface MedioPago {

    // Método abstracto (contrato)
    boolean procesarPago(double monto);

    // Método default con lógica común
    default boolean validarMonto(double monto) {
        if (monto > 0.0) {
            return true;
        } else {
            System.out.println("[ERROR] El monto debe ser mayor a $0.0");
            return false;
        }
    }
}