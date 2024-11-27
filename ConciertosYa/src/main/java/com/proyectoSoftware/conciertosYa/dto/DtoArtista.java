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

    private int artista_id; // Corresponde al campo `id` en Artista
    private String nombre; // Nombre del artista
    private String generoMusical; // Género musical del artista
    private String redesSociales; // Redes sociales del artista
}

