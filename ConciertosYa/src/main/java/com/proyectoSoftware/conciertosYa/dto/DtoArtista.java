package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoArtista {

    private int artista_id;
    private String nombre;
    private String genero_musical;
    private String redes_sociales;
}
