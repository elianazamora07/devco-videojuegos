package com.devco.eli.videojuegos.videojuegos.aplicacion;

import com.devco.eli.videojuegos.videojuegos.dominio.VideoJuego;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.UpdateGerosDto;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.VideoJuegoDto;
import com.devco.eli.videojuegos.videojuegos.dominio.port.IVideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tienda/videojuegos")
public class VideojuegoController {
    @Autowired
    private IVideoJuegoService videojuegoService;

    @GetMapping
    public List<VideoJuego> getAll() {
        return videojuegoService.getAll();
    }

    @GetMapping("/{videojuegoId}")
    public VideoJuego getById(@PathVariable("videojuegoId") Long videojuegoId) {
        return videojuegoService.getById(videojuegoId);
    }

    @PostMapping
    public VideoJuego create(@RequestBody VideoJuegoDto dto) {
        return videojuegoService.create(dto);
    }

    @PutMapping("/{videojuegoId}")
    public VideoJuego update(@PathVariable("videojuegoId") Long videojuegoId, @RequestBody VideoJuegoDto dto) {
        return videojuegoService.update(videojuegoId, dto);
    }

    @PatchMapping("/{videojuegoId}")
    public VideoJuego updateGeneros(@PathVariable("videojuegoId") Long videojuegoId, @RequestBody UpdateGerosDto dto) {
        return videojuegoService.updateGeneros(videojuegoId, dto);
    }

    @DeleteMapping("/{videojuegoId}")
    public void delete(@PathVariable("videojuegoId") Long videojuegoId) {
        videojuegoService.delete(videojuegoId);
    }
}
