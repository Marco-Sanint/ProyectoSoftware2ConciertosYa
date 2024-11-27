package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLugar extends JpaRepository<Lugar, Integer> {
}