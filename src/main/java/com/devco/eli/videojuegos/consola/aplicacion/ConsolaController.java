package com.devco.eli.videojuegos.consola.aplicacion;

import com.devco.eli.videojuegos.consola.dominio.ConsolaService;
import com.devco.eli.videojuegos.consola.infraestructura.Consola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tienda/consola")
public class ConsolaController {
    @Autowired
    private ConsolaService consolaService;

    @GetMapping

    public List<Consola> getAll() {
        return consolaService.getConsolas();
    }

    @GetMapping("/{consolaId}")
    public Optional<Consola> getById(@PathVariable("consolaId") Long consolaId) {
        return consolaService.getConsola(consolaId);
    }

    @PostMapping
    public Consola saveUpdate(@RequestBody Consola consola) {
        consolaService.saveOrUpdate(consola);
        return consola;
    }

    @DeleteMapping("/{consolaId}")
    public void saveUpdate(@PathVariable("consolaId") Long consolaId) {
        consolaService.delete(consolaId);
    }
}
