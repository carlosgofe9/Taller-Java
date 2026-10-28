package com.axity.curso.retailservice.ejercicio5;

public class TarjetaCredito implements MedioPago {

    private String numeroTarjeta;

    public TarjetaCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (!validarMonto(monto)) {
            return false;
        }
        System.out.println("Procesando pago de $" + monto + " con TARJETA DE CRÉDITO (" + numeroTarjeta + ") -> Autorizado por el banco.");
        return true;
    }

    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }
}
