package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.entity.Artista;

public class MapperArtista {

    // Convierte de entidad Artista a DTO
    public static DtoArtista mapADtoArtista(Artista artista) {
        return new DtoArtista(
                artista.getId(),
                artista.getNombre(),
                artista.getGeneroMusical(),
                artista.getRedesSociales()
        );
    }

    // Convierte de DTO a entidad Artista
    public static Artista mapAArtista(DtoArtista dtoArtista) {
        return new Artista(
                dtoArtista.getId(),
                dtoArtista.getNombre(),
                dtoArtista.getGeneroMusical(),
                dtoArtista.getRedesSociales()
        );
    }
}
