package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ControladorCliente {

    private ServicioCliente servicioCliente;

    //Agregar Cliente A API REST
    @PostMapping
    public ResponseEntity<DtoCliente> crearCliente(@RequestBody DtoCliente dtoCliente){
        DtoCliente clienteSalvado = servicioCliente.crearCliente(dtoCliente);
        return new ResponseEntity<>(clienteSalvado, HttpStatus.CREATED);
    }

}
