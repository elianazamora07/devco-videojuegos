package com.devco.eli.videojuegos.videojuegos.infraestructura;

import com.devco.eli.videojuegos.consola.infraestructura.ConsolaMapper;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroMapper;
import com.devco.eli.videojuegos.videojuegos.dominio.VideoJuego;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VideoJuegoMapper {
    private VideoJuegoMapper() {
    }

    public static Optional<VideoJuego> entityToOptionalDomain(Optional<VideoJuegoEntity> entity) {
        VideoJuego dominio = null;
        if (entity.isPresent()) {
            dominio = entityToDominio(entity.get());
        }
        return Optional.ofNullable(dominio);
    }

    public static List<VideoJuego> entityToDominio(List<VideoJuegoEntity> entitys) {
        return entitys.stream()
                .map(VideoJuegoMapper::entityToDominio)
                .collect(Collectors.toList());
    }

    public static List<VideoJuegoEntity> dominioToEntity(List<VideoJuego> dominios) {
        return dominios.stream()
                .map(VideoJuegoMapper::dominioToEntity)
                .collect(Collectors.toList());
    }

    public static VideoJuego entityToDominio(VideoJuegoEntity entity) {
        if (entity == null) {
            return null;
        }
        VideoJuego dominio = new VideoJuego();
        dominio.setId(entity.getJuegoId());
        dominio.setNombre(entity.getNombreJuego());
        dominio.setDescripcion(entity.getDescripcion());
        dominio.setCantidad(entity.getCantidad());
        dominio.setPrecio(entity.getPrecio());
        dominio.setConsola(ConsolaMapper.entityToDominio(entity.getConsolaEntity()));
        dominio.setGeneros(GeneroMapper.entityToDominio(entity.getGenerosEntity()));
        return dominio;
    }

    public static VideoJuegoEntity dominioToEntity(VideoJuego dominio) {
        if (dominio == null) {
            return null;
        }
        VideoJuegoEntity entity = new VideoJuegoEntity();
        entity.setJuegoId(dominio.getId());
        entity.setNombreJuego(dominio.getNombre());
        entity.setDescripcion(dominio.getDescripcion());
        entity.setCantidad(dominio.getCantidad());
        entity.setPrecio(dominio.getPrecio());
        entity.setConsolaEntity(ConsolaMapper.dominioToEntity(dominio.getConsola()));
        entity.setGenerosEntity(GeneroMapper.dominioToEntity(dominio.getGeneros()));
        return entity;
    }
}
