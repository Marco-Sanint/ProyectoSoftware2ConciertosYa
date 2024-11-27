package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.entity.Artista;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperArtista;
import com.proyectoSoftware.conciertosYa.repository.RepoArtista;
import com.proyectoSoftware.conciertosYa.service.ServicioArtista;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioArtista implements ServicioArtista {

    private RepoArtista repoArtista;

    @Override
    public DtoArtista crearArtista(DtoArtista dtoArtista) {
        Artista artista = MapperArtista.mapAArtista(dtoArtista);
        Artista salvarArtista = repoArtista.save(artista);
        return MapperArtista.mapADtoArtista(salvarArtista);
    }

    @Override
    public DtoArtista getArtista(Integer artistaId) {
        Artista artista = repoArtista.findById(artistaId)
                .orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado: " + artistaId));
        return MapperArtista.mapADtoArtista(artista);
    }

    @Override
    public List<DtoArtista> getAllArtistas() {
        List<Artista> artistas = repoArtista.findAll();
        return artistas.stream().map(MapperArtista::mapADtoArtista).collect(Collectors.toList());
    }

    @Override
    public DtoArtista updateArtista(Integer artistaId, DtoArtista updateArtista) {
        Artista artista = repoArtista.findById(artistaId)
                .orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado en el ID: " + artistaId));
        artista.setNombre(updateArtista.getNombre());
        artista.setGeneroMusical(updateArtista.getGeneroMusical());
        artista.setRedesSociales(updateArtista.getRedesSociales());

        Artista updateArtistaObj = repoArtista.save(artista);
        return MapperArtista.mapADtoArtista(updateArtistaObj);
    }

    @Override
    public void deleteArtista(Integer artistaId) {
        Artista artista = repoArtista.findById(artistaId)
                .orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado en el ID: " + artistaId));
        repoArtista.deleteById(artistaId);
    }
}