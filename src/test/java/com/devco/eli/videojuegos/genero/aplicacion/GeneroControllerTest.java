package com.devco.eli.videojuegos.genero.aplicacion;

import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.dto.GeneroDto;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GeneroControllerTest {

    @Mock
    private IGeneroService generoService;

    @InjectMocks
    private GeneroController generoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_DebeRetornarListaDeGeneros() {
        List<Genero> generos = new ArrayList<>();
        // Agregar generos a la lista generos

        when(generoService.getAll()).thenReturn(generos);

        List<Genero> result = generoController.getAll();

        assertEquals(generos, result);
        verify(generoService, times(1)).getAll();
    }

    @Test
    void getById_DebeRetornarGeneroPorId() {
        Long generoId = 1L;
        Genero genero = new Genero();
        // Configurar el genero con el ID correspondiente

        when(generoService.getById(generoId)).thenReturn(genero);

        Genero result = generoController.getById(generoId);

        assertEquals(genero, result);
        verify(generoService, times(1)).getById(generoId);
    }

    @Test
    void saveUpdate_DebeRetornarGeneroGuardado() {
        GeneroDto dto = new GeneroDto();
        Genero generoGuardado = new Genero();
        // Configurar el servicio para retornar el genero guardado

        when(generoService.createOrUpdate(dto)).thenReturn(generoGuardado);

        Genero result = generoController.saveUpdate(dto);

        assertEquals(generoGuardado, result);
        verify(generoService, times(1)).createOrUpdate(dto);
    }

    @Test
    void delete_DebeLlamarAlMetodoDeleteDelServicio() {
        Long generoId = 1L;

        generoController.delete(generoId);

        verify(generoService, times(1)).delete(generoId);
    }
}
