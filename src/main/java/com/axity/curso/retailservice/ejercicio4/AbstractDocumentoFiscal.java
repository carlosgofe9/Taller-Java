package com.axity.curso.retailservice.ejercicio4;

public abstract class AbstractDocumentoFiscal {

    // Atributos protegidos
    protected String folioFiscal;
    protected double subtotal;

    // Constructor sin argumentos
    public AbstractDocumentoFiscal() {
    }

    // Constructor parametrizado
    public AbstractDocumentoFiscal(String folioFiscal, double subtotal) {
        this.folioFiscal = folioFiscal;
        this.subtotal = subtotal;
    }

    // Método concreto: calcula el total sumando el 16% de IVA
    public double calcularTotalConIVA() {
        return this.subtotal * 1.16;
    }

    // Método abstracto obligatorio para las clases hijas
    public abstract String generarEstructuraXML();

    // Getters y Setters
    public String getFolioFiscal() { return folioFiscal; }
    public void setFolioFiscal(String folioFiscal) { this.folioFiscal = folioFiscal; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}