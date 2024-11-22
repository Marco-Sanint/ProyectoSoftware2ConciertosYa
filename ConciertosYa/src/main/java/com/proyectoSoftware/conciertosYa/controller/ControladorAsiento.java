
package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/asientos")
public class ControladorAsiento {
    private ServicioAsiento servicioAsiento;

    //Agregar Asiento A API REST
    @PostMapping
    public ResponseEntity<DtoAsiento> crearAsiento(@RequestBody DtoAsiento dtoAsiento){
        DtoAsiento asientoSalvado = servicioAsiento.crearAsiento(dtoAsiento);
        return new ResponseEntity<>(asientoSalvado, HttpStatus.CREATED);
    }

    //Encontrar Asiento De API REST
    @GetMapping("{asiento_id}")
    public ResponseEntity<DtoAsiento> getAsientoById(@PathVariable("asiento_id") Integer asientoId){
        DtoAsiento dtoAsiento = servicioAsiento.getAsiento(asientoId);
        return ResponseEntity.ok(dtoAsiento);
    }
}
