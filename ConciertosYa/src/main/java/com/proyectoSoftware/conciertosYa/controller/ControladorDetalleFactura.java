package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioDetalleFactura;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-factura")
@AllArgsConstructor
public class ControladorDetalleFactura {

    private final ServicioDetalleFactura servicioDetalleFactura;

    public ControladorDetalleFactura(ServicioDetalleFactura servicioDetalleFactura) {
        this.servicioDetalleFactura = servicioDetalleFactura;
    }

    @PostMapping
    public ResponseEntity<DtoDetalleFactura> crearDetalleFactura(@RequestBody DtoDetalleFactura dtoDetalleFactura) {
        DtoDetalleFactura detalleCreado = servicioDetalleFactura.crearDetalleFactura(dtoDetalleFactura);
        return new ResponseEntity<>(detalleCreado, HttpStatus.CREATED);
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<DtoDetalleFactura>> listarDetallesPorTicket(@PathVariable Integer ticketId) {
        List<DtoDetalleFactura> detalles = servicioDetalleFactura.listarDetallesPorTicket(ticketId);
        return ResponseEntity.ok(detalles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleFactura(@PathVariable Integer id) {
        servicioDetalleFactura.eliminarDetalleFactura(id);
        return ResponseEntity.noContent().build();
    }
}

