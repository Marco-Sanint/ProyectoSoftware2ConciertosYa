package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;

import java.util.List;

public interface ServicioCarritoItem {
    DtoCarritoItem crearCarritoItem(DtoCarritoItem dtoCarritoItem);

    List<DtoCarritoItem> listarCarritoItems(Integer carritoId);

    void eliminarCarritoItem(Integer id);
}
