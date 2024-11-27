package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;

import java.util.List;

public interface ServicioArtistaEvento {
    DtoArtistaEvento createArtistaEvento(DtoArtistaEvento dtoArtistaEvento);

    DtoArtistaEvento getArtistaEvento(Integer artistaEventoId);

    List<DtoArtistaEvento> getAllArtistasEventos();

    DtoArtistaEvento updateArtistaEvento(Integer artistaEventoId, DtoArtistaEvento updateArtistaEvento);

    void deleteArtistaEvento(Integer artistaEventoId);
}