package com.devco.eli.videojuegos.common.exceptions.exception;

public class ForbiddenRequest extends RuntimeException {

    public ForbiddenRequest(String message) {
        super(message);
    }
}
