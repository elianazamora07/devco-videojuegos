package com.devco.eli.videojuegos.videojuegos.dominio.dto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateGerosDto {
    List<Long> generosIds;
}
