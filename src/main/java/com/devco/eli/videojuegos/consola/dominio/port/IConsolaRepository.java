package com.devco.eli.videojuegos.consola.dominio.port;

import com.devco.eli.videojuegos.consola.dominio.Consola;

import java.util.List;
import java.util.Optional;

public interface IConsolaRepository {

    Optional<Consola> getById(Long id);

    Optional<Consola> getByname(String name);

    List<Consola> getAll();

    Consola save(Consola consola);

    void deleteById(Long id);
}
