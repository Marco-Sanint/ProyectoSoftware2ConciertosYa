package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;

import java.util.List;

public interface ServicioDetalleFactura {
    DtoDetalleFactura crearDetalleFactura(DtoDetalleFactura dtoDetalleFactura);

    List<DtoDetalleFactura> listarDetallesPorTicket(Integer ticketId);

    void eliminarDetalleFactura(Integer id);
}
