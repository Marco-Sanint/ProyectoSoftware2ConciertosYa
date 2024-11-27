package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEvento extends JpaRepository<Evento, Integer> {
}