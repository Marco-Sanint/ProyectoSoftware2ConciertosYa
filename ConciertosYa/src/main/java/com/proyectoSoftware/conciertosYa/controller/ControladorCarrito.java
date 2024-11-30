package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carritos")
public class ControladorCarrito {

    private final ServicioCarrito servicioCarrito;

    @PostMapping
    public ResponseEntity<DtoCarrito> createCarrito(@RequestBody DtoCarrito dtoCarrito) {
        DtoCarrito savedCarrito = servicioCarrito.createCarrito(dtoCarrito);
        return new ResponseEntity<>(savedCarrito, HttpStatus.CREATED);
    }

    @GetMapping("{carritoId}")
    public ResponseEntity<DtoCarrito> getCarritoById(@PathVariable("carritoId") Integer carritoId) {
        DtoCarrito dtoCarrito = servicioCarrito.getCarrito(carritoId);
        return ResponseEntity.ok(dtoCarrito);
    }

    @GetMapping
    public ResponseEntity<List<DtoCarrito>> getAllCarritos() {
        List<DtoCarrito> carritos = servicioCarrito.getAllCarritos();
        return ResponseEntity.ok(carritos);
    }

    @PutMapping("{carritoId}")
    public ResponseEntity<DtoCarrito> updateCarrito(@PathVariable("carritoId") Integer carritoId,
                                                    @RequestBody DtoCarrito updatedCarrito) {
        DtoCarrito dtoCarrito = servicioCarrito.updateCarrito(carritoId, updatedCarrito);
        return ResponseEntity.ok(dtoCarrito);
    }

    @DeleteMapping("{carritoId}")
    public ResponseEntity<String> deleteCarrito(@PathVariable("carritoId") Integer carritoId) {
        servicioCarrito.deleteCarrito(carritoId);
        return ResponseEntity.ok("Carrito eliminado");
    }
}