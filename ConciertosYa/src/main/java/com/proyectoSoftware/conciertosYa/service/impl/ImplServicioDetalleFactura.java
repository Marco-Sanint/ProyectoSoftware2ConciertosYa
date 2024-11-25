package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.Ticket;
import com.proyectoSoftware.conciertosYa.mapper.MapperDetalleFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoDetalleFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoTicket;
import com.proyectoSoftware.conciertosYa.service.ServicioDetalleFactura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioDetalleFactura implements ServicioDetalleFactura {

    private final RepoDetalleFactura repoDetalleFactura;
    private final RepoTicket repoTicket;

    public ImplServicioDetalleFactura(RepoDetalleFactura repoDetalleFactura, RepoTicket repoTicket) {
        this.repoDetalleFactura = repoDetalleFactura;
        this.repoTicket = repoTicket;
    }

    @Override
    public DtoDetalleFactura crearDetalleFactura(DtoDetalleFactura dtoDetalleFactura) {
        Ticket ticket = repoTicket.findById(dtoDetalleFactura.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        DetalleFactura detalleFactura = MapperDetalleFactura.mapADetalleFactura(dtoDetalleFactura, ticket);
        DetalleFactura detalleGuardado = repoDetalleFactura.save(detalleFactura);

        return MapperDetalleFactura.mapADtoDetalleFactura(detalleGuardado);
    }

    @Override
    public List<DtoDetalleFactura> listarDetallesPorTicket(Integer ticketId) {
        return repoDetalleFactura.findByTicket_Id(ticketId).stream()
                .map(MapperDetalleFactura::mapADtoDetalleFactura)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarDetalleFactura(Integer id) {
        DetalleFactura detalleFactura = repoDetalleFactura.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleFactura no encontrado"));
        repoDetalleFactura.delete(detalleFactura);
    }
}
