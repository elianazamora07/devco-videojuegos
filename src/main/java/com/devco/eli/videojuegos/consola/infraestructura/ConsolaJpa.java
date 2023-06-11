package com.devco.eli.videojuegos.consola.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsolaJpa extends JpaRepository<ConsolaEntity, Long> {

    Optional<ConsolaEntity> findByNombreConsola(String nombreConsola);
}
