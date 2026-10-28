package com.axity.curso.retailservice.ejercicio5;

public class ProcesadorPagosService {

    // Método polimórfico: recibe la interfaz MedioPago, no una clase concreta
    public void ejecutarCobro(MedioPago medioPago, double monto) {
        System.out.println("--- Iniciando transacción de cobro ---");
        boolean exito = medioPago.procesarPago(monto);
        if (exito) {
            System.out.println(" Transacción completada con éxito.\n");
        } else {
            System.out.println(" Transacción fallida.\n");
        }
    }
}