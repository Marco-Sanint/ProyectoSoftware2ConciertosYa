package com.proyectoSoftware.conciertosYa.dto;

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
public class DtoEvento {
    private Integer id;                // ID del evento
    private String nombre;             // Nombre del evento
    private LocalDate fecha;           // Fecha del evento
    private LocalTime hora;            // Hora del evento
    private String descripcion;        // Descripción del evento
    private String generoMusical;      // Género musical
    private String estado;             // Estado del evento
    private String imagenCartel;       // Imagen del cartel
    private Integer lugarId;           // ID del lugar asociado
}
