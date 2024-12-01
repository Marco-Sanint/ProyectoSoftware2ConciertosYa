package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;

import java.util.List;

public interface ServicioCarritoItem {
    DtoCarritoItem createCarritoItem(DtoCarritoItem dtoCarritoItem, DtoAsiento dtoAsiento, DtoCarrito dtoCarrito);

    DtoCarritoItem getCarritoItem(Integer carritoItemId);

    List<DtoCarritoItem> getAllCarritoItems();

    DtoCarritoItem updateCarritoItem(Integer carritoItemId, DtoCarritoItem updateCarritoItem);

    void deleteCarritoItem(Integer carritoItemId);
}