package com.axity.curso.retailservice.poo.ejercicio3;

public class Cajero extends EmpleadoRetail {

    // Atributo específico de Cajero
    private double comisionCaja;

    // Constructor que invoca al constructor del padre mediante super()
    public Cajero(String numNomina, String nombre, double sueldoBase, double comisionCaja) {
        super(numNomina, nombre, sueldoBase);
        this.comisionCaja = comisionCaja;
    }

    // Sobreescritura del método para sumar la comisión de caja
    @Override
    public double calcularSueldoNeto() {
        return this.sueldoBase + this.comisionCaja;
    }

    // Getter y Setter
    public double getComisionCaja() { return comisionCaja; }
    public void setComisionCaja(double comisionCaja) { this.comisionCaja = comisionCaja; }
}