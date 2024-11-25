package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
@AllArgsConstructor
public class ControladorPromocion {

    private final ServicioPromocion servicioPromocion;

    public ControladorPromocion(ServicioPromocion servicioPromocion) {
        this.servicioPromocion = servicioPromocion;
    }

    @PostMapping
    public ResponseEntity<DtoPromocion> crearPromocion(@RequestBody DtoPromocion dtoPromocion) {
        DtoPromocion promocionCreada = servicioPromocion.crearPromocion(dtoPromocion);
        return new ResponseEntity<>(promocionCreada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoPromocion> obtenerPromocion(@PathVariable Integer id) {
        DtoPromocion promocion = servicioPromocion.obtenerPromocion(id);
        return ResponseEntity.ok(promocion);
    }

    @GetMapping
    public ResponseEntity<List<DtoPromocion>> listarPromociones() {
        List<DtoPromocion> promociones = servicioPromocion.listarPromociones();
        return ResponseEntity.ok(promociones);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<DtoPromocion>> listarPromocionesPorTipo(@PathVariable String tipo) {
        List<DtoPromocion> promociones = servicioPromocion.listarPromocionesPorTipo(tipo);
        return ResponseEntity.ok(promociones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoPromocion> actualizarPromocion(@PathVariable Integer id, @RequestBody DtoPromocion dtoPromocion) {
        DtoPromocion promocionActualizada = servicioPromocion.actualizarPromocion(id, dtoPromocion);
        return ResponseEntity.ok(promocionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Integer id) {
        servicioPromocion.eliminarPromocion(id);
        return ResponseEntity.noContent().build();
    }
}
