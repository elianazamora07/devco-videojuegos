package com.devco.eli.videojuegos.genero.infraestructura;

import com.devco.eli.videojuegos.genero.dominio.Genero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GeneroMapperTest {

    @Test
    public void testEntityToOptionalDomain_WhenEntityIsPresent_ReturnOptionalDomain() {
        // Arrange
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setGeneroId(1L);
        generoEntity.setNombreGenero("Aventura");

        Optional<GeneroEntity> entityOptional = Optional.of(generoEntity);

        // Act
        Optional<Genero> resultOptional = GeneroMapper.entityToOptionalDomain(entityOptional);

        // Assert
        Assertions.assertTrue(resultOptional.isPresent());
        Assertions.assertEquals(generoEntity.getGeneroId(), resultOptional.get().getId());
        Assertions.assertEquals(generoEntity.getNombreGenero(), resultOptional.get().getNombre());
    }

    @Test
    public void testEntityToOptionalDomain_WhenEntityIsEmpty_ReturnEmptyOptionalDomain() {
        // Arrange
        Optional<GeneroEntity> entityOptional = Optional.empty();

        // Act
        Optional<Genero> resultOptional = GeneroMapper.entityToOptionalDomain(entityOptional);

        // Assert
        Assertions.assertTrue(resultOptional.isEmpty());
    }

    @Test
    public void testEntityToDominio_WhenSetOfEntities_ReturnSetOfDomains() {
        // Arrange
        GeneroEntity generoEntity1 = new GeneroEntity();
        generoEntity1.setGeneroId(1L);
        generoEntity1.setNombreGenero("Aventura");

        GeneroEntity generoEntity2 = new GeneroEntity();
        generoEntity2.setGeneroId(2L);
        generoEntity2.setNombreGenero("Acción");

        Set<GeneroEntity> entitySet = new HashSet<>(Arrays.asList(generoEntity1, generoEntity2));

        // Act
        Set<Genero> result = GeneroMapper.entityToDominio(entitySet);

        // Assert
        Assertions.assertEquals(entitySet.size(), result.size());
        for (GeneroEntity entity : entitySet) {
            Assertions.assertTrue(result.stream()
                    .anyMatch(dominio -> dominio.getId().equals(entity.getGeneroId())
                            && dominio.getNombre().equals(entity.getNombreGenero())));
        }
    }
}
