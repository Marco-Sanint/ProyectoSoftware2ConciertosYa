package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoArtistaEvento {

    private Integer id; // ID de la relación Artista-Evento
    private Integer artistaId; // ID del artista relacionado
    private Integer eventoId; // ID del evento relacionado
}
