package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;

import java.util.List;

public interface ServicioFactura {
    DtoFactura crearFactura(DtoFactura dtoFactura);

    DtoFactura getFactura(Integer factura_id);

    List<DtoFactura> getAllFacturas();

    DtoFactura updateFactura(Integer factura_id, DtoFactura updateFactura);

    void deleteFactura(Integer factura_id);
}