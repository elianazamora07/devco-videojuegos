package com.devco.eli.videojuegos.consola.infraestructura;

import com.devco.eli.videojuegos.consola.dominio.Consola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ConsolaRepositoryTest {

    @Mock
    private ConsolaJpa consolaJpa;

    @InjectMocks
    private ConsolaRepository consolaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reset();
    }

    @Test
    void getById_DebeRetornarConsolaExistente() {
        Long consolaId = 1L;
        ConsolaEntity consolaEntity = new ConsolaEntity();
        consolaEntity.setConsolaId(consolaId);
        consolaEntity.setNombreConsola("PlayStation");

        when(consolaJpa.findById(consolaId)).thenReturn(Optional.of(consolaEntity));

        Optional<Consola> result = consolaRepository.getById(consolaId);

        assertTrue(result.isPresent());
        assertEquals(consolaId, result.get().getId());
        assertEquals("PlayStation", result.get().getNombre());
        verify(consolaJpa, times(1)).findById(consolaId);
    }

    @Test
    void getById_DebeRetornarOptionalVacioCuandoNoExisteConsola() {
        Long consolaId = 1L;

        when(consolaJpa.findById(consolaId)).thenReturn(Optional.empty());

        Optional<Consola> result = consolaRepository.getById(consolaId);

        assertFalse(result.isPresent());
        verify(consolaJpa, times(1)).findById(consolaId);
    }

    @Test
    void getByname_DebeRetornarConsolaExistente() {
        String consolaName = "PlayStation";
        ConsolaEntity consolaEntity = new ConsolaEntity();
        consolaEntity.setConsolaId(1L);
        consolaEntity.setNombreConsola(consolaName);

        when(consolaJpa.findByNombreConsola(consolaName)).thenReturn(Optional.of(consolaEntity));

        Optional<Consola> result = consolaRepository.getByname(consolaName);

        assertTrue(result.isPresent());
        assertEquals(consolaName, result.get().getNombre());
        verify(consolaJpa, times(1)).findByNombreConsola(consolaName);
    }

    @Test
    void getByname_DebeRetornarOptionalVacioCuandoNoExisteConsola() {
        String consolaName = "PlayStation";

        when(consolaJpa.findByNombreConsola(consolaName)).thenReturn(Optional.empty());

        Optional<Consola> result = consolaRepository.getByname(consolaName);

        assertFalse(result.isPresent());
        verify(consolaJpa, times(1)).findByNombreConsola(consolaName);
    }

    @Test
    void getAll_DebeRetornarListaDeConsolas() {
        ConsolaEntity consolaEntity1 = new ConsolaEntity();
        consolaEntity1.setConsolaId(1L);
        consolaEntity1.setNombreConsola("PlayStation");

        ConsolaEntity consolaEntity2 = new ConsolaEntity();
        consolaEntity2.setConsolaId(2L);
        consolaEntity2.setNombreConsola("Xbox");

        List<ConsolaEntity> consolaEntities = new ArrayList<>();
        consolaEntities.add(consolaEntity1);
        consolaEntities.add(consolaEntity2);

        when(consolaJpa.findAll()).thenReturn(consolaEntities);

        List<Consola> result = consolaRepository.getAll();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("PlayStation", result.get(0).getNombre());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Xbox", result.get(1).getNombre());
        verify(consolaJpa, times(1)).findAll();
    }

    @Test
    void save_DebeRetornarConsolaGuardada() {
        Consola consola = new Consola();
        consola.setNombre("PlayStation");

        ConsolaEntity consolaEntityToSave = new ConsolaEntity();
        consolaEntityToSave.setNombreConsola("PlayStation");

        ConsolaEntity savedEntity = new ConsolaEntity();
        savedEntity.setConsolaId(1L);
        savedEntity.setNombreConsola("PlayStation");

        when(consolaJpa.save(any(ConsolaEntity.class))).thenReturn(savedEntity);

        Consola result = consolaRepository.save(consola);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("PlayStation", result.getNombre());
        verify(consolaJpa, times(1)).save(any(ConsolaEntity.class));
    }

    @Test
    void deleteById_DebeEliminarConsola() {
        Long consolaId = 1L;

        consolaRepository.deleteById(consolaId);

        verify(consolaJpa, times(1)).deleteById(consolaId);
    }
}
