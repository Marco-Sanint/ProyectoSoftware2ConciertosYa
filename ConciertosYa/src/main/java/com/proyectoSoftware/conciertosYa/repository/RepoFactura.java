package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoFactura extends JpaRepository<Factura, Integer> {
}
