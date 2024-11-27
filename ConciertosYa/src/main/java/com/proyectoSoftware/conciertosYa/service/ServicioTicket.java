package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;

import java.util.List;

public interface ServicioTicket {
    DtoTicket createTicket(DtoTicket dtoTicket);

    DtoTicket getTicket(Integer ticketId);

    List<DtoTicket> getAllTickets();

    DtoTicket updateTicket(Integer ticketId, DtoTicket updateTicket);

    void deleteTicket(Integer ticketId);
}