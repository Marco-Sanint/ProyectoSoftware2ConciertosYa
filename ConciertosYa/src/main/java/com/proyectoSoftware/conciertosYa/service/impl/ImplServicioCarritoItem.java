package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.entity.Carrito;
import com.proyectoSoftware.conciertosYa.entity.CarritoItem;
import com.proyectoSoftware.conciertosYa.mapper.MapperCarritoItem;
import com.proyectoSoftware.conciertosYa.repository.RepoAsiento;
import com.proyectoSoftware.conciertosYa.repository.RepoCarrito;
import com.proyectoSoftware.conciertosYa.repository.RepoCarritoItem;
import com.proyectoSoftware.conciertosYa.service.ServicioCarritoItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioCarritoItem implements ServicioCarritoItem {

    private final RepoCarritoItem repoCarritoItem;
    private final RepoCarrito repoCarrito;
    private final RepoAsiento repoAsiento;

    public ImplServicioCarritoItem(RepoCarritoItem repoCarritoItem, RepoCarrito repoCarrito, RepoAsiento repoAsiento) {
        this.repoCarritoItem = repoCarritoItem;
        this.repoCarrito = repoCarrito;
        this.repoAsiento = repoAsiento;
    }

    @Override
    public DtoCarritoItem crearCarritoItem(DtoCarritoItem dtoCarritoItem) {
        Carrito carrito = repoCarrito.findById(dtoCarritoItem.getCarritoId())
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        Asiento asiento = repoAsiento.findById(dtoCarritoItem.getAsientoId())
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));

        CarritoItem carritoItem = MapperCarritoItem.mapACarritoItem(dtoCarritoItem, carrito, asiento);
        CarritoItem carritoItemGuardado = repoCarritoItem.save(carritoItem);
        return MapperCarritoItem.mapADtoCarritoItem(carritoItemGuardado);
    }

    @Override
    public List<DtoCarritoItem> listarCarritoItems(Integer carritoId) {
        return repoCarritoItem.findByCarrito_Id(carritoId).stream()
                .map(MapperCarritoItem::mapADtoCarritoItem)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarCarritoItem(Integer id) {
        CarritoItem carritoItem = repoCarritoItem.findById(id)
                .orElseThrow(() -> new RuntimeException("CarritoItem no encontrado"));
        repoCarritoItem.delete(carritoItem);
    }
}
