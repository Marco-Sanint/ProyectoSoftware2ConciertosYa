package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;

import java.util.List;

public interface ServicioMetodoPago {
    DtoMetodoPago crearMetodoPago(DtoMetodoPago dtoMetodoPago);

    DtoMetodoPago obtenerMetodoPago(Integer id);

    List<DtoMetodoPago> listarMetodosPago();

    void eliminarMetodoPago(Integer id);
}
