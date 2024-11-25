package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.service.ServicioCarritoItem;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito-items")
@AllArgsConstructor
public class ControladorCarritoItem {

    private final ServicioCarritoItem servicioCarritoItem;

    public ControladorCarritoItem(ServicioCarritoItem servicioCarritoItem) {
        this.servicioCarritoItem = servicioCarritoItem;
    }

    @PostMapping
    public ResponseEntity<DtoCarritoItem> crearCarritoItem(@RequestBody DtoCarritoItem dtoCarritoItem) {
        DtoCarritoItem carritoItemCreado = servicioCarritoItem.crearCarritoItem(dtoCarritoItem);
        return new ResponseEntity<>(carritoItemCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{carritoId}")
    public ResponseEntity<List<DtoCarritoItem>> listarCarritoItems(@PathVariable Integer carritoId) {
        List<DtoCarritoItem> carritoItems = servicioCarritoItem.listarCarritoItems(carritoId);
        return ResponseEntity.ok(carritoItems);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarritoItem(@PathVariable Integer id) {
        servicioCarritoItem.eliminarCarritoItem(id);
        return ResponseEntity.noContent().build();
    }
}
