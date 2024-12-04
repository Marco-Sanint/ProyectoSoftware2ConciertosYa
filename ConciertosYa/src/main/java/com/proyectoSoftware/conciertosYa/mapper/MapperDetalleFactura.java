package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;

public class MapperDetalleFactura {

    private static ServicioTicket servicioTicket;
    private static ServicioPromocion servicioPromocion;

    public static DtoDetalleFactura mapADtoDetalleFactura(DetalleFactura detalleFactura) {
        return new DtoDetalleFactura(
                detalleFactura.getDetalle_factura_id(),
                detalleFactura.getCantidad(),
                detalleFactura.getPrecioUnitario(),
                detalleFactura.getPromocion() != null ? detalleFactura.getPromocion().getPromocion_id() : null,
                detalleFactura.getPrecioTotal(),
                detalleFactura.getTicket().getTicket_id() != null ? detalleFactura.getTicket().getTicket_id() : null
        );
    }

    public static DetalleFactura mapADetalleFactura(DtoDetalleFactura dtoDetalleFactura) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetalle_factura_id(dtoDetalleFactura.getDetalleFacturaId());
        detalleFactura.setCantidad(dtoDetalleFactura.getCantidad());
        detalleFactura.setPrecioUnitario(dtoDetalleFactura.getPrecioUnitario());
        detalleFactura.setPromocion(MapperPromocion.mapAPromocion(servicioPromocion.getPromocion(dtoDetalleFactura.getPromocion())));
        detalleFactura.setPrecioTotal(dtoDetalleFactura.getPrecioTotal());
        detalleFactura.setPromocion(MapperPromocion.mapAPromocion(servicioPromocion.getPromocion(dtoDetalleFactura.getPromocion())));
        return detalleFactura;
    }
}