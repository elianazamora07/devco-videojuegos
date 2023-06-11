package com.devco.eli.videojuegos.common.exceptions;

import lombok.Data;

@Data
public class ApiException {
    private String message;

    public ApiException(String message) {
        this.message = message;
    }
}
