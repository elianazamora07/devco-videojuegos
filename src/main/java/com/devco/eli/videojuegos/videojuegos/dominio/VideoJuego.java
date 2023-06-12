package com.devco.eli.videojuegos.videojuegos.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.genero.dominio.Genero;
import lombok.Data;

import java.util.Set;

@Data
public class VideoJuego {

    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";
    private static final String CANTIDAD_INVALIDA = "La cantidad no puede ser menor a 0.";
    private static final String PRECIO_INVALIDO = "El precio no puede ser menor a 0.";
    private static final String CONSOLA_INVALIDA = "El juego debe estar disponible para una consola.";
    private static final String GENEROS_INVALIDOS = "El juego debe tener al menos un genero.";

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Long precio;
    private Consola consola;
    private Set<Genero> generos;

    public void isValid() {
        if (nombre.isBlank()) {
            throw new BadRequest(NOMBRE_INVALIDO);
        }
        if (cantidad < 0) {
            throw new BadRequest(CANTIDAD_INVALIDA);
        }
        if (precio < 0) {
            throw new BadRequest(PRECIO_INVALIDO);
        }
        if (consola == null || consola.getId() == null) {
            throw new BadRequest(CONSOLA_INVALIDA);
        }
        if (generos == null || generos.isEmpty()) {
            throw new BadRequest(GENEROS_INVALIDOS);
        }
    }
}
