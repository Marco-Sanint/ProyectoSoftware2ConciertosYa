package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
@AllArgsConstructor
public class ControladorCarrito {

    private final ServicioCarrito servicioCarrito;
    private final ServicioCliente servicioCliente;

    @PostMapping
    public ResponseEntity<DtoCarrito> crearCarrito(@RequestBody DtoCarrito dtoCarrito) {
        DtoCliente dtoCliente = servicioCliente.getCliente(dtoCarrito.getCedulaCliente());

        DtoCarrito carritoCreado = servicioCarrito.createCarrito(dtoCarrito, dtoCliente);
        return ResponseEntity.ok(carritoCreado);
    }

    @GetMapping("/{carrito_id}")
    public ResponseEntity<DtoCarrito> getCarrito(@PathVariable Integer carrito_id) {
        DtoCarrito carrito = servicioCarrito.getCarrito(carrito_id);
        return ResponseEntity.ok(carrito);
    }

    @GetMapping
    public ResponseEntity<List<DtoCarrito>> getAllCarritos() {
        List<DtoCarrito> carritos = servicioCarrito.getAllCarritos();
        return ResponseEntity.ok(carritos);
    }

    @PutMapping("/{carrito_id}")
    public ResponseEntity<DtoCarrito> updateCarrito(@PathVariable Integer carrito_id, @RequestBody DtoCarrito updateCarrito) {
        DtoCarrito carritoActualizado = servicioCarrito.updateCarrito(carrito_id, updateCarrito);
        return ResponseEntity.ok(carritoActualizado);
    }

    @DeleteMapping("/{carrito_id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable Integer carrito_id) {
        servicioCarrito.deleteCarrito(carrito_id);
        return ResponseEntity.noContent().build();
    }
}