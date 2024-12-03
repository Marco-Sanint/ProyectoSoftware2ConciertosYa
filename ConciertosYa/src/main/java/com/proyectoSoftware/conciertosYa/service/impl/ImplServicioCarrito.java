package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.entity.Carrito;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperCarrito;
import com.proyectoSoftware.conciertosYa.mapper.MapperCliente;
import com.proyectoSoftware.conciertosYa.repository.RepoCarrito;
import com.proyectoSoftware.conciertosYa.repository.RepoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioCarrito implements ServicioCarrito {

    private final RepoCarrito repoCarrito;
    private final RepoCliente repoCliente;

    @Override
    public DtoCarrito createCarrito(DtoCarrito dtoCarrito, DtoCliente dtoCliente) {
        Cliente cliente = MapperCliente.mapACliente(dtoCliente);

        Carrito carrito = MapperCarrito.mapACarrito(dtoCarrito);
        carrito.setCliente(cliente);

        return MapperCarrito.mapADtoCarrito(repoCarrito.save(carrito));
    }

    @Override
    public DtoCarrito getCarrito(Integer carritoId) {
        Carrito carrito = repoCarrito.findById(carritoId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado: " + carritoId));
        return MapperCarrito.mapADtoCarrito(carrito);
    }

    @Override
    public List<DtoCarrito> getAllCarritos() {
        List<Carrito> carritos = repoCarrito.findAll();
        return carritos.stream()
                .map(MapperCarrito::mapADtoCarrito)
                .collect(Collectors.toList());
    }

    @Override
    public DtoCarrito updateCarrito(Integer carritoId, DtoCarrito updateCarrito) {
        Carrito carrito = repoCarrito.findById(carritoId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado: " + carritoId));

        // Aquí deberías actualizar los campos necesarios
        // Buscamos el cliente por su cédula y lo asignamos
        Cliente cliente = repoCliente.findById(updateCarrito.getCedulaCliente())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + updateCarrito.getCedulaCliente()));
        carrito.setCliente(cliente);
        carrito.setFechaCreacion(updateCarrito.getFechaCreacion());

        Carrito updatedCarrito = repoCarrito.save(carrito);
        return MapperCarrito.mapADtoCarrito(updatedCarrito);
    }

    @Override
    public void deleteCarrito(Integer carritoId) {
        Carrito carrito = repoCarrito.findById(carritoId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado: " + carritoId));
        repoCarrito.delete(carrito);
    }
}