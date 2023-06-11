package com.devco.eli.videojuegos.comun.errores;

public class NotFoundRequest extends RuntimeException {
    public NotFoundRequest(String message) {
        super(message);
    }
}
