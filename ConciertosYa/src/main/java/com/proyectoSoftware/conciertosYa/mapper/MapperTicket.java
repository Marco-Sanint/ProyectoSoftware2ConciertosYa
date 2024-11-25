package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.entity.Ticket;

public class MapperTicket {

    public static DtoTicket mapADtoTicket(Ticket ticket) {
        return new DtoTicket(
                ticket.getId(),
                ticket.getFechaCompra(),
                ticket.getDescuento(),
                ticket.getPrecio(),
                ticket.getPrecioConDescuento(),
                ticket.getAsiento().getId(),
                ticket.getCliente().getCedula()
        );
    }

    public static Ticket mapATicket(DtoTicket dtoTicket, Asiento asiento, Cliente cliente) {
        return new Ticket(
                dtoTicket.getId(),
                dtoTicket.getFechaCompra(),
                dtoTicket.getDescuento(),
                dtoTicket.getPrecio(),
                dtoTicket.getPrecioConDescuento(),
                asiento,
                cliente
        );
    }
}
