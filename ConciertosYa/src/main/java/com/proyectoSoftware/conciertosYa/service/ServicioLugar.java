package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;

import java.util.List;

public interface ServicioLugar {
    DtoLugar crearLugar(DtoLugar dtoLugar);

    DtoLugar getLugar(Integer lugar_id);

    List<DtoLugar> getAllLugares();

    DtoLugar updateLugar(Integer lugar_id, DtoLugar updateLugar);

    void deleteLugar(Integer lugar_id);
}