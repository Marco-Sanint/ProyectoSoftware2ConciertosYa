package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.Carrito;
import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;
import com.proyectoSoftware.conciertosYa.entity.Promocion;
import com.proyectoSoftware.conciertosYa.entity.Ticket; // Asegúrate de importar la entidad Ticket
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperDetalleFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoDetalleFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoPromocion;
import com.proyectoSoftware.conciertosYa.repository.RepoTicket; // Asegúrate de importar el repositorio de Ticket
import com.proyectoSoftware.conciertosYa.service.ServicioDetalleFactura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioDetalleFactura implements ServicioDetalleFactura {

    private final RepoDetalleFactura repoDetalleFactura;
    private final RepoPromocion repoPromocion;
    private final RepoTicket repoTicket; // Inyectamos el repositorio de Ticket

    @Override
    public DtoDetalleFactura createDetalleFactura(DtoDetalleFactura dtoDetalleFactura) {
        Ticket ticket = repoTicket.findById(dtoDetalleFactura.getTicketId())
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado: " + dtoDetalleFactura.getTicketId()));

        DetalleFactura detalleFactura = MapperDetalleFactura.mapADetalleFactura(dtoDetalleFactura);
        detalleFactura.setTicket(ticket); // Asignamos el ticket
        DetalleFactura savedDetalleFactura = repoDetalleFactura.save(detalleFactura);
        return MapperDetalleFactura.mapADtoDetalleFactura (savedDetalleFactura);
    }

    @Override
    public DtoDetalleFactura getDetalleFactura(Integer detalleFacturaId) {
        DetalleFactura detalleFactura = repoDetalleFactura.findById(detalleFacturaId)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleFactura no encontrado: " + detalleFacturaId));
        return MapperDetalleFactura.mapADtoDetalleFactura(detalleFactura);
    }

    @Override
    public List<DtoDetalleFactura> getAllDetalleFacturas() {
        return repoDetalleFactura.findAll().stream()
                .map(MapperDetalleFactura::mapADtoDetalleFactura)
                .collect(Collectors.toList());
    }

    @Override
    public DtoDetalleFactura updateDetalleFactura(Integer detalleFacturaId, DtoDetalleFactura updateDetalleFactura) {
        DetalleFactura existingDetalleFactura = repoDetalleFactura.findById(detalleFacturaId)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleFactura no encontrado: " + detalleFacturaId));

        existingDetalleFactura.setCantidad(updateDetalleFactura.getCantidad());
        existingDetalleFactura.setPrecioUnitario(updateDetalleFactura.getPrecioUnitario());
        Promocion promocion = repoPromocion.findById(updateDetalleFactura.getPromocion())
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado: " + updateDetalleFactura.getPromocion()));
        existingDetalleFactura.setPrecioTotal(updateDetalleFactura.getPrecioTotal());

        // Aquí deberías actualizar el Ticket si es necesario
        if (updateDetalleFactura.getTicketId() != null) {
            Ticket ticket = repoTicket.findById(updateDetalleFactura.getTicketId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado: " + updateDetalleFactura.getTicketId()));
            existingDetalleFactura.setTicket(ticket);
        }

        DetalleFactura updatedDetalleFactura = repoDetalleFactura.save(existingDetalleFactura);
        return MapperDetalleFactura.mapADtoDetalleFactura(updatedDetalleFactura);
    }

    @Override
    public void deleteDetalleFactura(Integer detalleFacturaId) {
        if (!repoDetalleFactura.existsById(detalleFacturaId)) {
            throw new ResourceNotFoundException("DetalleFactura no encontrado: " + detalleFacturaId);
        }
        repoDetalleFactura.deleteById(detalleFacturaId);
    }
}