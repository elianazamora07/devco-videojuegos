package com.devco.eli.videojuegos.genero.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import com.devco.eli.videojuegos.consola.dominio.Consola;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeneroTest {

    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";
    @Test
    void isValid_NombreValido_NoDebeLanzarExcepcion() {
        Genero genero = new Genero();
        genero.setNombre("Nombre válido");

        assertDoesNotThrow(() -> genero.isValid());
    }

    @Test
    void isValid_NombreVacio_DebeLanzarExcepcion() {
        Genero genero = new Genero();
        genero.setNombre("");

        BadRequest exception = assertThrows(BadRequest.class, () -> genero.isValid());
        assertEquals(NOMBRE_INVALIDO, exception.getMessage());
    }

    @Test
    void isValid_NombreNulo_DebeLanzarExcepcion() {
        Genero genero = new Genero();
        genero.setNombre(null);

        BadRequest exception = assertThrows(BadRequest.class, () -> genero.isValid());
        assertEquals(NOMBRE_INVALIDO, exception.getMessage());
    }
}
