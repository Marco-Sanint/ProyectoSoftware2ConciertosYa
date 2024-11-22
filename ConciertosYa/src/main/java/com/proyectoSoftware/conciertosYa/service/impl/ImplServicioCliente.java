package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.mapper.MapperCliente;
import com.proyectoSoftware.conciertosYa.repository.RepoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplServicioCliente implements ServicioCliente {

    private RepoCliente repoCliente;

    @Override
    public DtoCliente crearCliente(DtoCliente dtoCliente) {

        Cliente cliente = MapperCliente.mapACliente(dtoCliente);
        Cliente salvarCliente = repoCliente.save(cliente);
        return MapperCliente.mapADtoCliente(salvarCliente);
    }
}
