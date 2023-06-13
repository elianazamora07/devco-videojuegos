package com.devco.eli.videojuegos.consola.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsolaTest {
    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";

    @Test
    void isValid_NombreValido_NoDebeLanzarExcepcion() {
        Consola consola = new Consola();
        consola.setNombre("Nombre válido");

        assertDoesNotThrow(() -> consola.isValid());
    }

    @Test
    void isValid_NombreVacio_DebeLanzarExcepcion() {
        Consola consola = new Consola();
        consola.setNombre("");

        BadRequest exception = assertThrows(BadRequest.class, () -> consola.isValid());
        assertEquals(NOMBRE_INVALIDO, exception.getMessage());
    }

    @Test
    void isValid_NombreNulo_DebeLanzarExcepcion() {
        Consola consola = new Consola();
        consola.setNombre(null);

        BadRequest exception = assertThrows(BadRequest.class, () -> consola.isValid());
        assertEquals(NOMBRE_INVALIDO, exception.getMessage());
    }
}
