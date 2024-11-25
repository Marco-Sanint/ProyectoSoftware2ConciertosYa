package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.entity.ArtistaEvento;

public class MapperArtistaEvento {

    // Convertir entidad a DTO
    public static DtoArtistaEvento mapADtoArtistaEvento(ArtistaEvento artistaEvento) {
        return new DtoArtistaEvento(
                artistaEvento.getId(),
                artistaEvento.getArtista().getId(),
                artistaEvento.getEvento().getId()
        );
    }

    // Convertir DTO a entidad
    public static ArtistaEvento mapAArtistaEvento(DtoArtistaEvento dtoArtistaEvento, Artista artista, Evento evento) {
        return new ArtistaEvento(
                dtoArtistaEvento.getId(),
                artista,
                evento
        );
    }
}
