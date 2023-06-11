package com.devco.eli.videojuegos.consola.aplicacion;

import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.consola.dominio.dto.ConsolaDto;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tienda/consola")
public class ConsolaController {
    @Autowired
    private IConsolaService consolaService;

    @GetMapping
    public List<Consola> getAll() {
        return consolaService.getAll();
    }

    @GetMapping("/{consolaId}")
    public Consola getById(@PathVariable("consolaId") Long consolaId) {
        return consolaService.getById(consolaId);
    }

    @PostMapping
    public Consola saveUpdate(@RequestBody ConsolaDto dto) {
        return consolaService.createOrUpdate(dto);
    }

    @DeleteMapping("/{consolaId}")
    public void delete(@PathVariable("consolaId") Long consolaId) {
        consolaService.delete(consolaId);
    }
}
