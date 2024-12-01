package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.entity.*;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.*;
import com.proyectoSoftware.conciertosYa.repository.RepoCarritoItem;
import com.proyectoSoftware.conciertosYa.repository.RepoCarrito; // Asegúrate de importar el repositorio de Carrito
import com.proyectoSoftware.conciertosYa.repository.RepoAsiento; // Asegúrate de importar el repositorio de Asiento
import com.proyectoSoftware.conciertosYa.service.ServicioCarritoItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioCarritoItem implements ServicioCarritoItem {

    private final RepoCarritoItem repoCarritoItem;
    private final RepoCarrito repoCarrito; // Inyectamos el repositorio de Carrito
    private final RepoAsiento repoAsiento; // Inyectamos el repositorio de Asiento

    @Override
    public DtoCarritoItem createCarritoItem(DtoCarritoItem dtoCarritoItem, DtoAsiento dtoAsiento, DtoCarrito dtoCarrito) {
        Carrito carrito = MapperCarrito.mapACarrito(dtoCarrito);
        Asiento asiento = MapperAsiento.mapAAsiento(dtoAsiento);

        CarritoItem carritoItem = MapperCarritoItem.mapACarritoItem(dtoCarritoItem);
        carritoItem.setCarrito(carrito);
        carritoItem.setAsiento(asiento);

        return MapperCarritoItem.mapADtoCarritoItem(repoCarritoItem.save(carritoItem));
    }

    @Override
    public DtoCarritoItem getCarritoItem(Integer carritoItemId) {
        CarritoItem carritoItem = repoCarritoItem.findById(carritoItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CarritoItem no encontrado: " + carritoItemId));
        return MapperCarritoItem.mapADtoCarritoItem(carritoItem);
    }

    @Override
    public List<DtoCarritoItem> getAllCarritoItems() {
        List<CarritoItem> carritoItems = repoCarritoItem.findAll();
        return carritoItems.stream()
                .map(MapperCarritoItem::mapADtoCarritoItem)
                .collect(Collectors.toList());
    }

    @Override
    public DtoCarritoItem updateCarritoItem(Integer carritoItemId, DtoCarritoItem updateCarritoItem) {
        CarritoItem carritoItem = repoCarritoItem.findById(carritoItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CarritoItem no encontrado: " + carritoItemId));

        // Actualizamos los campos necesarios
        carritoItem.setCantidad(updateCarritoItem.getCantidad());

        // Buscamos el carrito y el asiento por sus IDs y los asignamos
        Carrito carrito = repoCarrito.findById(updateCarritoItem.getCarritoId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado: " + updateCarritoItem.getCarritoId()));
        Asiento asiento = repoAsiento.findById(updateCarritoItem.getAsientoId())
                .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado: " + updateCarritoItem.getAsientoId()));

        carritoItem.setCarrito(carrito);
        carritoItem.setAsiento(asiento);

        CarritoItem updatedCarritoItem = repoCarritoItem.save(carritoItem);
        return MapperCarritoItem.mapADtoCarritoItem(updatedCarritoItem);
    }

    @Override
    public void deleteCarritoItem(Integer carritoItemId) {
        CarritoItem carritoItem = repoCarritoItem.findById(carritoItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CarritoItem no encontrado: " + carritoItemId));
        repoCarritoItem.delete(carritoItem);
    }
}