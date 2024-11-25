package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.entity.Lugar;
import com.proyectoSoftware.conciertosYa.mapper.MapperEvento;
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

    public ImplServicioEvento(RepoEvento repoEvento, RepoLugar repoLugar) {
        this.repoEvento = repoEvento;
        this.repoLugar = repoLugar;
    }

    @Override
    public DtoEvento crearEvento(DtoEvento dtoEvento) {
        Lugar lugar = repoLugar.findById(dtoEvento.getLugarId())
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));

        Evento evento = MapperEvento.mapAEntidad(dtoEvento, lugar);
        Evento eventoGuardado = repoEvento.save(evento);
        return MapperEvento.mapADto(eventoGuardado);
    }

    @Override
    public DtoEvento obtenerEvento(Integer id) {
        Evento evento = repoEvento.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return MapperEvento.mapADto(evento);
    }

    @Override
    public DtoEvento actualizarEvento(Integer id, DtoEvento dtoEvento) {
        Evento evento = repoEvento.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        Lugar lugar = repoLugar.findById(dtoEvento.getLugarId())
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));

        evento.setNombre(dtoEvento.getNombre());
        evento.setFecha(dtoEvento.getFecha());
        evento.setHora(dtoEvento.getHora());
        evento.setDescripcion(dtoEvento.getDescripcion());
        evento.setGeneroMusical(dtoEvento.getGeneroMusical());
        evento.setEstado(Evento.EstadoEvento.valueOf(dtoEvento.getEstado()));
        evento.setImagenCartel(dtoEvento.getImagenCartel());
        evento.setLugar(lugar);

        Evento eventoActualizado = repoEvento.save(evento);
        return MapperEvento.mapADto(eventoActualizado);
    }

    @Override
    public void eliminarEvento(Integer id) {
        Evento evento = repoEvento.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        repoEvento.delete(evento);
    }

    @Override
    public List<DtoEvento> listarEventos() {
        return repoEvento.findAll().stream()
                .map(MapperEvento::mapADto)
                .collect(Collectors.toList());
    }
}
