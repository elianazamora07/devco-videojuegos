package com.devco.eli.videojuegos.videojuegos.dominio;


import com.devco.eli.videojuegos.consola.infraestructura.Consola;
import com.devco.eli.videojuegos.consola.infraestructura.ConsolaRepository;
import com.devco.eli.videojuegos.genero.infraestructura.Genero;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroRepository;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.CreateVideojuego;
import com.devco.eli.videojuegos.videojuegos.infraestructura.Videojuego;
import com.devco.eli.videojuegos.videojuegos.infraestructura.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private ConsolaRepository consolaRepository;

    public List<Videojuego> getVideojuegos() {
        return videojuegoRepository.findAll();
    }

    public Optional<Videojuego> getVideojuego(Long id) {
        return videojuegoRepository.findById(id);
    }

    public Videojuego create(CreateVideojuego createVideojuego) {
        Videojuego videojuego = new Videojuego();
        videojuego.setNombreJuego(createVideojuego.getNombreJuego());
        videojuego.setDescripcion(createVideojuego.getDescripcion());
        videojuego.setCantidad(createVideojuego.getCantidad());
        videojuego.setPrecio(createVideojuego.getPrecio());

        Consola consola = consolaRepository.findById(createVideojuego.getConsolaId()).get();
        videojuego.setConsola(consola);

        List<Genero> generos = generoRepository.findAllById(createVideojuego.getGenero());
        videojuego.setGenero(generos);

        return videojuegoRepository.save(videojuego);
    }

    public void delete(Long id) {
        videojuegoRepository.deleteById(id);
    }
}
