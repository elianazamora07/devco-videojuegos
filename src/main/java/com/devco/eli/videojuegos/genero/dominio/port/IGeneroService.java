package com.devco.eli.videojuegos.genero.dominio.port;

import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.dto.GeneroDto;

import java.util.List;

public interface IGeneroService {

    Genero getById(Long id);

    List<Genero> getAll();

    Genero createOrUpdate(GeneroDto dto);

    void delete(Long id);
}
