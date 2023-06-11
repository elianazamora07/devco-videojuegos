package com.devco.eli.videojuegos.consola.infraestructura;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_consola")
public class ConsolaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consolaId;

    @Column(unique = true)
    private String nombreConsola;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
