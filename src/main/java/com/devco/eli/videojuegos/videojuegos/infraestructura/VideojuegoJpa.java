package com.devco.eli.videojuegos.videojuegos.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoJpa extends JpaRepository<VideoJuegoEntity, Long> {
}
