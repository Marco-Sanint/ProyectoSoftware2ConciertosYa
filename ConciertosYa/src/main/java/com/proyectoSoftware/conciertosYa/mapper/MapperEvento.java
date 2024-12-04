package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.entity.Lugar;  // Importa la clase Lugar
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // Aseguramos que Spring maneje esta clase como un bean
public class MapperEvento {

    private final ServicioLugar servicioLugar;  // Inyectamos el servicio

    // Inyección de dependencia a través del constructor
    @Autowired
    public MapperEvento(ServicioLugar servicioLugar) {
        this.servicioLugar = servicioLugar;
    }

    // Método para mapear de Evento a DtoEvento
    public DtoEvento mapADtoEvento(Evento evento) {
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

    // Método para mapear de DtoEvento a Evento
    public Evento mapAEvento(DtoEvento dtoEvento) {
        Evento evento = new Evento();
        evento.setEvento_id(dtoEvento.getEvento_id());
        evento.setNombre(dtoEvento.getNombre());
        evento.setFecha(dtoEvento.getFecha());
        evento.setHora(dtoEvento.getHora());
        evento.setDescripcion(dtoEvento.getDescripcion());
        evento.setGeneroMusical(dtoEvento.getGeneroMusical());
        evento.setEstado(dtoEvento.getEstado());
        evento.setImagenCartel(dtoEvento.getImagenCartel());

        // Convertimos DtoLugar a Lugar usando MapperLugar
        Lugar lugar = MapperLugar.mapALugar(servicioLugar.getLugar(dtoEvento.getLugarId()));
        evento.setLugar(lugar);

        return evento;
    }
}
