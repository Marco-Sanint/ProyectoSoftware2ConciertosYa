package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;

import java.util.List;

public interface ServicioDetalleFactura {
    DtoDetalleFactura createDetalleFactura(DtoDetalleFactura dtoDetalleFactura);

    DtoDetalleFactura getDetalleFactura(Integer detalleFacturaId);

    List<DtoDetalleFactura> getAllDetalleFacturas();

    DtoDetalleFactura updateDetalleFactura(Integer detalleFacturaId, DtoDetalleFactura updateDetalleFactura);

    void deleteDetalleFactura(Integer detalleFacturaId);
}