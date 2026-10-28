package com.axity.curso.retailservice.ejercicio5;

public class ValeElectronico implements MedioPago {

    private String folioVale;
    private double saldoDisponible;

    public ValeElectronico(String folioVale, double saldoDisponible) {
        this.folioVale = folioVale;
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (!validarMonto(monto)) {
            return false;
        }
        if (monto <= saldoDisponible) {
            saldoDisponible -= monto;
            System.out.println("Procesando pago de $" + monto + " con VALE ELECTRÓNICO (" + folioVale + ") -> Cobro exitoso. Saldo restante: $" + saldoDisponible);
            return true;
        } else {
            System.out.println("[RECHAZADO] Vale Electrónico con saldo insuficiente. Saldo actual: $" + saldoDisponible);
            return false;
        }
    }

    public String getFolioVale() { return folioVale; }
    public void setFolioVale(String folioVale) { this.folioVale = folioVale; }

    public double getSaldoDisponible() { return saldoDisponible; }
    public void setSaldoDisponible(double saldoDisponible) { this.saldoDisponible = saldoDisponible; }
}