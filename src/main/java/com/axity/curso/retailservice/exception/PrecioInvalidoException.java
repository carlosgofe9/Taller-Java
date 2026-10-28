package com.axity.curso.retailservice.exception;

public class PrecioInvalidoException extends RuntimeException {
    public PrecioInvalidoException(String mensaje) {
        super(mensaje);
    }
}