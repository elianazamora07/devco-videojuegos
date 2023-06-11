package com.devco.eli.videojuegos.comun.errores;

import lombok.Data;

@Data
public class ApiError {
    private String mensaje;

    public ApiError(String mensaje) {
        this.mensaje = mensaje;
    }
}
