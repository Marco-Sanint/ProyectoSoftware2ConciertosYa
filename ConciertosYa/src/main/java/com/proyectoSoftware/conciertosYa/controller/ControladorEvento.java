package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioEvento;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@AllArgsConstructor
public class ControladorEvento {

    private final ServicioEvento servicioEvento;

    @PostMapping
    public ResponseEntity<DtoEvento> crearEvento(@RequestBody DtoEvento dtoEvento) {
        DtoEvento eventoCreado = servicioEvento.crearEvento(dtoEvento);
        return ResponseEntity.ok(eventoCreado);
    }

    @GetMapping("/{evento_id}")
    public ResponseEntity<DtoEvento> getEvento(@PathVariable Integer evento_id) {
        DtoEvento evento = servicioEvento.getEvento(evento_id);
        return ResponseEntity.ok(evento);
    }

    @GetMapping
    public ResponseEntity<List<DtoEvento>> getAllEventos() {
        List<DtoEvento> eventos = servicioEvento.getAllEventos();
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("/{evento_id}")
    public ResponseEntity<DtoEvento> updateEvento(@PathVariable Integer evento_id, @RequestBody DtoEvento updateEvento) {
        DtoEvento eventoActualizado = servicioEvento.updateEvento(evento_id, updateEvento);
        return ResponseEntity.ok(eventoActualizado);
    }

    @DeleteMapping("/{evento_id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Integer evento_id) {
        servicioEvento.deleteEvento(evento_id);
        return ResponseEntity.noContent().build();
    }
}