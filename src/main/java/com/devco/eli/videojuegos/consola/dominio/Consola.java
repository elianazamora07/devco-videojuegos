package com.devco.eli.videojuegos.consola.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import lombok.Data;

@Data
public class Consola {

    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";

    private Long id;
    private String nombre;

    public void isValid() {
        if (nombre == null || nombre.isBlank()) {
            throw new BadRequest(NOMBRE_INVALIDO);
        }
    }
}
