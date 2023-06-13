package com.devco.eli.videojuegos.genero.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.NotFoundRequest;
import com.devco.eli.videojuegos.genero.dominio.dto.GeneroDto;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GeneroServiceTest {

    @Mock
    private IGeneroRepository generoRepository;

    @InjectMocks
    private GeneroService generoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_DebeRetornarGeneroPorId_CuandoExiste() {
        Long generoId = 1L;
        Genero genero = new Genero();
        // Configurar el repositorio para retornar el genero correspondiente al ID

        when(generoRepository.getById(generoId)).thenReturn(Optional.of(genero));

        Genero result = generoService.getById(generoId);

        assertEquals(genero, result);
        verify(generoRepository, times(1)).getById(generoId);
    }

    @Test
    void getById_DebeLanzarNotFoundRequest_CuandoNoExisteGenero() {
        Long generoId = 1L;
        // Configurar el repositorio para retornar Optional.empty()

        when(generoRepository.getById(generoId)).thenReturn(Optional.empty());

        assertThrows(NotFoundRequest.class, () -> generoService.getById(generoId));
        verify(generoRepository, times(1)).getById(generoId);
    }

    @Test
    void getAll_DebeRetornarListaDeGeneros() {
        List<Genero> generos = new ArrayList<>();
        // Agregar generos a la lista de generos

        when(generoRepository.getAll()).thenReturn(generos);

        List<Genero> result = generoService.getAll();

        assertEquals(generos, result);
        verify(generoRepository, times(1)).getAll();
    }

    @Test
    void getAllByIds_DebeRetornarSetDeGenerosPorIds() {
        Set<Long> generoIds = new HashSet<>(Arrays.asList(1L, 2L, 3L));
        List<Genero> generos = new ArrayList<>();
        // Configurar el repositorio para retornar los generos correspondientes a los IDs

        when(generoRepository.getAllByIds(generoIds)).thenReturn(generos);

        Set<Genero> result = generoService.getAllByIds(generoIds);

        assertEquals(new HashSet<>(generos), result);
        verify(generoRepository, times(1)).getAllByIds(generoIds);
    }

    @Test
    void createOrUpdate_DebeRetornarGeneroCreadoOActualizado() {
        GeneroDto dto = new GeneroDto();
        dto.setNombre("Aventura");
        Genero generoCreadoOActualizado = new Genero();
        // Configurar el repositorio para retornar el genero creado o actualizado

        when(generoRepository.getByname(dto.getNombre())).thenReturn(Optional.empty());
        when(generoRepository.save(any(Genero.class))).thenReturn(generoCreadoOActualizado);

        Genero result = generoService.createOrUpdate(dto);

        assertEquals(generoCreadoOActualizado, result);
        verify(generoRepository, times(1)).getByname(dto.getNombre());
        verify(generoRepository, times(1)).save(any(Genero.class));
    }

    @Test
    void delete_DebeLlamarAlMetodoDeleteDelRepositorio() {
        Long generoId = 1L;

        generoService.delete(generoId);

        verify(generoRepository, times(1)).deleteById(generoId);
    }
}
