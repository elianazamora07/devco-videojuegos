package com.devco.eli.videojuegos.videojuegos.infraestructura;

import com.devco.eli.videojuegos.consola.infraestructura.ConsolaEntity;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "generoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneroEntity> generosEntity;
}
