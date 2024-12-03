package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.dto.DtoEvento;

import java.util.List;

public interface ServicioArtistaEvento {
    DtoArtistaEvento createArtistaEvento(DtoArtistaEvento dtoArtistaEvento, DtoArtista dtoArtista, DtoEvento dtoEvento);

    DtoArtistaEvento getArtistaEvento(Integer artistaEventoId);

    List<DtoArtistaEvento> getAllArtistasEventos();

    DtoArtistaEvento updateArtistaEvento(Integer artistaEventoId, DtoArtistaEvento updateArtistaEvento);

    void deleteArtistaEvento(Integer artistaEventoId);
}