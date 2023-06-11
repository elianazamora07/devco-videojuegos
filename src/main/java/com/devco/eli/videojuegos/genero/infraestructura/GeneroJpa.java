package com.devco.eli.videojuegos.genero.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroJpa extends JpaRepository<GeneroEntity, Long> {

    Optional<GeneroEntity> findByNombreGenero(String nombreGenero);
}
