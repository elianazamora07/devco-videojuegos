package com.devco.eli.videojuegos.videojuegos.dominio;


import com.devco.eli.videojuegos.common.exceptions.exception.NotFoundRequest;
import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaService;
import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroService;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.UpdateGerosDto;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.VideoJuegoDto;
import com.devco.eli.videojuegos.videojuegos.dominio.port.IVideoJuegoRepository;
import com.devco.eli.videojuegos.videojuegos.dominio.port.IVideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class VideojuegoService implements IVideoJuegoService {

    private static final String VIDEO_JUEGO_NO_ENCONTRADO = "No se encontro el video juego con el ID ";

    @Autowired
    private IVideoJuegoRepository videoJuegoRepository;
    @Autowired
    private IGeneroService generoService;
    @Autowired
    private IConsolaService consolaService;

    @Override
    public VideoJuego getById(Long id) {
        Optional<VideoJuego> videoJuego = videoJuegoRepository.getById(id);
        if (videoJuego.isEmpty()) {
            throw new NotFoundRequest(VIDEO_JUEGO_NO_ENCONTRADO + id);
        }
        return videoJuego.get();
    }

    @Override
    public List<VideoJuego> getAll() {
        return videoJuegoRepository.getAll();
    }

    @Override
    public VideoJuego create(VideoJuegoDto dto) {
        VideoJuego videoJuego = new VideoJuego();
        settearInfo(videoJuego, dto);
        return videoJuegoRepository.save(videoJuego);
    }

    @Override
    public VideoJuego update(Long id, VideoJuegoDto dto) {
        VideoJuego videoJuego = this.getById(id);
        settearInfo(videoJuego, dto);
        return videoJuegoRepository.save(videoJuego);
    }

    private void settearInfo(VideoJuego videoJuego, VideoJuegoDto dto) {
        videoJuego.setNombre(dto.getNombre());
        videoJuego.setDescripcion(dto.getDescripcion());
        videoJuego.setCantidad(dto.getCantidad());
        videoJuego.setPrecio(dto.getPrecio());

        Consola consola = consolaService.getById(dto.getConsolaId());
        videoJuego.setConsola(consola);

        Set<Genero> generos = generoService.getAllByIds(dto.getGenerosIds());
        videoJuego.setGeneros(generos);

        videoJuego.isValid();
    }

    @Override
    public VideoJuego updateGeneros(Long id, UpdateGerosDto dto) {
        VideoJuego videoJuego = this.getById(id);
        Set<Genero> generos = generoService.getAllByIds(dto.getGenerosIds());
        videoJuego.setGeneros(generos);

        videoJuego.isValid();
        return videoJuegoRepository.save(videoJuego);
    }

    @Override
    public void delete(Long id) {
        videoJuegoRepository.deleteById(id);
    }
}
