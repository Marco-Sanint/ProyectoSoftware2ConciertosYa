package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.dto.DtoLugar;

import java.util.List;

public interface ServicioEvento {
    DtoEvento crearEvento(DtoEvento dtoEvento, DtoLugar dtoLugar);

    DtoEvento getEvento(Integer evento_id);

    List<DtoEvento> getAllEventos();

    DtoEvento updateEvento(Integer evento_id, DtoEvento updateEvento);

    void deleteEvento(Integer evento_id);
}