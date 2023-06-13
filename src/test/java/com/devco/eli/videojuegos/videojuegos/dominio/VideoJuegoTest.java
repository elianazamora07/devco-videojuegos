package com.devco.eli.videojuegos.videojuegos.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.genero.dominio.Genero;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class VideoJuegoTest {

    private static final String NOMBRE_INVALIDO = "El nombre ingresado no es valido.";
    private static final String CANTIDAD_INVALIDA = "La cantidad no puede ser menor a 0.";
    private static final String PRECIO_INVALIDO = "El precio no puede ser menor a 0.";
    private static final String CONSOLA_INVALIDA = "El juego debe estar disponible para una consola.";
    private static final String GENEROS_INVALIDOS = "El juego debe tener al menos un genero.";

    @Test
    void isValid_NombreValidoCantidadValidaPrecioValidoConsolaValidaGenerosValidos_NoDebeLanzarExcepciones() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(10);
        videojuego.setPrecio(50L);
        Consola consola = new Consola();
        consola.setId(1L);
        videojuego.setConsola(consola);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);
        videojuego.setGeneros(generos);

        assertDoesNotThrow(() -> videojuego.isValid());
    }

    @Test
    void isValid_NombreVacio_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("");
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(NOMBRE_INVALIDO, exception.getMessage());
    }

    @Test
    void isValid_CantidadNegativa_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(-1);
        videojuego.setPrecio(50L);
        Consola consola = new Consola();
        consola.setId(1L);
        videojuego.setConsola(consola);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);
        videojuego.setGeneros(generos);
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(CANTIDAD_INVALIDA, exception.getMessage());
    }

    @Test
    void isValid_PrecioNegativo_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(10);
        videojuego.setPrecio(-1L);
        Consola consola = new Consola();
        consola.setId(1L);
        videojuego.setConsola(consola);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);
        videojuego.setGeneros(generos);
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(PRECIO_INVALIDO, exception.getMessage());
    }

    @Test
    void isValid_ConsolaNula_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(10);
        videojuego.setPrecio(50L);
        videojuego.setConsola(null);
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);
        videojuego.setGeneros(generos);
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(CONSOLA_INVALIDA, exception.getMessage());
    }

    @Test
    void isValid_ConsolaSinId_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(10);
        videojuego.setPrecio(50L);
        videojuego.setConsola(new Consola());
        Set<Genero> generos = new HashSet<>();
        Genero genero = new Genero();
        genero.setId(1L);
        generos.add(genero);
        videojuego.setGeneros(generos);
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(CONSOLA_INVALIDA, exception.getMessage());
    }

    @Test
    void isValid_GenerosNulos_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(10);
        videojuego.setPrecio(50L);
        Consola consola = new Consola();
        consola.setId(1L);
        videojuego.setConsola(consola);
        videojuego.setGeneros(null);
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(GENEROS_INVALIDOS, exception.getMessage());

    }

    @Test
    void isValid_GenerosVacios_DebeLanzarExcepcion() {
        VideoJuego videojuego = new VideoJuego();
        videojuego.setNombre("Nombre válido");
        videojuego.setCantidad(10);
        videojuego.setPrecio(50L);
        Consola consola = new Consola();
        consola.setId(1L);
        videojuego.setConsola(consola);
        videojuego.setGeneros(new HashSet<>());
        // Resto de atributos válidos para evitar lanzar otras excepciones en este caso

        BadRequest exception = assertThrows(BadRequest.class, () -> videojuego.isValid());
        assertEquals(GENEROS_INVALIDOS, exception.getMessage());
    }
}