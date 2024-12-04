package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Ticket;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;

public class MapperTicket {

    private static ServicioCliente servicioCliente;
    private static ServicioAsiento servicioAsiento;

    public static DtoTicket mapADtoTicket(Ticket ticket) {
        return new DtoTicket(
                ticket.getTicket_id(),
                ticket.getFechaCompra(),
                ticket.getPrecio(),
                ticket.getAsiento().getAsiento_id(), // Asumiendo que Asiento tiene un método getAsiento_id()
                ticket.getCliente().getCedula() // Asumiendo que Cliente tiene un método getCedula()
        );
    }

    public static Ticket mapATicket(DtoTicket dtoTicket) {
        Ticket ticket = new Ticket();
        ticket.setTicket_id(dtoTicket.getTicketId());
        ticket.setFechaCompra(dtoTicket.getFechaCompra());
        ticket.setPrecio(dtoTicket.getPrecio());
        ticket.setCliente(MapperCliente.mapACliente(servicioCliente.getCliente(dtoTicket.getClienteCedula())));
        ticket.setAsiento(MapperAsiento.mapAAsiento(servicioAsiento.getAsiento(dtoTicket.getAsientoId())));
        return ticket;
    }
}