package com.devco.eli.videojuegos.genero.dominio.port;

import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.dto.GeneroDto;

import java.util.List;
import java.util.Set;

public interface IGeneroService {

    Genero getById(Long id);

    List<Genero> getAll();

    Set<Genero> getAllByIds(Set<Long> ids);

    Genero createOrUpdate(GeneroDto dto);

    void delete(Long id);
}
