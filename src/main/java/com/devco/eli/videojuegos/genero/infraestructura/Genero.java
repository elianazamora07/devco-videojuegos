package com.devco.eli.videojuegos.genero.infraestructura;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generoId;

    private String nombreGenero;

}
