package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.*;
import com.proyectoSoftware.conciertosYa.service.ServicioArtista;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCarritoItem;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carrito-items")
public class ControladorCarritoItem {

    private final ServicioCarritoItem servicioCarritoItem;
    private final ServicioCarrito servicioCarrito;
    private final ServicioAsiento servicioAsiento;

    @PostMapping
    public ResponseEntity<DtoCarritoItem> createCarritoItem(@RequestBody DtoCarritoItem dtoCarritoItem) {
        DtoCarrito dtoCarrito = servicioCarrito.getCarrito(dtoCarritoItem.getCarritoId());
        DtoAsiento dtoAsiento = servicioAsiento.getAsiento(dtoCarritoItem.getAsientoId());

        DtoCarritoItem carritoItemCreado = servicioCarritoItem.createCarritoItem(dtoCarritoItem, dtoAsiento, dtoCarrito);
        return ResponseEntity.ok(carritoItemCreado);
    }

    @GetMapping("/{carritoItemId}")
    public ResponseEntity<DtoCarritoItem> getCarritoItemById(@PathVariable("carritoItemId") Integer carritoItemId) {
        DtoCarritoItem dtoCarritoItem = servicioCarritoItem.getCarritoItem(carritoItemId);
        return ResponseEntity.ok(dtoCarritoItem);
    }

    @GetMapping
    public ResponseEntity<List<DtoCarritoItem>> getAllCarritoItems() {
        List<DtoCarritoItem> carritoItems = servicioCarritoItem.getAllCarritoItems();
        return ResponseEntity.ok(carritoItems);
    }

    @PutMapping("/{carritoItemId}")
    public ResponseEntity<DtoCarritoItem> updateCarritoItem(@PathVariable("carritoItemId") Integer carritoItemId,
                                                            @RequestBody DtoCarritoItem updateCarritoItem) {
        DtoCarritoItem dtoCarritoItem = servicioCarritoItem.updateCarritoItem(carritoItemId, updateCarritoItem);
        return ResponseEntity.ok(dtoCarritoItem);
    }

    @DeleteMapping("/{carritoItemId}")
    public ResponseEntity<String> deleteCarritoItem(@PathVariable("carritoItemId") Integer carritoItemId) {
        servicioCarritoItem.deleteCarritoItem(carritoItemId);
        return ResponseEntity.ok("CarritoItem eliminado");
    }
}