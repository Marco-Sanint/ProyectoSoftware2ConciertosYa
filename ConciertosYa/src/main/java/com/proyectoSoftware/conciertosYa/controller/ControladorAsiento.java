package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

