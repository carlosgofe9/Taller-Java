package com.axity.curso.retailservice.ejercicio3;

public class EmpleadoRetail {

    // Atributos protegidos (protected) para permitir acceso directo a subclases
    protected String numNomina;
    protected String nombre;
    protected double sueldoBase;

    // Constructor sin argumentos
    public EmpleadoRetail() {
    }

    // Constructor parametrizado
    public EmpleadoRetail(String numNomina, String nombre, double sueldoBase) {
        this.numNomina = numNomina;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    // Método base para calcular sueldo neto
    public double calcularSueldoNeto() {
        return this.sueldoBase;
    }

    // Getters y Setters
    public String getNumNomina() { return numNomina; }
    public void setNumNomina(String numNomina) { this.numNomina = numNomina; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }
}