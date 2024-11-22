
package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;

public interface ServicioCliente {
    DtoCliente createCliente(DtoCliente dtoCliente);

    DtoCliente getCliente(String cedulaCliente);
}

