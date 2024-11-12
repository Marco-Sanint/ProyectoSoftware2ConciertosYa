package com.proyectoSoftware.conciertosYa.repository;

import com.proyectoSoftware.conciertosYa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCliente extends JpaRepository<Cliente, String> {
}
