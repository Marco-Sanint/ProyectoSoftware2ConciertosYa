package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodos-pago")
@AllArgsConstructor
public class ControladorMetodoPago {

    private final ServicioMetodoPago servicioMetodoPago;

    @PostMapping
    public ResponseEntity<DtoMetodoPago> crearMetodoPago(@RequestBody DtoMetodoPago dtoMetodoPago) {
        DtoMetodoPago metodoPagoCreado = servicioMetodoPago.crearMetodoPago(dtoMetodoPago);
        return ResponseEntity.ok(metodoPagoCreado);
    }

    @GetMapping("/{metodo_pago_id}")
    public ResponseEntity<DtoMetodoPago> getMetodoPago(@PathVariable Integer metodo_pago_id) {
        DtoMetodoPago metodoPago = servicioMetodoPago.getMetodoPago(metodo_pago_id);
        return ResponseEntity.ok(metodoPago);
    }

    @GetMapping
    public ResponseEntity<List<DtoMetodoPago>> getAllMetodosPago() {
        List<DtoMetodoPago> metodosPago = servicioMetodoPago.getAllMetodosPago();
        return ResponseEntity.ok(metodosPago);
    }

    @PutMapping("/{metodo_pago_id}")
    public ResponseEntity<DtoMetodoPago> updateMetodoPago(@PathVariable Integer metodo_pago_id, @RequestBody DtoMetodoPago updateMetodoPago) {
        DtoMetodoPago metodoPagoActualizado = servicioMetodoPago.updateMetodoPago(metodo_pago_id, updateMetodoPago);
        return ResponseEntity.ok(metodoPagoActualizado);
    }

    @DeleteMapping("/{metodo_pago_id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer metodo_pago_id) {
        servicioMetodoPago.deleteMetodoPago(metodo_pago_id);
        return ResponseEntity.noContent().build();
    }
}