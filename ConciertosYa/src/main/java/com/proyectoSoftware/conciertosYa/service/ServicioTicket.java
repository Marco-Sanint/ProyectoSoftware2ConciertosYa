package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;

import java.util.List;

public interface ServicioTicket {
    DtoTicket crearTicket(DtoTicket dtoTicket);

    DtoTicket obtenerTicket(Integer id);

    List<DtoTicket> listarTicketsPorCliente(String clienteId);

    void eliminarTicket(Integer id);
}
