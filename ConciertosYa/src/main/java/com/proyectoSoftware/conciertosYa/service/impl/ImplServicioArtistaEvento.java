package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.entity.Artista;
import com.proyectoSoftware.conciertosYa.entity.ArtistaEvento;
import com.proyectoSoftware.conciertosYa.entity.Evento;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperArtista;
import com.proyectoSoftware.conciertosYa.mapper.MapperArtistaEvento;
import com.proyectoSoftware.conciertosYa.mapper.MapperEvento;
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
    private final MapperEvento mapperEvento;  // MapperEvento still needs to be injected

    @Override
    public DtoArtistaEvento createArtistaEvento(DtoArtistaEvento dtoArtistaEvento, DtoArtista dtoArtista, DtoEvento dtoEvento) {
        Artista artista = MapperArtista.mapAArtista(dtoArtista);  // Call static method directly
        Evento evento = mapperEvento.mapAEvento(dtoEvento);      // Assuming MapperEvento is still injected

        ArtistaEvento artistaEvento = MapperArtistaEvento.mapAArtistaEvento(dtoArtistaEvento);
        artistaEvento.setArtista(artista);
        artistaEvento.setEvento(evento);

        return MapperArtistaEvento.mapADtoArtistaEvento(repoArtistaEvento.save(artistaEvento));
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

        // Here you can update the necessary fields as needed

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
