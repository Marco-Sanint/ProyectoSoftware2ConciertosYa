package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoDetalleFactura extends JpaRepository<DetalleFactura, Integer> {
}