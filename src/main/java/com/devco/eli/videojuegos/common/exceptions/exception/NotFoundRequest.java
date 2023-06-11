package com.devco.eli.videojuegos.common.exceptions.exception;

public class NotFoundRequest extends RuntimeException {
    public NotFoundRequest(String message) {
        super(message);
    }
}
