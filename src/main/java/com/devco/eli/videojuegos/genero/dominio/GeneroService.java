package com.devco.eli.videojuegos.genero.dominio;


import com.devco.eli.videojuegos.genero.infraestructura.Genero;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {


    @Autowired
    GeneroRepository generoRepository;

    public List<Genero> getGeneros() {
        return generoRepository.findAll();
    }

    public Optional<Genero> getGenero(Long id) {
        return generoRepository.findById(id);
    }

    public void saveOrUpdate(Genero genero) {
        generoRepository.save(genero);
    }

    public void delete(Long id) {
        generoRepository.deleteById(id);
    }
}
