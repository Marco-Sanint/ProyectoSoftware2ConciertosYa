package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.ArtistaEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoArtistaEvento extends JpaRepository<ArtistaEvento, Integer> {
}