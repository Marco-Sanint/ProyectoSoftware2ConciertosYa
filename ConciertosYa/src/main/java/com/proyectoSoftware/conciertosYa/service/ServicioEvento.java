package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;

import java.util.List;

public interface ServicioEvento {
    DtoEvento crearEvento(DtoEvento dtoEvento);

    DtoEvento obtenerEvento(Integer id);

    DtoEvento actualizarEvento(Integer id, DtoEvento dtoEvento);

    void eliminarEvento(Integer id);

    List<DtoEvento> listarEventos();
}
