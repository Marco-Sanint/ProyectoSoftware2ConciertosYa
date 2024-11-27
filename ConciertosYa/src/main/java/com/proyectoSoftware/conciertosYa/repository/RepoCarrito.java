package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCarrito extends JpaRepository<Carrito, Integer> {
}