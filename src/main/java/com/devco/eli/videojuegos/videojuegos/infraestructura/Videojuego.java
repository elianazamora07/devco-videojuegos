package com.devco.eli.videojuegos.videojuegos.infraestructura;

import com.devco.eli.videojuegos.consola.infraestructura.ConsolaEntity;
import com.devco.eli.videojuegos.genero.infraestructura.Genero;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videojuegoId;

    private String nombreJuego;

    @OneToMany(mappedBy = "generoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Genero> genero;

    private String descripcion;

    @ManyToOne()
    private ConsolaEntity consolaEntity;

    private Integer cantidad;

    private Long precio;
}
