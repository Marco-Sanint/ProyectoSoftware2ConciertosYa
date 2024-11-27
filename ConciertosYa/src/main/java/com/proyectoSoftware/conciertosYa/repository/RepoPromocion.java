package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoPromocion extends JpaRepository<Promocion, Integer> {
}
