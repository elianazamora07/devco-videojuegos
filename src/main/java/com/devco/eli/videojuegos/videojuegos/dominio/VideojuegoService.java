package com.devco.eli.videojuegos.videojuegos.dominio;


import com.devco.eli.videojuegos.consola.infraestructura.ConsolaEntity;
import com.devco.eli.videojuegos.consola.infraestructura.ConsolaJpa;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroEntity;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroJpa;
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
    private GeneroJpa generoJpa;
    @Autowired
    private ConsolaJpa consolaJpa;

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

        ConsolaEntity consolaEntity = consolaJpa.findById(createVideojuego.getConsolaId()).get();
        videojuego.setConsolaEntity(consolaEntity);

        List<GeneroEntity> generoEntities = generoJpa.findAllById(createVideojuego.getGenero());
        videojuego.setGeneroEntity(generoEntities);

        return videojuegoRepository.save(videojuego);
    }

    public void delete(Long id) {
        videojuegoRepository.deleteById(id);
    }
}
