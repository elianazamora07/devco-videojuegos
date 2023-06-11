package com.devco.eli.videojuegos.videojuegos.infraestructura;

import com.devco.eli.videojuegos.consola.infraestructura.ConsolaEntity;
import com.devco.eli.videojuegos.genero.infraestructura.GeneroEntity;
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
    private List<GeneroEntity> generoEntity;

    private String descripcion;

    @ManyToOne()
    private ConsolaEntity consolaEntity;

    private Integer cantidad;

    private Long precio;
}
