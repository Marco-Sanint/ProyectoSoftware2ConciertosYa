package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.entity.Artista;
import com.proyectoSoftware.conciertosYa.entity.ArtistaEvento;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.mapper.MapperArtistaEvento;
import com.proyectoSoftware.conciertosYa.repository.RepoArtista;
import com.proyectoSoftware.conciertosYa.repository.RepoArtistaEvento;
import com.proyectoSoftware.conciertosYa.repository.RepoEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioArtistaEvento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioArtistaEvento implements ServicioArtistaEvento {

    private final RepoArtistaEvento repoArtistaEvento;
    private final RepoArtista repoArtista;
    private final RepoEvento repoEvento;

    @Override
    public DtoArtistaEvento crearArtistaEvento(DtoArtistaEvento dtoArtistaEvento) {
        Artista artista = repoArtista.findById(dtoArtistaEvento.getArtistaId())
                .orElseThrow(() -> new RuntimeException("Artista no encontrado"));
        Evento evento = repoEvento.findById(dtoArtistaEvento.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        ArtistaEvento artistaEvento = MapperArtistaEvento.mapAArtistaEvento(dtoArtistaEvento, artista, evento);
        ArtistaEvento artistaEventoGuardado = repoArtistaEvento.save(artistaEvento);
        return MapperArtistaEvento.mapADtoArtistaEvento(artistaEventoGuardado);
    }

    @Override
    public DtoArtistaEvento getArtistaEvento(Integer id) {
        ArtistaEvento artistaEvento = repoArtistaEvento.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación Artista-Evento no encontrada"));
        return MapperArtistaEvento.mapADtoArtistaEvento(artistaEvento);
    }

    @Override
    public void eliminarArtistaEvento(Integer id) {
        ArtistaEvento artistaEvento = repoArtistaEvento.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación Artista-Evento no encontrada"));
        repoArtistaEvento.delete(artistaEvento);
    }

    @Override
    public List<DtoArtistaEvento> listarArtistasEventos() {
        return repoArtistaEvento.findAll().stream()
                .map(MapperArtistaEvento::mapADtoArtistaEvento)
                .collect(Collectors.toList());
    }
}
