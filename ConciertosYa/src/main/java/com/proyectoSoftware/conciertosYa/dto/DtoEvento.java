package com.proyectoSoftware.conciertosYa.dto;

import com.proyectoSoftware.conciertosYa.entity.Evento.EstadoEvento;
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

    private Integer evento_id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private String generoMusical;
    private EstadoEvento estado;
    private String imagenCartel;
    private Integer lugarId;
}