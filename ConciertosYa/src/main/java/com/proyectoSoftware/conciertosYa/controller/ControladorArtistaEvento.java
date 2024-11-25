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

    public ControladorArtistaEvento(ServicioArtistaEvento servicioArtistaEvento) {
        this.servicioArtistaEvento = servicioArtistaEvento;
    }

    @PostMapping
    public ResponseEntity<DtoArtistaEvento> crearArtistaEvento(@RequestBody DtoArtistaEvento dtoArtistaEvento) {
        DtoArtistaEvento creado = servicioArtistaEvento.crearArtistaEvento(dtoArtistaEvento);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DtoArtistaEvento> getArtistaEvento(@PathVariable Integer id) {
        DtoArtistaEvento dto = servicioArtistaEvento.getArtistaEvento(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarArtistaEvento(@PathVariable Integer id) {
        servicioArtistaEvento.eliminarArtistaEvento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DtoArtistaEvento>> listarArtistasEventos() {
        List<DtoArtistaEvento> lista = servicioArtistaEvento.listarArtistasEventos();
        return ResponseEntity.ok(lista);
    }
}
