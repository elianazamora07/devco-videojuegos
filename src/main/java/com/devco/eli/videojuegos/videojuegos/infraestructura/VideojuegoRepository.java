package com.devco.eli.videojuegos.videojuegos.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}
