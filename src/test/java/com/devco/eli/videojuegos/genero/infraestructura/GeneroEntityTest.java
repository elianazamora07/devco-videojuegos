package com.devco.eli.videojuegos.genero.infraestructura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneroEntityTest {

    @Test
    public void testGeneroEntity() {
        // Arrange
        Long generoId = 1L;
        String nombreGenero = "Aventura";

        // Act
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setGeneroId(generoId);
        generoEntity.setNombreGenero(nombreGenero);

        // Assert
        Assertions.assertEquals(generoId, generoEntity.getGeneroId());
        Assertions.assertEquals(nombreGenero, generoEntity.getNombreGenero());
    }
}
