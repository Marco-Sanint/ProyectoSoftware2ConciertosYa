package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioArtistaEvento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artistas-eventos")
public class ControladorArtistaEvento {

    private final ServicioArtistaEvento servicioArtistaEvento;

    @PostMapping
    public ResponseEntity<DtoArtistaEvento> createArtistaEvento(@RequestBody DtoArtistaEvento dtoArtistaEvento) {
        DtoArtistaEvento savedArtistaEvento = servicioArtistaEvento.createArtistaEvento(dtoArtistaEvento);
        return new ResponseEntity<>(savedArtistaEvento, HttpStatus.CREATED);
    }

    @GetMapping("{artistaEventoId}")
    public ResponseEntity<DtoArtistaEvento> getArtistaEventoById(@PathVariable("artistaEventoId") Integer artistaEventoId) {
        DtoArtistaEvento dtoArtistaEvento = servicioArtistaEvento.getArtistaEvento(artistaEventoId);
        return ResponseEntity.ok(dtoArtistaEvento);
    }

    @GetMapping
    public ResponseEntity<List<DtoArtistaEvento>> getAllArtistasEventos() {
        List<DtoArtistaEvento> artistasEventos = servicioArtistaEvento.getAllArtistasEventos();
        return ResponseEntity.ok(artistasEventos);
    }

    @PutMapping("{artistaEventoId}")
    public ResponseEntity<DtoArtistaEvento> updateArtistaEvento(@PathVariable("artistaEventoId") Integer artistaEventoId,
                                                                @RequestBody DtoArtistaEvento updatedArtistaEvento) {
        DtoArtistaEvento dtoArtistaEvento = servicioArtistaEvento.updateArtistaEvento(artistaEventoId, updatedArtistaEvento);
        return ResponseEntity.ok(dtoArtistaEvento);
    }

    @DeleteMapping("{artistaEventoId}")
    public ResponseEntity<String> deleteArtistaEvento(@PathVariable("artistaEventoId") Integer artistaEventoId) {
        servicioArtistaEvento.deleteArtistaEvento(artistaEventoId);
        return ResponseEntity.ok("ArtistaEvento eliminado");
    }
}