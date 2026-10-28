package com.axity.curso.retailservice.lambdas.ejercicio6;

public class MainEjercicio6Lambda {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 6: INTERFAZ FUNCIONAL Y LAMBDA DE BLOQUE ===\n");

        // Implementación de la Interfaz Funcional usando una Lambda con bloque de código {}
        CalculadorComision calculadorPasarela = (montoSubtotal, esEnvioDomicilio) -> {
            double comisionZona = montoSubtotal * 0.035; // 3.5% de comisión estándar
            double tarifaEnvio = 0.0;

            // Lógica condicional dentro del bloque Lambda
            if (esEnvioDomicilio && montoSubtotal < 500.0) {
                tarifaEnvio = 45.0; // Tarifa fija si no alcanza la compra mínima de envío gratis
            }

            return comisionZona + tarifaEnvio;
        };

        // Datos de prueba para una compra
        double subtotalCompra = 350.00;
        boolean envioADomicilio = true;

        // Cálculo ejecutando el método de la Lambda
        double cargoTotalServicio = calculadorPasarela.calcular(subtotalCompra, envioADomicilio);
        double totalPagar = subtotalCompra + cargoTotalServicio;

        // Desglose final
        System.out.println("--- DESGLOSE DE COBRO EN PASARELA DE PAGOS ---");
        System.out.println("Subtotal Compra:               $" + String.format("%.2f", subtotalCompra) + " MXN");
        System.out.println("¿Envío a Domicilio?:           " + (envioADomicilio ? "SÍ" : "NO"));
        System.out.println("Cargos por Comisión y Envío:   $" + String.format("%.2f", cargoTotalServicio) + " MXN");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Monto Total a Cobrar:          $" + String.format("%.2f", totalPagar) + " MXN");
    }
}