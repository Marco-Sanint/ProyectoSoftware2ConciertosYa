package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos-pago")
@AllArgsConstructor
public class ControladorMetodoPago {

    private final ServicioMetodoPago servicioMetodoPago;

    public ControladorMetodoPago(ServicioMetodoPago servicioMetodoPago) {
        this.servicioMetodoPago = servicioMetodoPago;
    }

    @PostMapping
    public ResponseEntity<DtoMetodoPago> crearMetodoPago(@RequestBody DtoMetodoPago dtoMetodoPago) {
        DtoMetodoPago metodoPagoCreado = servicioMetodoPago.crearMetodoPago(dtoMetodoPago);
        return new ResponseEntity<>(metodoPagoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoMetodoPago> obtenerMetodoPago(@PathVariable Integer id) {
        DtoMetodoPago metodoPago = servicioMetodoPago.obtenerMetodoPago(id);
        return ResponseEntity.ok(metodoPago);
    }

    @GetMapping
    public ResponseEntity<List<DtoMetodoPago>> listarMetodosPago() {
        List<DtoMetodoPago> metodosPago = servicioMetodoPago.listarMetodosPago();
        return ResponseEntity.ok(metodosPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMetodoPago(@PathVariable Integer id) {
        servicioMetodoPago.eliminarMetodoPago(id);
        return ResponseEntity.noContent().build();
    }
}
