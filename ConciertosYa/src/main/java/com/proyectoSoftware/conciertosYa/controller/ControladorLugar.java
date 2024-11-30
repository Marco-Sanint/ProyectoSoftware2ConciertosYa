package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lugares")
@AllArgsConstructor
public class ControladorLugar {

    private final ServicioLugar servicioLugar;

    @PostMapping
    public ResponseEntity<DtoLugar> crearLugar(@RequestBody DtoLugar dtoLugar) {
        DtoLugar lugarCreado = servicioLugar.crearLugar(dtoLugar);
        return ResponseEntity.ok(lugarCreado);
    }

    @GetMapping("/{lugar_id}")
    public ResponseEntity<DtoLugar> getLugar(@PathVariable int lugar_id) {
        DtoLugar lugar = servicioLugar.getLugar(lugar_id);
        return ResponseEntity.ok(lugar);
    }

    @GetMapping
    public ResponseEntity<List<DtoLugar>> getAllLugares() {
        List<DtoLugar> lugares = servicioLugar.getAllLugares();
        return ResponseEntity.ok(lugares);
    }

    @PutMapping("/{lugar_id}")
    public ResponseEntity<DtoLugar> updateLugar(@PathVariable int lugar_id, @RequestBody DtoLugar updateLugar) {
        DtoLugar lugarActualizado = servicioLugar.updateLugar(lugar_id, updateLugar);
        return ResponseEntity.ok(lugarActualizado);
    }

    @DeleteMapping("/{lugar_id}")
    public ResponseEntity<Void> deleteLugar(@PathVariable int lugar_id) {
        servicioLugar.deleteLugar(lugar_id);
        return ResponseEntity.noContent().build();
    }
}