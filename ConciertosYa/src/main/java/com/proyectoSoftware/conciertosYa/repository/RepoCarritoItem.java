package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoCarritoItem extends JpaRepository<CarritoItem, Integer> {

    // Buscar todos los ítems asociados a un carrito específico
    List<CarritoItem> findByCarrito_Id(Integer carritoId);
}
