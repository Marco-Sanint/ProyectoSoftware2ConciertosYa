package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.entity.Artista;

public class MapperArtista {

    public static Artista mapAArtista(DtoArtista dtoArtista) {
        return new Artista(
                dtoArtista.getArtista_id(),
                dtoArtista.getNombre(),
                dtoArtista.getGeneroMusical(),
                dtoArtista.getRedesSociales()
        );
    }

    public static DtoArtista mapADtoArtista(Artista artista) {
        return new DtoArtista(
                artista.getArtista_id(),
                artista.getNombre(),
                artista.getGeneroMusical(),
                artista.getRedesSociales()
        );
    }
}