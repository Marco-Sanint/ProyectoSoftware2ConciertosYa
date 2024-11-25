package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioEvento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@AllArgsConstructor
public class ControladorEvento {

    private final ServicioEvento servicioEvento;

    public ControladorEvento(ServicioEvento servicioEvento) {
        this.servicioEvento = servicioEvento;
    }

    @PostMapping
    public ResponseEntity<DtoEvento> crearEvento(@RequestBody DtoEvento dtoEvento) {
        DtoEvento eventoCreado = servicioEvento.crearEvento(dtoEvento);
        return new ResponseEntity<>(eventoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoEvento> obtenerEvento(@PathVariable Integer id) {
        DtoEvento evento = servicioEvento.obtenerEvento(id);
        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoEvento> actualizarEvento(@PathVariable Integer id, @RequestBody DtoEvento dtoEvento) {
        DtoEvento eventoActualizado = servicioEvento.actualizarEvento(id, dtoEvento);
        return ResponseEntity.ok(eventoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Integer id) {
        servicioEvento.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DtoEvento>> listarEventos() {
        List<DtoEvento> eventos = servicioEvento.listarEventos();
        return ResponseEntity.ok(eventos);
    }
}
