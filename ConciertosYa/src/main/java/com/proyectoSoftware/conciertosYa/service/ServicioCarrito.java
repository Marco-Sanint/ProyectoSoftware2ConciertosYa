package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCliente;

import java.util.List;

public interface ServicioCarrito {
    DtoCarrito createCarrito(DtoCarrito dtoCarrito, DtoCliente dtoCliente);

    DtoCarrito getCarrito(Integer carritoId);

    List<DtoCarrito> getAllCarritos();

    DtoCarrito updateCarrito(Integer carritoId, DtoCarrito updateCarrito);

    void deleteCarrito(Integer carritoId);
}