package com.devco.eli.videojuegos.genero.infraestructura;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_genero")
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generoId;

    @Column(unique = true)
    private String nombreGenero;
}
