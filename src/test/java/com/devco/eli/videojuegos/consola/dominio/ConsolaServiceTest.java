package com.devco.eli.videojuegos.consola.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.NotFoundRequest;
import com.devco.eli.videojuegos.consola.dominio.dto.ConsolaDto;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ConsolaServiceTest {


    @Mock
    private IConsolaRepository consolaRepository;

    @InjectMocks
    private ConsolaService consolaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_DebeRetornarConsolaPorId_CuandoExiste() {
        Long consolaId = 1L;
        Consola consola = new Consola();
        // Configurar el repositorio para retornar la consola correspondiente al ID

        when(consolaRepository.getById(consolaId)).thenReturn(Optional.of(consola));

        Consola result = consolaService.getById(consolaId);

        assertEquals(consola, result);
        verify(consolaRepository, times(1)).getById(consolaId);
    }

    @Test
    void getById_DebeLanzarNotFoundRequest_CuandoNoExisteConsola() {
        Long consolaId = 1L;
        // Configurar el repositorio para retornar Optional.empty()

        when(consolaRepository.getById(consolaId)).thenReturn(Optional.empty());

        assertThrows(NotFoundRequest.class, () -> consolaService.getById(consolaId));
        verify(consolaRepository, times(1)).getById(consolaId);
    }

    @Test
    void getAll_DebeRetornarListaDeConsolas() {
        List<Consola> consolas = new ArrayList<>();
        // Agregar consolas a la lista de consolas

        when(consolaRepository.getAll()).thenReturn(consolas);

        List<Consola> result = consolaService.getAll();

        assertEquals(consolas, result);
        verify(consolaRepository, times(1)).getAll();
    }

    @Test
    void createOrUpdate_DebeRetornarConsolaCreadaOActualizada() {
        ConsolaDto dto = new ConsolaDto();
        dto.setNombre("Nintendo Switch");
        Consola consolaCreadaOActualizada = new Consola();
        // Configurar el repositorio para retornar la consola creada o actualizada

        when(consolaRepository.getByname(dto.getNombre())).thenReturn(Optional.empty());
        when(consolaRepository.save(any(Consola.class))).thenReturn(consolaCreadaOActualizada);

        Consola result = consolaService.createOrUpdate(dto);

        assertEquals(consolaCreadaOActualizada, result);
        verify(consolaRepository, times(1)).getByname(dto.getNombre());
        verify(consolaRepository, times(1)).save(any(Consola.class));
    }

    @Test
    void createOrUpdate_DebeRetornarConsolaActualizada_CuandoExisteConsola() {
        ConsolaDto dto = new ConsolaDto();
        dto.setNombre("Nintendo Switch");
        Consola consolaExistente = new Consola();
        Consola consolaActualizada = new Consola();
        // Configurar el repositorio para retornar la consola existente y la consola actualizada

        when(consolaRepository.getByname(dto.getNombre())).thenReturn(Optional.of(consolaExistente));
        when(consolaRepository.save(any(Consola.class))).thenReturn(consolaActualizada);

        Consola result = consolaService.createOrUpdate(dto);

        assertEquals(consolaActualizada, result);
        verify(consolaRepository, times(1)).getByname(dto.getNombre());
        verify(consolaRepository, times(1)).save(any(Consola.class));
    }

    @Test
    void delete_DebeLlamarAlMetodoDeleteDelRepositorio() {
        Long consolaId = 1L;

        consolaService.delete(consolaId);

        verify(consolaRepository, times(1)).deleteById(consolaId);
    }
}
