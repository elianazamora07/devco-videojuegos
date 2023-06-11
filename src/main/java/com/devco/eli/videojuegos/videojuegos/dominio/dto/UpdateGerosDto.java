package com.devco.eli.videojuegos.videojuegos.dominio.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UpdateGerosDto {
    Set<Long> generosIds;
}
