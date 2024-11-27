package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.entity.ArtistaEvento;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperArtistaEvento;
import com.proyectoSoftware.conciertosYa.repository.RepoArtistaEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioArtistaEvento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioArtistaEvento implements ServicioArtistaEvento {

    private final RepoArtistaEvento repoArtistaEvento;

    @Override
    public DtoArtistaEvento createArtistaEvento(DtoArtistaEvento dtoArtistaEvento) {
        ArtistaEvento artistaEvento = MapperArtistaEvento.mapAArtistaEvento(dtoArtistaEvento);
        ArtistaEvento savedArtistaEvento = repoArtistaEvento.save(artistaEvento);
        return MapperArtistaEvento.mapADtoArtistaEvento(savedArtistaEvento);
    }

    @Override
    public DtoArtistaEvento getArtistaEvento(Integer artistaEventoId) {
        ArtistaEvento artistaEvento = repoArtistaEvento.findById(artistaEventoId)
                .orElseThrow(() -> new ResourceNotFoundException("ArtistaEvento no encontrado: " + artistaEventoId));
        return MapperArtistaEvento.mapADtoArtistaEvento(artistaEvento);
    }

    @Override
    public List<DtoArtistaEvento> getAllArtistasEventos() {
        List<ArtistaEvento> artistasEventos = repoArtistaEvento.findAll();
        return artistasEventos.stream()
                .map(MapperArtistaEvento::mapADtoArtistaEvento)
                .collect(Collectors.toList());
    }

    @Override
    public DtoArtistaEvento updateArtistaEvento(Integer artistaEventoId, DtoArtistaEvento updateArtistaEvento) {
        ArtistaEvento artistaEvento = repoArtistaEvento.findById(artistaEventoId)
                .orElseThrow(() -> new ResourceNotFoundException("ArtistaEvento no encontrado: " + artistaEventoId));

        // Aquí deberías actualizar los campos necesarios
        // Por ejemplo:
        // artistaEvento.setArtista(artistaRepository.findById(updateArtistaEvento.getArtistaId()).orElse(null));
        // artistaEvento.setEvento(eventoRepository.findById(updateArtistaEvento.getEventoId()).orElse(null));

        ArtistaEvento updatedArtistaEvento = repoArtistaEvento.save(artistaEvento);
        return MapperArtistaEvento.mapADtoArtistaEvento(updatedArtistaEvento);
    }

    @Override
    public void deleteArtistaEvento(Integer artistaEventoId) {
        ArtistaEvento artistaEvento = repoArtistaEvento.findById(artistaEventoId)
                .orElseThrow(() -> new ResourceNotFoundException("ArtistaEvento no encontrado: " + artistaEventoId));
        repoArtistaEvento.delete(artistaEvento);
    }
}