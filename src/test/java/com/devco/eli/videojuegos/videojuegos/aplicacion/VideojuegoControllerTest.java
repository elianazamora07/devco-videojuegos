package com.devco.eli.videojuegos.videojuegos.aplicacion;

import com.devco.eli.videojuegos.videojuegos.dominio.VideoJuego;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.UpdateGerosDto;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.VideoJuegoDto;
import com.devco.eli.videojuegos.videojuegos.dominio.port.IVideoJuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class VideojuegoControllerTest {

    @Mock
    private IVideoJuegoService videojuegoService;

    @InjectMocks
    private VideojuegoController videojuegoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_DebeRetornarListaDeVideojuegos() {
        List<VideoJuego> videojuegos = new ArrayList<>();
        // Agregar videojuegos a la lista videojuegos

        when(videojuegoService.getAll()).thenReturn(videojuegos);

        List<VideoJuego> result = videojuegoController.getAll();

        assertEquals(videojuegos, result);
        verify(videojuegoService, times(1)).getAll();
    }

    @Test
    void getById_DebeRetornarVideojuegoPorId() {
        Long videojuegoId = 1L;
        VideoJuego videojuego = new VideoJuego();
        // Configurar el videojuego con el ID correspondiente

        when(videojuegoService.getById(videojuegoId)).thenReturn(videojuego);

        VideoJuego result = videojuegoController.getById(videojuegoId);

        assertEquals(videojuego, result);
        verify(videojuegoService, times(1)).getById(videojuegoId);
    }

    @Test
    void create_DebeRetornarVideojuegoCreado() {
        VideoJuegoDto dto = new VideoJuegoDto();
        VideoJuego videojuegoCreado = new VideoJuego();
        // Configurar el servicio para retornar el videojuego creado

        when(videojuegoService.create(dto)).thenReturn(videojuegoCreado);

        VideoJuego result = videojuegoController.create(dto);

        assertEquals(videojuegoCreado, result);
        verify(videojuegoService, times(1)).create(dto);
    }

    @Test
    void update_DebeRetornarVideojuegoActualizado() {
        Long videojuegoId = 1L;
        VideoJuegoDto dto = new VideoJuegoDto();
        VideoJuego videojuegoActualizado = new VideoJuego();
        // Configurar el servicio para retornar el videojuego actualizado

        when(videojuegoService.update(videojuegoId, dto)).thenReturn(videojuegoActualizado);

        VideoJuego result = videojuegoController.update(videojuegoId, dto);

        assertEquals(videojuegoActualizado, result);
        verify(videojuegoService, times(1)).update(videojuegoId, dto);
    }

    @Test
    void updateGeneros_DebeRetornarVideojuegoConGenerosActualizados() {
        Long videojuegoId = 1L;
        UpdateGerosDto dto = new UpdateGerosDto();
        VideoJuego videojuegoConGenerosActualizados = new VideoJuego();
        // Configurar el servicio para retornar el videojuego con los generos actualizados

        when(videojuegoService.updateGeneros(videojuegoId, dto)).thenReturn(videojuegoConGenerosActualizados);

        VideoJuego result = videojuegoController.updateGeneros(videojuegoId, dto);

        assertEquals(videojuegoConGenerosActualizados, result);
        verify(videojuegoService, times(1)).updateGeneros(videojuegoId, dto);
    }

    @Test
    void delete_DebeLlamarAlMetodoDeleteDelServicio() {
        Long videojuegoId = 1L;

        videojuegoController.delete(videojuegoId);

        verify(videojuegoService, times(1)).delete(videojuegoId);
    }
}
