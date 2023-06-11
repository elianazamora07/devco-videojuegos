package com.devco.eli.videojuegos.comun.errores;

public class ForbiddenRequest extends RuntimeException {

    public ForbiddenRequest(String message) {
        super(message);
    }
}
