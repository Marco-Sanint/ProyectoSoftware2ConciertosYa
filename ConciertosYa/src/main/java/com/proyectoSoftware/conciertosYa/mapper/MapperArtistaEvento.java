package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.entity.ArtistaEvento;

public class MapperArtistaEvento {

    public static DtoArtistaEvento mapADtoArtistaEvento(ArtistaEvento artistaEvento) {
        return new DtoArtistaEvento(
                artistaEvento.getArtista_evento_id(),
                artistaEvento.getArtista() != null ? artistaEvento.getArtista().getArtista_id() : null,
                artistaEvento.getEvento() != null ? artistaEvento.getEvento().getEvento_id() : null
        );
    }

    public static ArtistaEvento mapAArtistaEvento(DtoArtistaEvento dtoArtistaEvento) {
        ArtistaEvento artistaEvento = new ArtistaEvento();
        artistaEvento.setArtista_evento_id(dtoArtistaEvento.getArtista_evento_id());
        return artistaEvento;
    }
}