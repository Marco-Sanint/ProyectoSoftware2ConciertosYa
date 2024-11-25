package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;

import java.util.List;

public interface ServicioCarrito {
    DtoCarrito crearCarrito(DtoCarrito dtoCarrito);

    DtoCarrito getCarrito(Integer id);

    void eliminarCarrito(Integer id);

    List<DtoCarrito> listarCarritos();
}
