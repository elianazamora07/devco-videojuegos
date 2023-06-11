package com.devco.eli.videojuegos.consola.dominio;

import com.devco.eli.videojuegos.comun.errores.BadRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Consola {

    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";

    private Long id;
    private String nombre;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void isValid() {
        if (nombre.isBlank()) {
            throw new BadRequest(NOMBRE_INVALIDO);
        }
    }
}
