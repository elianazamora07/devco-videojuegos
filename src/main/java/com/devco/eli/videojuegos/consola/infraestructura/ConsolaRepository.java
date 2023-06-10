package com.devco.eli.videojuegos.consola.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolaRepository extends JpaRepository<Consola, Long> {
}
