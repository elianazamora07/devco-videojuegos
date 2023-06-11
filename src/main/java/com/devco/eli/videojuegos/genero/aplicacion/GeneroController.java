package com.devco.eli.videojuegos.genero.aplicacion;

import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.dto.GeneroDto;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tienda/genero")
public class GeneroController {
    @Autowired
    private IGeneroService generoService;

    @GetMapping
    public List<Genero> getAll() {
        return generoService.getAll();
    }

    @GetMapping("/{generoId}")
    public Genero getById(@PathVariable("generoId") Long generoId) {
        return generoService.getById(generoId);
    }

    @PostMapping
    public Genero saveUpdate(@RequestBody GeneroDto dto) {
        return generoService.createOrUpdate(dto);
    }

    @DeleteMapping("/{generoId}")
    public void saveUpdate(@PathVariable("generoId") Long generoId) {
        generoService.delete(generoId);
    }
}
