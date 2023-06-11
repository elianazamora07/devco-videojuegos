package com.devco.eli.videojuegos.comun.errores;

public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        super(message);
    }
}
