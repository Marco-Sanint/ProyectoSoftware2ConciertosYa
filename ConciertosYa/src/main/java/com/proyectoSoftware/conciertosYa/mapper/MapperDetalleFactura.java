package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.Ticket;

public class MapperDetalleFactura {

    public static DtoDetalleFactura mapADtoDetalleFactura(DetalleFactura detalleFactura) {
        return new DtoDetalleFactura(
                detalleFactura.getId(),
                detalleFactura.getTicket().getId(),
                detalleFactura.getCantidad(),
                detalleFactura.getPrecioUnitario(),
                detalleFactura.getDescuento(),
                detalleFactura.getPrecioTotal()
        );
    }

    public static DetalleFactura mapADetalleFactura(DtoDetalleFactura dtoDetalleFactura, Ticket ticket) {
        return new DetalleFactura(
                dtoDetalleFactura.getId(),
                dtoDetalleFactura.getCantidad(),
                dtoDetalleFactura.getPrecioUnitario(),
                dtoDetalleFactura.getDescuento(),
                dtoDetalleFactura.getPrecioTotal(),
                ticket
        );
    }
}
