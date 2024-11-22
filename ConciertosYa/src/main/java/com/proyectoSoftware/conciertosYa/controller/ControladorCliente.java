
package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ControladorCliente {

    private ServicioCliente servicioCliente;

    //Agregar Cliente A API REST
    @PostMapping
    public ResponseEntity<DtoCliente> createCliente(@RequestBody DtoCliente dtoCliente){
        DtoCliente clienteSalvado = servicioCliente.createCliente(dtoCliente);
        return new ResponseEntity<>(clienteSalvado, HttpStatus.CREATED);
    }

    //Encontrar Cliente De API REST
    @GetMapping("{cedula}")
    public ResponseEntity<DtoCliente> getClienteById(@PathVariable("cedula") String cedulaCliente){
        DtoCliente dtoCliente = servicioCliente.getCliente(cedulaCliente);
        return ResponseEntity.ok(dtoCliente);
    }

}