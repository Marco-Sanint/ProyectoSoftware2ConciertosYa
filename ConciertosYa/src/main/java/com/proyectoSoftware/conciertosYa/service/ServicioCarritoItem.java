package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;

import java.util.List;

public interface ServicioCarritoItem {
    DtoCarritoItem createCarritoItem(DtoCarritoItem dtoCarritoItem);

    DtoCarritoItem getCarritoItem(Integer carritoItemId);

    List<DtoCarritoItem> getAllCarritoItems();

    DtoCarritoItem updateCarritoItem(Integer carritoItemId, DtoCarritoItem updateCarritoItem);

    void deleteCarritoItem(Integer carritoItemId);
}