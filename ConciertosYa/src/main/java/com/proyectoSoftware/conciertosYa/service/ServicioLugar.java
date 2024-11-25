package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;

import java.util.List;

public interface ServicioLugar {
    DtoLugar crearLugar(DtoLugar dtoLugar);

    DtoLugar obtenerLugar(Integer id);

    DtoLugar actualizarLugar(Integer id, DtoLugar dtoLugar);

    void eliminarLugar(Integer id);

    List<DtoLugar> listarLugares();
}
