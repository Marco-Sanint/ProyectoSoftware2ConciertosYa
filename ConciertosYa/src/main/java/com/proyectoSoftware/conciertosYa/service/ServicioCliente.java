
package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;

import java.util.List;

public interface ServicioCliente {
    DtoCliente createCliente(DtoCliente dtoCliente);

    DtoCliente getCliente(String cedulaCliente);

    List<DtoCliente> getAllClientes();

    DtoCliente updateCliente(String cedulaCliente, DtoCliente updateCliente);

    void deleteCliente(String cedulaCliente);
}

