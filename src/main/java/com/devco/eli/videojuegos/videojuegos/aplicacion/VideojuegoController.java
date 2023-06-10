package com.devco.eli.videojuegos.videojuegos.aplicacion;

import com.devco.eli.videojuegos.videojuegos.dominio.VideojuegoService;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.CreateVideojuego;
import com.devco.eli.videojuegos.videojuegos.infraestructura.Videojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tienda/videojuegos")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> getAll() {
        return videojuegoService.getVideojuegos();
    }

    @GetMapping("/{videojuegoId}")
    public Optional<Videojuego> getById(@PathVariable("videojuegoId") Long videojuegoId) {
        return videojuegoService.getVideojuego(videojuegoId);
    }

    @PostMapping
    public Videojuego create(@RequestBody CreateVideojuego createVideojuego) {
        return videojuegoService.create(createVideojuego);

    }

    @DeleteMapping("/{videojuegoId}")
    public void saveUpdate(@PathVariable("videojuegoId") Long videojuegoId) {
        videojuegoService.delete(videojuegoId);
    }
}
