package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.entity.CarritoItem;
import com.proyectoSoftware.conciertosYa.entity.Carrito; // Asegúrate de importar la entidad Carrito
import com.proyectoSoftware.conciertosYa.entity.Asiento; // Asegúrate de importar la entidad Asiento
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperCarritoItem;
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
    public DtoCarritoItem createCarritoItem(DtoCarritoItem dtoCarritoItem) {
        Carrito carrito = repoCarrito.findById(dtoCarritoItem.getCarritoId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado: " + dtoCarritoItem.getCarritoId()));
        Asiento asiento = repoAsiento.findById(dtoCarritoItem.getAsientoId())
                .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado: " + dtoCarritoItem.getAsientoId()));

        CarritoItem carritoItem = MapperCarritoItem.mapACarritoItem(dtoCarritoItem);
        carritoItem.setCarrito(carrito); // Asignamos el carrito
        carritoItem.setAsiento(asiento); // Asignamos el asiento
        CarritoItem savedCarritoItem = repoCarritoItem.save(carritoItem);
        return MapperCarritoItem.mapADtoCarritoItem(savedCarritoItem);
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