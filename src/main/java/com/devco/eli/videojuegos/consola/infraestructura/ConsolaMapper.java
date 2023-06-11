package com.devco.eli.videojuegos.consola.infraestructura;

import com.devco.eli.videojuegos.consola.dominio.Consola;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConsolaMapper {
    private ConsolaMapper() {
    }

    public static Optional<Consola> entityToOptionalDomain(Optional<ConsolaEntity> entity) {
        Consola dominio = null;
        if (entity.isPresent()) {
            dominio = entityToDominio(entity.get());
        }
        return Optional.ofNullable(dominio);
    }

    public static List<Consola> entityToDominio(List<ConsolaEntity> entitys) {
        return entitys.stream()
                .map(ConsolaMapper::entityToDominio)
                .collect(Collectors.toList());
    }

    public static List<ConsolaEntity> dominioToEntity(List<Consola> dominios) {
        return dominios.stream()
                .map(ConsolaMapper::dominioToEntity)
                .collect(Collectors.toList());
    }

    public static Consola entityToDominio(ConsolaEntity entity) {
        if (entity == null) {
            return null;
        }
        Consola dominio = new Consola();
        dominio.setId(entity.getConsolaId());
        dominio.setNombre(entity.getNombreConsola());
        return dominio;
    }

    public static ConsolaEntity dominioToEntity(Consola dominio) {
        if (dominio == null) {
            return null;
        }
        ConsolaEntity entity = new ConsolaEntity();
        entity.setConsolaId(dominio.getId());
        entity.setNombreConsola(dominio.getNombre());
        return entity;
    }
}
