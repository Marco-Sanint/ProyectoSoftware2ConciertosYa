
package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperCliente;
import com.proyectoSoftware.conciertosYa.repository.RepoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioCliente implements ServicioCliente {

    private RepoCliente repoCliente;

    @Override
    public DtoCliente createCliente(DtoCliente dtoCliente) {

        Cliente cliente = MapperCliente.mapACliente(dtoCliente);
        Cliente salvarCliente = repoCliente.save(cliente);
        return MapperCliente.mapADtoCliente(salvarCliente);
    }

    @Override
    public DtoCliente getCliente(String cedulaCliente) {
        Cliente cliente = repoCliente.findById(cedulaCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + cedulaCliente));

        return MapperCliente.mapADtoCliente(cliente);
    }

    @Override
    public List<DtoCliente> getAllClientes() {
        List<Cliente> clientes = repoCliente.findAll();
        return clientes.stream().map((cliente) -> MapperCliente.mapADtoCliente(cliente)).collect(Collectors.toList());
    }

    @Override
    public DtoCliente updateCliente(String cedulaCliente, DtoCliente updateCliente) {
        Cliente cliente = repoCliente.findById(cedulaCliente).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado en la cedula: " + cedulaCliente));
        cliente.setNombre(updateCliente.getNombre());
        cliente.setTelefono(updateCliente.getTelefono());
        cliente.setMail(updateCliente.getMail());
        cliente.setDireccion(updateCliente.getDireccion());

        Cliente updateClienteObj = repoCliente.save(cliente);

        return MapperCliente.mapADtoCliente(updateClienteObj);
    }

    @Override
    public void deleteCliente(String cedulaCliente) {
        Cliente cliente = repoCliente.findById(cedulaCliente).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado en la cedula: " + cedulaCliente));

        repoCliente.deleteById(cedulaCliente);
    }
}