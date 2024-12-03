package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;

public class MapperDetalleFactura {

    public static DtoDetalleFactura mapADtoDetalleFactura(DetalleFactura detalleFactura) {
        return new DtoDetalleFactura(
                detalleFactura.getDetalle_factura_id(),
                detalleFactura.getCantidad(),
                detalleFactura.getPrecioUnitario(),
                detalleFactura.getPromocion() != null ? detalleFactura.getPromocion().getPromocion_id() : null,
                detalleFactura.getPrecioTotal(),
                detalleFactura.getTicket().getTicket_id() // Asumiendo que Ticket tiene un método getId()
        );
    }

    public static DetalleFactura mapADetalleFactura(DtoDetalleFactura dtoDetalleFactura) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetalle_factura_id(dtoDetalleFactura.getDetalleFacturaId());
        detalleFactura.setCantidad(dtoDetalleFactura.getCantidad());
        detalleFactura.setPrecioUnitario(dtoDetalleFactura.getPrecioUnitario());
        // Aquí deberías buscar la promocion por su ID y asignarlo
        // Por ejemplo:
        // detalleFactura.setPromocion(ticketRepository.findById(dtoDetalleFactura.getPromocionId()).orElse(null));
        detalleFactura.setPrecioTotal(dtoDetalleFactura.getPrecioTotal());
        // Aquí deberías buscar el Ticket por su ID y asignarlo
        // Por ejemplo:
        // detalleFactura.setTicket(ticketRepository.findById(dtoDetalleFactura.getTicketId()).orElse(null));
        return detalleFactura;
    }
}