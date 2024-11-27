package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;

import java.util.List;

public interface ServicioArtista {
    DtoArtista crearArtista(DtoArtista dtoArtista);
    DtoArtista getArtista(Integer artistaId);
    List<DtoArtista> getAllArtistas();
    DtoArtista updateArtista(Integer artistaId, DtoArtista updateArtista);
    void deleteArtista(Integer artistaId);
}