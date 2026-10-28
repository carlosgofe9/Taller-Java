package com.axity.curso.retailservice.poo.ejercicio2;

public class MainEjercicio2 {

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN EJERCICIO 2: ENCAPSULAMIENTO Y JAVABEANS ===\n");

        // Instanciación usando constructor por defecto y setters
        ClienteBean cliente1 = new ClienteBean();
        cliente1.setIdCliente(1001);
        cliente1.setNombre("Carlos Rodríguez");
        cliente1.setTarjetaFidelidad("GOLD-9982");
        cliente1.setSaldoPuntos(500);

        // Instanciación de un segundo cliente con el MISMO idCliente pero diferentes datos
        ClienteBean cliente2 = new ClienteBean(1001, "Carlos R. Modificado", "GOLD-9982", 800);

        // Instanciación de un tercer cliente con DIFERENTE idCliente
        ClienteBean cliente3 = new ClienteBean(1002, "Ana Martínez", "PLATINUM-1102", 1200);

        // Demostración de toString()
        System.out.println("Representación toString() de cliente1:");
        System.out.println(cliente1);
        System.out.println("-------------------------------------------------------------------\n");

        // Demostración de equals() y hashCode() basándose sólo en idCliente
        System.out.println("¿cliente1 es igual a cliente2? (Mismo idCliente: 1001): " + cliente1.equals(cliente2));
        System.out.println("¿cliente1 es igual a cliente3? (Diferente idCliente): " + cliente1.equals(cliente3));
        
        System.out.println("\nHashCode de cliente1: " + cliente1.hashCode());
        System.out.println("HashCode de cliente2: " + cliente2.hashCode());
        System.out.println("HashCode de cliente3: " + cliente3.hashCode());
    }
}