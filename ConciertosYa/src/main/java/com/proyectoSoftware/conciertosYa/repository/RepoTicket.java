package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoTicket extends JpaRepository<Ticket, Integer> {
    // Método para obtener tickets de un cliente
    List<Ticket> findByCliente_Cedula(String clienteId);
}
