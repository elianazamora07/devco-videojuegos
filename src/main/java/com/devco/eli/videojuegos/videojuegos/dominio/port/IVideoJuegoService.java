package com.devco.eli.videojuegos.videojuegos.dominio.port;

import com.devco.eli.videojuegos.videojuegos.dominio.VideoJuego;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.UpdateGerosDto;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.VideoJuegoDto;

import java.util.List;

public interface IVideoJuegoService {

    VideoJuego getById(Long id);

    List<VideoJuego> getAll();

    VideoJuego create(VideoJuegoDto dto);

    VideoJuego update(Long id, VideoJuegoDto dto);

    VideoJuego updateGeneros(Long id, UpdateGerosDto dto);

    void delete(Long id);
}
