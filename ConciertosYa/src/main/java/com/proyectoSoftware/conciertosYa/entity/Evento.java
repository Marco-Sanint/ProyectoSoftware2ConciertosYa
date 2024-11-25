package com.proyectoSoftware.conciertosYa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evento_id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "genero_musical", length = 100)
    private String generoMusical;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEvento estado;

    @Column(name = "imagen_cartel", length = 255)
    private String imagenCartel;

    @ManyToOne
    @JoinColumn(name = "lugar_id", referencedColumnName = "id")
    private Lugar lugar; // Relación con Lugar

    // Enumeración para el estado del evento
    public enum EstadoEvento {
        PROGRAMADO,
        CANCELADO,
        FINALIZADO
    }
}
