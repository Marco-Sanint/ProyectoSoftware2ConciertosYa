package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.entity.Ticket;
import com.proyectoSoftware.conciertosYa.mapper.MapperTicket;
import com.proyectoSoftware.conciertosYa.repository.RepoAsiento;
import com.proyectoSoftware.conciertosYa.repository.RepoCliente;
import com.proyectoSoftware.conciertosYa.repository.RepoTicket;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioTicket implements ServicioTicket {

    private final RepoTicket repoTicket;
    private final RepoAsiento repoAsiento;
    private final RepoCliente repoCliente;

    public ImplServicioTicket(RepoTicket repoTicket, RepoAsiento repoAsiento, RepoCliente repoCliente) {
        this.repoTicket = repoTicket;
        this.repoAsiento = repoAsiento;
        this.repoCliente = repoCliente;
    }

    @Override
    public DtoTicket crearTicket(DtoTicket dtoTicket) {
        Asiento asiento = repoAsiento.findById(dtoTicket.getAsientoId())
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        Cliente cliente = repoCliente.findById(dtoTicket.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Ticket ticket = MapperTicket.mapATicket(dtoTicket, asiento, cliente);
        Ticket ticketGuardado = repoTicket.save(ticket);

        return MapperTicket.mapADtoTicket(ticketGuardado);
    }

    @Override
    public DtoTicket obtenerTicket(Integer id) {
        Ticket ticket = repoTicket.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        return MapperTicket.mapADtoTicket(ticket);
    }

    @Override
    public List<DtoTicket> listarTicketsPorCliente(String clienteId) {
        return repoTicket.findByCliente_Cedula(clienteId).stream()
                .map(MapperTicket::mapADtoTicket)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarTicket(Integer id) {
        Ticket ticket = repoTicket.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        repoTicket.delete(ticket);
    }
}
