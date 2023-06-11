package com.devco.eli.videojuegos.videojuegos.dominio.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateVideojuego {
    private String nombreJuego;
    private List<Long> genero;
    private String descripcion;
    private Long consolaId;
    private Integer cantidad;
    private Long precio;
}
