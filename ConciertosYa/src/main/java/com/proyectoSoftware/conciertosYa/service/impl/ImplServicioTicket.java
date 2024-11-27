package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Ticket;
import com.proyectoSoftware.conciertosYa.entity.Asiento; // Asegúrate de importar la entidad Asiento
import com.proyectoSoftware.conciertosYa.entity.Cliente; // Asegúrate de importar la entidad Cliente
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperTicket;
import com.proyectoSoftware.conciertosYa.repository.RepoTicket;
import com.proyectoSoftware.conciertosYa.repository.RepoAsiento; // Asegúrate de importar el repositorio de Asiento
import com.proyectoSoftware.conciertosYa.repository.RepoCliente; // Asegúrate de importar el repositorio de Cliente
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioTicket implements ServicioTicket {

    private final RepoTicket repoTicket;
    private final RepoAsiento repoAsiento; // Inyectamos el repositorio de Asiento
    private final RepoCliente repoCliente; // Inyectamos el repositorio de Cliente

    @Override
    public DtoTicket createTicket(DtoTicket dtoTicket) {
        Asiento asiento = repoAsiento.findById(dtoTicket.getAsientoId())
                .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado: " + dtoTicket.getAsientoId()));

        Cliente cliente = repoCliente.findById(dtoTicket.getClienteCedula())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + dtoTicket.getClienteCedula()));

        Ticket ticket = MapperTicket.mapATicket(dtoTicket);
        ticket.setAsiento(asiento); // Asignamos el asiento
        ticket.setCliente(cliente); // Asignamos el cliente
        Ticket savedTicket = repoTicket.save(ticket);
        return MapperTicket.mapADtoTicket(savedTicket);
    }

    @Override
    public DtoTicket getTicket(Integer ticketId) {
        Ticket ticket = repoTicket.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado: " + ticketId));
        return MapperTicket.mapADtoTicket(ticket);
    }

    @Override
    public List<DtoTicket> getAllTickets() {
        return repoTicket.findAll().stream()
                .map(MapperTicket::mapADtoTicket)
                .collect(Collectors.toList());
    }

    @Override
    public DtoTicket updateTicket(Integer ticketId, DtoTicket updateTicket) {
        Ticket existingTicket = repoTicket.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado: " + ticketId));

        existingTicket.setFechaCompra(updateTicket.getFechaCompra());
        existingTicket.setDescuento(updateTicket.getDescuento());
        existingTicket.setPrecio(updateTicket.getPrecio());
        existingTicket.setPrecioConDescuento(updateTicket.getPrecioConDescuento());

        // Aquí deberías actualizar el Asiento y el Cliente si es necesario
        if (updateTicket.getAsientoId() != null) {
            Asiento asiento = repoAsiento.findById(updateTicket.getAsientoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado: " + updateTicket.getAsientoId()));
            existingTicket.setAsiento(asiento);
        }

        if (updateTicket.getClienteCedula() != null) {
            Cliente cliente = repoCliente.findById(updateTicket.getClienteCedula())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + updateTicket.getClienteCedula()));
            existingTicket.setCliente(cliente);
        }

        Ticket updatedTicket = repoTicket.save(existingTicket);
        return MapperTicket.mapADtoTicket(updatedTicket);
    }

    @Override
    public void deleteTicket(Integer ticketId) {
        if (!repoTicket.existsById(ticketId)) {
            throw new ResourceNotFoundException("Ticket no encontrado: " + ticketId);
        }
        repoTicket.deleteById(ticketId);
    }
}