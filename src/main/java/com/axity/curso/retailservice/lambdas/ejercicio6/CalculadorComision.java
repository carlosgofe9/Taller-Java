package com.axity.curso.retailservice.lambdas.ejercicio6;

@FunctionalInterface
public interface CalculadorComision {

    // Único método abstracto requerido por la anotación @FunctionalInterface
    double calcular(double montoSubtotal, boolean esEnvioDomicilio);
}