package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.entity.Lugar;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperEvento;
import com.proyectoSoftware.conciertosYa.mapper.MapperLugar;
import com.proyectoSoftware.conciertosYa.repository.RepoEvento;
import com.proyectoSoftware.conciertosYa.repository.RepoLugar;
import com.proyectoSoftware.conciertosYa.service.ServicioEvento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioEvento implements ServicioEvento {

    private final RepoEvento repoEvento;
    private final RepoLugar repoLugar;
    private final MapperEvento mapperEvento;  // Inyectamos MapperEvento

    @Override
    public DtoEvento crearEvento(DtoEvento dtoEvento, DtoLugar dtoLugar) {
        Lugar lugar = MapperLugar.mapALugar(dtoLugar);

        Evento evento = mapperEvento.mapAEvento(dtoEvento);  // Usamos el objeto inyectado para llamar al método no estático
        evento.setLugar(lugar);

        return mapperEvento.mapADtoEvento(repoEvento.save(evento));
    }

    @Override
    public DtoEvento getEvento(Integer evento_id) {
        Evento evento = repoEvento.findById(evento_id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado"));
        return mapperEvento.mapADtoEvento(evento);
    }

    @Override
    public List<DtoEvento> getAllEventos() {
        return repoEvento.findAll().stream()
                .map(mapperEvento::mapADtoEvento)
                .collect(Collectors.toList());
    }

    @Override
    public DtoEvento updateEvento(Integer evento_id, DtoEvento updateEvento) {
        Evento evento = repoEvento.findById(evento_id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado"));

        evento.setNombre(updateEvento.getNombre());
        evento.setFecha(updateEvento.getFecha());
        evento.setHora(updateEvento.getHora());
        evento.setDescripcion(updateEvento.getDescripcion());
        evento.setGeneroMusical(updateEvento.getGeneroMusical());
        evento.setEstado(updateEvento.getEstado());
        evento.setImagenCartel(updateEvento.getImagenCartel());

        return mapperEvento.mapADtoEvento(repoEvento.save(evento));
    }

    @Override
    public void deleteEvento(Integer evento_id) {
        if (!repoEvento.existsById(evento_id)) {
            throw new ResourceNotFoundException("Evento no encontrado");
        }
        repoEvento.deleteById(evento_id);
    }
}
