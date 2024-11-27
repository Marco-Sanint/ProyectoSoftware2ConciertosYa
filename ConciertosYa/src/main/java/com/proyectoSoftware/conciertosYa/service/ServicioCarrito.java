package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;

import java.util.List;

public interface ServicioCarrito {
    DtoCarrito createCarrito(DtoCarrito dtoCarrito);

    DtoCarrito getCarrito(Integer carritoId);

    List<DtoCarrito> getAllCarritos();

    DtoCarrito updateCarrito(Integer carritoId, DtoCarrito updateCarrito);

    void deleteCarrito(Integer carritoId);
}