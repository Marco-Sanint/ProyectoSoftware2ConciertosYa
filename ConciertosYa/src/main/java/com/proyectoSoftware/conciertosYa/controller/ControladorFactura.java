package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioFactura;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@AllArgsConstructor
public class ControladorFactura {

    private final ServicioFactura servicioFactura;

    public ControladorFactura(ServicioFactura servicioFactura) {
        this.servicioFactura = servicioFactura;
    }

    @PostMapping
    public ResponseEntity<DtoFactura> crearFactura(@RequestBody DtoFactura dtoFactura) {
        DtoFactura facturaCreada = servicioFactura.crearFactura(dtoFactura);
        return new ResponseEntity<>(facturaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoFactura> obtenerFactura(@PathVariable Integer id) {
        DtoFactura factura = servicioFactura.obtenerFactura(id);
        return ResponseEntity.ok(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoFactura> actualizarFactura(@PathVariable Integer id, @RequestBody DtoFactura dtoFactura) {
        DtoFactura facturaActualizada = servicioFactura.actualizarFactura(id, dtoFactura);
        return ResponseEntity.ok(facturaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Integer id) {
        servicioFactura.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DtoFactura>> listarFacturas() {
        List<DtoFactura> facturas = servicioFactura.listarFacturas();
        return ResponseEntity.ok(facturas);
    }
}
