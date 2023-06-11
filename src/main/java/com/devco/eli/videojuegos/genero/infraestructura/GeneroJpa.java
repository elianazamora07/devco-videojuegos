package com.devco.eli.videojuegos.genero.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroJpa extends JpaRepository<GeneroEntity, Long> {

    Optional<GeneroEntity> findByNombreGenero(String nombreGenero);
}
