package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;

public class MapperEvento {

    private static ServicioLugar servicioLugar;

    public static DtoEvento mapADtoEvento(Evento evento) {
        return new DtoEvento(
                evento.getEvento_id(),
                evento.getNombre(),
                evento.getFecha(),
                evento.getHora(),
                evento.getDescripcion(),
                evento.getGeneroMusical(),
                evento.getEstado(),
                evento.getImagenCartel(),
                evento.getLugar() != null ? evento.getLugar().getLugar_id() : null
        );
    }

    public static Evento mapAEvento(DtoEvento dtoEvento) {
        Evento evento = new Evento();
        evento.setEvento_id(dtoEvento.getEvento_id());
        evento.setNombre(dtoEvento.getNombre());
        evento.setFecha(dtoEvento.getFecha());
        evento.setHora(dtoEvento.getHora());
        evento.setDescripcion(dtoEvento.getDescripcion());
        evento.setGeneroMusical(dtoEvento.getGeneroMusical());
        evento.setEstado(dtoEvento.getEstado());
        evento.setImagenCartel(dtoEvento.getImagenCartel());
        evento.setLugar(MapperLugar.mapALugar(servicioLugar.getLugar(dtoEvento.getLugarId())));
        return evento;
    }
}