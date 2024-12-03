package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.dto.DtoTicket;

import java.util.List;

public interface ServicioDetalleFactura {
    DtoDetalleFactura createDetalleFactura(DtoDetalleFactura dtoDetalleFactura, DtoPromocion dtoPromocion, DtoTicket dtoTicket);

    DtoDetalleFactura getDetalleFactura(Integer detalleFacturaId);

    List<DtoDetalleFactura> getAllDetalleFacturas();

    DtoDetalleFactura updateDetalleFactura(Integer detalleFacturaId, DtoDetalleFactura updateDetalleFactura);

    void deleteDetalleFactura(Integer detalleFacturaId);
}