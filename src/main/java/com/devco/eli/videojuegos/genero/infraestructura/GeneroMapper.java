package com.devco.eli.videojuegos.genero.infraestructura;

import com.devco.eli.videojuegos.genero.dominio.Genero;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneroMapper {
    private GeneroMapper() {
    }

    public static Optional<Genero> entityToOptionalDomain(Optional<GeneroEntity> entity) {
        Genero dominio = null;
        if (entity.isPresent()) {
            dominio = entityToDominio(entity.get());
        }
        return Optional.ofNullable(dominio);
    }

    public static Set<Genero> entityToDominio(Set<GeneroEntity> entitys) {
        return entitys.stream()
                .map(GeneroMapper::entityToDominio)
                .collect(Collectors.toSet());
    }

    public static Set<GeneroEntity> dominioToEntity(Set<Genero> dominios) {
        return dominios.stream()
                .map(GeneroMapper::dominioToEntity)
                .collect(Collectors.toSet());
    }

    public static List<Genero> entityToDominio(List<GeneroEntity> entitys) {
        return entitys.stream()
                .map(GeneroMapper::entityToDominio)
                .collect(Collectors.toList());
    }

    public static List<GeneroEntity> dominioToEntity(List<Genero> dominios) {
        return dominios.stream()
                .map(GeneroMapper::dominioToEntity)
                .collect(Collectors.toList());
    }

    public static Genero entityToDominio(GeneroEntity entity) {
        if (entity == null) {
            return null;
        }
        Genero dominio = new Genero();
        dominio.setId(entity.getGeneroId());
        dominio.setNombre(entity.getNombreGenero());
        return dominio;
    }

    public static GeneroEntity dominioToEntity(Genero dominio) {
        if (dominio == null) {
            return null;
        }
        GeneroEntity entity = new GeneroEntity();
        entity.setGeneroId(dominio.getId());
        entity.setNombreGenero(dominio.getNombre());
        return entity;
    }
}
