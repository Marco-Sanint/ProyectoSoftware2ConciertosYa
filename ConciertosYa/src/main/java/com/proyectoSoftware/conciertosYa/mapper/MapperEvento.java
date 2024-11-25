package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.entity.Lugar;

public class MapperEvento {

    public static DtoEvento mapADto(Evento evento) {
        return new DtoEvento(
                evento.getId(),
                evento.getNombre(),
                evento.getFecha(),
                evento.getHora(),
                evento.getDescripcion(),
                evento.getGeneroMusical(),
                evento.getEstado().name(),
                evento.getImagenCartel(),
                evento.getLugar() != null ? evento.getLugar().getId() : null
        );
    }

    public static Evento mapAEntidad(DtoEvento dtoEvento, Lugar lugar) {
        return new Evento(
                dtoEvento.getId(),
                dtoEvento.getNombre(),
                dtoEvento.getFecha(),
                dtoEvento.getHora(),
                dtoEvento.getDescripcion(),
                dtoEvento.getGeneroMusical(),
                Evento.EstadoEvento.valueOf(dtoEvento.getEstado()),
                dtoEvento.getImagenCartel(),
                lugar
        );
    }
}
