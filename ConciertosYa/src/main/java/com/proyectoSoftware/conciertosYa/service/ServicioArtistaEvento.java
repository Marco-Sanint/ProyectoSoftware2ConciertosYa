package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;

import java.util.List;

public interface ServicioArtistaEvento {
    DtoArtistaEvento crearArtistaEvento(DtoArtistaEvento dtoArtistaEvento);

    DtoArtistaEvento getArtistaEvento(Integer id);

    void eliminarArtistaEvento(Integer id);

    List<DtoArtistaEvento> listarArtistasEventos();
}
