package com.axity.curso.retailservice.ejercicio3;

public class GerenteTienda extends EmpleadoRetail {

    // Atributo específico de Gerente
    private double bonoMetasVenta;

    // Constructor que invoca al constructor del padre mediante super()
    public GerenteTienda(String numNomina, String nombre, double sueldoBase, double bonoMetasVenta) {
        super(numNomina, nombre, sueldoBase);
        this.bonoMetasVenta = bonoMetasVenta;
    }

    // Sobreescritura del método para sumar el bono por metas ejecutivas
    @Override
    public double calcularSueldoNeto() {
        return this.sueldoBase + this.bonoMetasVenta;
    }

    // Getter y Setter
    public double getBonoMetasVenta() { return bonoMetasVenta; }
    public void setBonoMetasVenta(double bonoMetasVenta) { this.bonoMetasVenta = bonoMetasVenta; }
}