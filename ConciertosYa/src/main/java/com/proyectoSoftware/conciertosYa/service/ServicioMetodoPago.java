package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;

import java.util.List;

public interface ServicioMetodoPago {
    DtoMetodoPago crearMetodoPago(DtoMetodoPago dtoMetodoPago);

    DtoMetodoPago getMetodoPago(Integer metodo_pago_id);

    List<DtoMetodoPago> getAllMetodosPago();

    DtoMetodoPago updateMetodoPago(Integer metodo_pago_id, DtoMetodoPago updateMetodoPago);

    void deleteMetodoPago(Integer metodo_pago_id);
}