package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
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

    @PostMapping
    public ResponseEntity<DtoCarritoItem> createCarritoItem(@RequestBody DtoCarritoItem dtoCarritoItem) {
        DtoCarritoItem savedCarritoItem = servicioCarritoItem.createCarritoItem(dtoCarritoItem);
        return new ResponseEntity<>(savedCarritoItem, HttpStatus.CREATED);
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