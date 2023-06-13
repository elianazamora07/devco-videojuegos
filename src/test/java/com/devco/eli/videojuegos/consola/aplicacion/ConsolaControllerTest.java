package com.devco.eli.videojuegos.consola.aplicacion;

import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.consola.dominio.dto.ConsolaDto;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsolaControllerTest {

    @Mock
    private IConsolaService consolaService;

    @InjectMocks
    private ConsolaController consolaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_DebeRetornarListaDeConsolas() {
        List<Consola> consolas = new ArrayList<>();
        // Agregar consolas a la lista consolas

        when(consolaService.getAll()).thenReturn(consolas);

        List<Consola> result = consolaController.getAll();

        assertEquals(consolas, result);
        verify(consolaService, times(1)).getAll();
    }

    @Test
    void getById_DebeRetornarConsolaPorId() {
        Long consolaId = 1L;
        Consola consola = new Consola();
        // Configurar la consola con el ID correspondiente

        when(consolaService.getById(consolaId)).thenReturn(consola);

        Consola result = consolaController.getById(consolaId);

        assertEquals(consola, result);
        verify(consolaService, times(1)).getById(consolaId);
    }

    @Test
    void saveUpdate_DebeRetornarConsolaGuardada() {
        ConsolaDto dto = new ConsolaDto();
        Consola consolaGuardada = new Consola();
        // Configurar el servicio para retornar la consola guardada

        when(consolaService.createOrUpdate(dto)).thenReturn(consolaGuardada);

        Consola result = consolaController.saveUpdate(dto);

        assertEquals(consolaGuardada, result);
        verify(consolaService, times(1)).createOrUpdate(dto);
    }

    @Test
    void delete_DebeLlamarAlMetodoDeleteDelServicio() {
        Long consolaId = 1L;

        consolaController.delete(consolaId);

        verify(consolaService, times(1)).delete(consolaId);
    }
}
