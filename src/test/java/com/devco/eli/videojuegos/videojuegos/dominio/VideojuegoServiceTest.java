package com.devco.eli.videojuegos.videojuegos.dominio;


import com.devco.eli.videojuegos.common.exceptions.exception.NotFoundRequest;
import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaService;
import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroService;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.UpdateGerosDto;
import com.devco.eli.videojuegos.videojuegos.dominio.dto.VideoJuegoDto;
import com.devco.eli.videojuegos.videojuegos.dominio.port.IVideoJuegoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class VideojuegoServiceTest {

    @Mock
    private IVideoJuegoRepository videoJuegoRepository;
    @Mock
    private IGeneroService generoService;
    @Mock
    private IConsolaService consolaService;

    @InjectMocks
    private VideojuegoService videojuegoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_DebeRetornarVideoJuegoPorId_CuandoExiste() {
        Long videoJuegoId = 1L;
        VideoJuego videoJuego = new VideoJuego();
        // Configurar el repositorio para retornar el video juego correspondiente al ID

        when(videoJuegoRepository.getById(videoJuegoId)).thenReturn(Optional.of(videoJuego));

        VideoJuego result = videojuegoService.getById(videoJuegoId);

        assertEquals(videoJuego, result);
        verify(videoJuegoRepository, times(1)).getById(videoJuegoId);
    }

    @Test
    void getById_DebeLanzarNotFoundRequest_CuandoNoExisteVideoJuego() {
        Long videoJuegoId = 1L;
        // Configurar el repositorio para retornar Optional.empty()

        when(videoJuegoRepository.getById(videoJuegoId)).thenReturn(Optional.empty());

        assertThrows(NotFoundRequest.class, () -> videojuegoService.getById(videoJuegoId));
        verify(videoJuegoRepository, times(1)).getById(videoJuegoId);
    }

    @Test
    void getAll_DebeRetornarListaDeVideoJuegos() {
        List<VideoJuego> videoJuegos = new ArrayList<>();
        // Agregar video juegos a la lista de video juegos

        when(videoJuegoRepository.getAll()).thenReturn(videoJuegos);

        List<VideoJuego> result = videojuegoService.getAll();

        assertEquals(videoJuegos, result);
        verify(videoJuegoRepository, times(1)).getAll();
    }

    @Test
    void create_DebeRetornarVideoJuegoCreado() {
        VideoJuegoDto dto = new VideoJuegoDto();
        dto.setNombre("Nombre válido");
        dto.setCantidad(10);
        dto.setPrecio(50L);
        dto.setConsolaId(1L);
        Set<Long> generosIds = new HashSet<>();
        generosIds.add(1L);
        dto.setGenerosIds(generosIds);

        Consola consola = new Consola();
        consola.setId(1L);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);
        // Configurar los mocks para obtener la consola y los generos correspondientes al ID

        VideoJuego videoJuegoCreado = new VideoJuego();
        // Configurar el repositorio para retornar el video juego creado

        when(consolaService.getById(dto.getConsolaId())).thenReturn(consola);
        when(generoService.getAllByIds(dto.getGenerosIds())).thenReturn(generos);
        when(videoJuegoRepository.save(any(VideoJuego.class))).thenReturn(videoJuegoCreado);

        VideoJuego result = videojuegoService.create(dto);

        assertEquals(videoJuegoCreado, result);
        verify(consolaService, times(1)).getById(dto.getConsolaId());
        verify(generoService, times(1)).getAllByIds(dto.getGenerosIds());
        verify(videoJuegoRepository, times(1)).save(any(VideoJuego.class));
    }

    @Test
    void update_DebeRetornarVideoJuegoActualizado() {
        Long videoJuegoId = 1L;
        VideoJuegoDto dto = new VideoJuegoDto();
        dto.setNombre("Nombre válido");
        dto.setCantidad(10);
        dto.setPrecio(50L);
        dto.setConsolaId(1L);
        Set<Long> generosIds = new HashSet<>();
        generosIds.add(1L);
        dto.setGenerosIds(generosIds);
        // Configurar el repositorio para retornar el video juego correspondiente al ID
        Consola consola = new Consola();
        consola.setId(1L);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);

        VideoJuego videoJuego = new VideoJuego();
        videoJuego.setNombre("Nombre válido");
        videoJuego.setCantidad(1);
        videoJuego.setPrecio(50L);
        videoJuego.setConsola(consola);
        videoJuego.setGeneros(generos);

        // Configurar el repositorio para retornar el video juego correspondiente al ID

        VideoJuego videoJuegoActualizado = new VideoJuego();
        // Configurar los mocks para obtener la consola y los generos correspondientes al ID
        // Configurar el repositorio para retornar el video juego actualizado

        when(videoJuegoRepository.getById(videoJuegoId)).thenReturn(Optional.of(new VideoJuego()));
        when(consolaService.getById(dto.getConsolaId())).thenReturn(consola);
        when(generoService.getAllByIds(dto.getGenerosIds())).thenReturn(generos);
        when(videoJuegoRepository.save(any(VideoJuego.class))).thenReturn(videoJuegoActualizado);

        VideoJuego result = videojuegoService.update(videoJuegoId, dto);

        assertEquals(videoJuegoActualizado, result);
        verify(videoJuegoRepository, times(1)).getById(videoJuegoId);
        verify(consolaService, times(1)).getById(dto.getConsolaId());
        verify(generoService, times(1)).getAllByIds(dto.getGenerosIds());
        verify(videoJuegoRepository, times(1)).save(any(VideoJuego.class));
    }

    @Test
    void updateGeneros_DebeRetornarVideoJuegoConGenerosActualizados() {
        Long videoJuegoId = 1L;
        UpdateGerosDto dto = new UpdateGerosDto();
        Set<Long> generosIds = new HashSet<>();
        generosIds.add(1L);
        dto.setGenerosIds(generosIds);
        // Configurar el repositorio para retornar el video juego correspondiente al ID
        Consola consola = new Consola();
        consola.setId(1L);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);

        VideoJuego videoJuego = new VideoJuego();
        videoJuego.setNombre("Nombre válido");
        videoJuego.setCantidad(1);
        videoJuego.setPrecio(50L);
        videoJuego.setConsola(consola);
        videoJuego.setGeneros(generos);
        // Configurar el servicio de genero para retornar el conjunto de generos correspondientes a los IDs
        // Configurar el repositorio para retornar el video juego actualizado

        when(videoJuegoRepository.getById(videoJuegoId)).thenReturn(Optional.of(videoJuego));
        when(generoService.getAllByIds(dto.getGenerosIds())).thenReturn(generos);
        when(videoJuegoRepository.save(any(VideoJuego.class))).thenReturn(videoJuego);

        VideoJuego result = videojuegoService.updateGeneros(videoJuegoId, dto);

        assertEquals(videoJuego, result);
        verify(videoJuegoRepository, times(1)).getById(videoJuegoId);
        verify(generoService, times(1)).getAllByIds(dto.getGenerosIds());
        verify(videoJuegoRepository, times(1)).save(any(VideoJuego.class));
    }

    @Test
    void delete_DebeLlamarAlMetodoDeleteDelRepositorio() {
        Long videoJuegoId = 1L;

        videojuegoService.delete(videoJuegoId);

        verify(videoJuegoRepository, times(1)).deleteById(videoJuegoId);
    }


}
