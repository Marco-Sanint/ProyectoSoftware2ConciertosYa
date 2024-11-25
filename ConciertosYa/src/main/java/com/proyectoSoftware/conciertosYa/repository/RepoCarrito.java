package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoCarrito extends JpaRepository<Carrito, Integer> {

    // Método personalizado para buscar carritos por la cédula del cliente
    List<Carrito> findByCliente_Cedula(String cedula);
}
