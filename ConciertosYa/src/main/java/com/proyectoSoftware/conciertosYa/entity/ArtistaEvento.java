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
@Table(name = "Artista_Evento")
public class ArtistaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artista_evento_id;

    @ManyToOne
    @JoinColumn(name = "artista_id", referencedColumnName = "id", nullable = false)
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id", nullable = false)
    private Evento evento;
}
