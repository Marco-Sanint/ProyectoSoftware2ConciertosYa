package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoDetalleFactura extends JpaRepository<DetalleFactura, Integer> {
    // Método para obtener detalles de factura por ticket
    List<DetalleFactura> findByTicket_Id(Integer ticketId);
}
