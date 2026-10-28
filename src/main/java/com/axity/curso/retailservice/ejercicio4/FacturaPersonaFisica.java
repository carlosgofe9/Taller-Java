package com.axity.curso.retailservice.ejercicio4;

public class FacturaPersonaFisica extends AbstractDocumentoFiscal {

    private String curp;

    // Constructor que invoca al constructor de la clase abstracta
    public FacturaPersonaFisica(String folioFiscal, double subtotal, String curp) {
        super(folioFiscal, subtotal);
        this.curp = curp;
    }

    // Implementación obligatoria del método abstracto
    @Override
    public String generarEstructuraXML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<FacturaPersonaFisica>\n" +
               "  <FolioFiscal>" + this.folioFiscal + "</FolioFiscal>\n" +
               "  <CURP>" + this.curp + "</CURP>\n" +
               "  <Subtotal>" + String.format("%.2f", this.subtotal) + "</Subtotal>\n" +
               "  <TotalConIVA>" + String.format("%.2f", calcularTotalConIVA()) + "</TotalConIVA>\n" +
               "</FacturaPersonaFisica>";
    }

    // Getter y Setter
    public String getCurp() { return curp; }
    public void setCurp(String curp) { this.curp = curp; }
}