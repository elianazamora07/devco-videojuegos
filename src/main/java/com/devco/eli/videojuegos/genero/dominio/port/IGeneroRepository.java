package com.devco.eli.videojuegos.genero.dominio.port;

import com.devco.eli.videojuegos.genero.dominio.Genero;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IGeneroRepository {
    Optional<Genero> getById(Long id);

    Optional<Genero> getByname(String name);

    List<Genero> getAll();

    List<Genero> getAllByIds(Set<Long> ids);

    Genero save(Genero domain);

    void deleteById(Long id);
}
