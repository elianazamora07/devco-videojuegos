package com.devco.eli.videojuegos.genero.dominio.port;

import com.devco.eli.videojuegos.genero.dominio.Genero;

import java.util.List;
import java.util.Optional;

public interface IGeneroRepository {
    Optional<Genero> getById(Long id);

    Optional<Genero> getByname(String name);

    List<Genero> getAll();

    List<Genero> getAllByIds(List<Long> ids);

    Genero save(Genero domain);

    void deleteById(Long id);
}
