package com.devco.eli.videojuegos.videojuegos.infraestructura;

import com.devco.eli.videojuegos.consola.infraestructura.ConsolaEntity;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_videojuego")
public class VideoJuegoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long juegoId;

    private String nombreJuego;

    private String descripcion;

    private Integer cantidad;

    private Long precio;

    @ManyToOne()
    private ConsolaEntity consolaEntity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "juegos_generos",
            joinColumns = @JoinColumn(
                    name = "juego_id", referencedColumnName = "juegoId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genero_id", referencedColumnName = "generoId"
            )
    )
    private Set<GeneroEntity> generosEntity = new HashSet<>();
}
