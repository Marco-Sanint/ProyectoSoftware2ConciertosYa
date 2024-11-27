package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoTicket extends JpaRepository<Ticket, Integer> {
}