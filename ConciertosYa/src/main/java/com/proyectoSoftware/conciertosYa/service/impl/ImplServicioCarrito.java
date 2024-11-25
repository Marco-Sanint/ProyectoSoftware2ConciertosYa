package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.entity.Carrito;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.mapper.MapperCarrito;
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

    public ImplServicioCarrito(RepoCarrito repoCarrito, RepoCliente repoCliente) {
        this.repoCarrito = repoCarrito;
        this.repoCliente = repoCliente;
    }

    @Override
    public DtoCarrito crearCarrito(DtoCarrito dtoCarrito) {
        Cliente cliente = repoCliente.findById(dtoCarrito.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Cliente Cliente;
        Carrito carrito = MapperCarrito.mapACarrito(dtoCarrito, Cliente);
        Carrito carritoGuardado = repoCarrito.save(carrito);
        return MapperCarrito.mapADtoCarrito(carritoGuardado);
    }

    @Override
    public DtoCarrito getCarrito(Integer id) {
        Carrito carrito = repoCarrito.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return MapperCarrito.mapADtoCarrito(carrito);
    }

    @Override
    public void eliminarCarrito(Integer id) {
        Carrito carrito = repoCarrito.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        repoCarrito.delete(carrito);
    }

    @Override
    public List<DtoCarrito> listarCarritos() {
        return repoCarrito.findAll().stream()
                .map(MapperCarrito::mapADtoCarrito)
                .collect(Collectors.toList());
    }
}
