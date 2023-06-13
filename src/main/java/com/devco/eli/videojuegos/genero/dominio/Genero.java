package com.devco.eli.videojuegos.genero.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import lombok.Data;

@Data
public class Genero {

    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";

    private Long id;
    private String nombre;

    public void isValid() {
        if (nombre == null || nombre.isBlank()) {
            throw new BadRequest(NOMBRE_INVALIDO);
        }
    }
}
