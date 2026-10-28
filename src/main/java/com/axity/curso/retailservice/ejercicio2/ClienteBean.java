package com.axity.curso.retailservice.ejercicio2;

import java.io.Serializable;
import java.util.Objects;

public class ClienteBean implements Serializable {

    // Constante requerida por la especificación Serializable
    private static final long serialVersionUID = 1L;

    // Atributos privados
    private Integer idCliente;
    private String nombre;
    private String tarjetaFidelidad;
    private int saldoPuntos;

    // 1. Constructor sin argumentos (Requisito JavaBean)
    public ClienteBean() {
    }

    // Constructor parametrizado (opcional pero muy práctico)
    public ClienteBean(Integer idCliente, String nombre, String tarjetaFidelidad, int saldoPuntos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.tarjetaFidelidad = tarjetaFidelidad;
        this.saldoPuntos = saldoPuntos;
    }

    // Getters y Setters
    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTarjetaFidelidad() { return tarjetaFidelidad; }
    public void setTarjetaFidelidad(String tarjetaFidelidad) { this.tarjetaFidelidad = tarjetaFidelidad; }

    public int getSaldoPuntos() { return saldoPuntos; }
    public void setSaldoPuntos(int saldoPuntos) { this.saldoPuntos = saldoPuntos; }

    // Sobreescritura de equals basada estrictamente en idCliente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteBean cliente = (ClienteBean) o;
        return Objects.equals(idCliente, cliente.idCliente);
    }

    // Sobreescritura de hashCode basada estrictamente en idCliente
    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    // Representación legible del estado del objeto
    @Override
    public String toString() {
        return "ClienteBean{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", tarjetaFidelidad='" + tarjetaFidelidad + '\'' +
                ", saldoPuntos=" + saldoPuntos +
                '}';
    }
}