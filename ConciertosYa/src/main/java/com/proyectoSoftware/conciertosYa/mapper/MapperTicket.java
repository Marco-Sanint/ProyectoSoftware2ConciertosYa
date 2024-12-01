package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Ticket;

public class MapperTicket {

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
        // Aquí deberías buscar el Asiento y el Cliente por sus IDs y asignarlos
        // Por ejemplo:
        // ticket.setAsiento(asientoRepository.findById(dtoTicket.getAsientoId()).orElse(null));
        // ticket.setCliente(clienteRepository.findById(dtoTicket.getClienteCedula()).orElse(null));
        return ticket;
    }
}