package com.devco.eli.videojuegos.genero.aplicacion;

import com.devco.eli.videojuegos.genero.dominio.GeneroService;
import com.devco.eli.videojuegos.genero.infraestructura.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tienda/genero")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping

    public List<Genero> getAll() {
        return generoService.getGeneros();
    }

    @GetMapping("/{generoId}")
    public Optional<Genero> getById(@PathVariable("generoId") Long generoId) {
        return generoService.getGenero(generoId);
    }

    @PostMapping
    public Genero saveUpdate(@RequestBody Genero genero) {
        generoService.saveOrUpdate(genero);
        return genero;
    }

    @DeleteMapping("/{generoId}")
    public void saveUpdate(@PathVariable("generoId") Long generoId) {
        generoService.delete(generoId);
    }
}
