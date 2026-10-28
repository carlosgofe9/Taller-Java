package com.axity.curso.retailservice.ejercicio5;

public class MainEjercicio5 {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 5: INTERFACES Y POLIMORFISMO ===\n");

        ProcesadorPagosService procesador = new ProcesadorPagosService();

        // Creamos instancias de diferentes medios de pago
        MedioPago tarjeta = new TarjetaCredito("4502-XXXX-XXXX-8812");
        MedioPago vale = new ValeElectronico("VALE-500", 500.00);

        // Polimorfismo en acción: la misma clase service procesa distintos medios
        procesador.ejecutarCobro(tarjeta, 1250.50);
        procesador.ejecutarCobro(vale, 200.00);   // Cobro exitoso con vale
        procesador.ejecutarCobro(vale, 400.00);   // Cobro rechazado por saldo insuficiente
        procesador.ejecutarCobro(tarjeta, -50.0); // Monto inválido
    }
}