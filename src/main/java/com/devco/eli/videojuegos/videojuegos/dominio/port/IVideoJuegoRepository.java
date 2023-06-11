package com.devco.eli.videojuegos.videojuegos.dominio.port;

import com.devco.eli.videojuegos.videojuegos.dominio.VideoJuego;

import java.util.List;
import java.util.Optional;

public interface IVideoJuegoRepository {

    Optional<VideoJuego> getById(Long id);

    List<VideoJuego> getAll();

    VideoJuego save(VideoJuego domain);

    void deleteById(Long id);
}
