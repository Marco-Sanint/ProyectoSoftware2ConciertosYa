package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.service.ServicioArtista;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artistas")
public class ControladorArtista {

    private final ServicioArtista servicioArtista;

    // Crear Artista en API REST
    @PostMapping
    public ResponseEntity<DtoArtista> crearArtista(@RequestBody DtoArtista dtoArtista) {
        DtoArtista artistaSalvado = servicioArtista.crearArtista(dtoArtista);
        return new ResponseEntity<>(artistaSalvado, HttpStatus.CREATED);
    }

    // Obtener Artista por ID en API REST
    @GetMapping("{artista_id}")
    public ResponseEntity<DtoArtista> getArtistaById(@PathVariable("artista_id") Integer artistaId) {
        DtoArtista dtoArtista = servicioArtista.getArtista(artistaId);
        return ResponseEntity.ok(dtoArtista);
    }

    // Actualizar Artista en API REST
    @PutMapping("{artista_id}")
    public ResponseEntity<DtoArtista> actualizarArtista(@PathVariable("artista_id") Integer artistaId,
                                                        @RequestBody DtoArtista dtoArtista) {
        DtoArtista artistaActualizado = servicioArtista.updateArtista(artistaId, dtoArtista);
        return ResponseEntity.ok(artistaActualizado);
    }

    // Eliminar Artista en API REST
    @DeleteMapping("{artista_id}")
    public ResponseEntity<Void> eliminarArtista(@PathVariable("artista_id") Integer artistaId) {
        servicioArtista.deleteArtista(artistaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener todos los Artistas (opcional)
    @GetMapping
    public ResponseEntity<List<DtoArtista>> listarArtistas() {
        List<DtoArtista> artistas = servicioArtista.getAllArtistas();
        return ResponseEntity.ok(artistas);
    }
}