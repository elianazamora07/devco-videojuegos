package com.devco.eli.videojuegos.consola.dominio.port;

import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.consola.dominio.dto.ConsolaDto;

import java.util.List;

public interface IConsolaService {

    Consola getById(Long id);

    List<Consola> getAll();

    Consola createOrUpdate(ConsolaDto dto);

    void delete(Long id);
}
