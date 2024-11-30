package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/promociones")
public class ControladorPromocion {
    private final ServicioPromocion servicioPromocion;

    // Agregar Promocion a API REST
    @PostMapping
    public ResponseEntity<DtoPromocion> crearPromocion(@RequestBody DtoPromocion dtoPromocion) {
        DtoPromocion promocionSalvada = servicioPromocion.crearPromocion(dtoPromocion);
        return new ResponseEntity<>(promocionSalvada, HttpStatus.CREATED);
    }

    // Encontrar Promocion de API REST
    @GetMapping("{promocion_id}")
    public ResponseEntity<DtoPromocion> getPromocionById(@PathVariable("promocion_id") Integer promocionId) {
        DtoPromocion dtoPromocion = servicioPromocion.getPromocion(promocionId);
        return ResponseEntity.ok(dtoPromocion);
    }

    // Mostrar Todas las Promociones de API REST
    @GetMapping
    public ResponseEntity<List<DtoPromocion>> getAllPromociones() {
        List<DtoPromocion> promociones = servicioPromocion.getAllPromociones();
        return ResponseEntity.ok(promociones);
    }

    // Actualizar Promocion de API REST
    @PutMapping("{promocion_id}")
    public ResponseEntity<DtoPromocion> updatePromocion(@PathVariable("promocion_id") Integer promocion_id, @RequestBody DtoPromocion updatedPromocion) {
        DtoPromocion dtoPromocion = servicioPromocion.updatePromocion(promocion_id, updatedPromocion);
        return ResponseEntity.ok(dtoPromocion);
    }

    // Eliminar Promocion de API REST
    @DeleteMapping("{promocion_id}")
    public ResponseEntity<String> deletePromocion(@PathVariable("promocion_id") Integer promocion_id) {
        servicioPromocion.deletePromocion(promocion_id);
        return ResponseEntity.ok("Promocion eliminada");
    }
}