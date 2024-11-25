package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoArtista extends JpaRepository<Artista, Integer> {
}
