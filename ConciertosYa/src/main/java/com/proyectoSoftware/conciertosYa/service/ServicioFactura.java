package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;

import java.util.List;

public interface ServicioFactura {
    DtoFactura crearFactura(DtoFactura dtoFactura);

    DtoFactura obtenerFactura(Integer id);

    DtoFactura actualizarFactura(Integer id, DtoFactura dtoFactura);

    void eliminarFactura(Integer id);

    List<DtoFactura> listarFacturas();
}
