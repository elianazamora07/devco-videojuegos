package com.devco.eli.videojuegos.videojuegos.dominio.dto;

import lombok.Data;

import java.util.Set;

@Data
public class VideoJuegoDto {
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Long precio;
    private Long consolaId;
    private Set<Long> generosIds;
}
