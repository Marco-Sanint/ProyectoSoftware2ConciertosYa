package com.proyectoSoftware.conciertosYa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artista_id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "genero_musical", length = 100)
    private String generoMusical;

    @Column(name = "redes_sociales", columnDefinition = "TEXT")
    private String redesSociales;
}
