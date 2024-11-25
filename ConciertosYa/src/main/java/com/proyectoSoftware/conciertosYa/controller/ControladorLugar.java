package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lugares")
@AllArgsConstructor
public class ControladorLugar {

    private final ServicioLugar servicioLugar;

    public ControladorLugar(ServicioLugar servicioLugar) {
        this.servicioLugar = servicioLugar;
    }

    @PostMapping
    public ResponseEntity<DtoLugar> crearLugar(@RequestBody DtoLugar dtoLugar) {
        DtoLugar lugarCreado = servicioLugar.crearLugar(dtoLugar);
        return new ResponseEntity<>(lugarCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoLugar> obtenerLugar(@PathVariable Integer id) {
        DtoLugar lugar = servicioLugar.obtenerLugar(id);
        return ResponseEntity.ok(lugar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoLugar> actualizarLugar(@PathVariable Integer id, @RequestBody DtoLugar dtoLugar) {
        DtoLugar lugarActualizado = servicioLugar.actualizarLugar(id, dtoLugar);
        return ResponseEntity.ok(lugarActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLugar(@PathVariable Integer id) {
        servicioLugar.eliminarLugar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DtoLugar>> listarLugares() {
        List<DtoLugar> lugares = servicioLugar.listarLugares();
        return ResponseEntity.ok(lugares);
    }
}
