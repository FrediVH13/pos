package com.fredivazquez.pos.exceptions;

public class PosException extends RuntimeException {

    public PosException(Long id) {
        super("No se encuentra el elemento: " + id);
    }
}
