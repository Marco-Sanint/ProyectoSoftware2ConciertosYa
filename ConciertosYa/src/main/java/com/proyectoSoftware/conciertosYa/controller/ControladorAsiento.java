
package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Mostrar Todos Los Asientos De API REST
    @GetMapping
    public  ResponseEntity<List<DtoAsiento>> getAllAsientos(){
        List<DtoAsiento> asiento =  servicioAsiento.getAllAsiento();
        return ResponseEntity.ok(asiento);
    }

    //Actualizar Asientos De API REST
    @PutMapping("{asiento_id}")
    public ResponseEntity<DtoAsiento> updateAsiento(@PathVariable("asiento_id") Integer asiento_id, @RequestBody DtoAsiento updatedAsiento){
        DtoAsiento dtoAsiento = servicioAsiento.updateAsiento(asiento_id, updatedAsiento);
        return ResponseEntity.ok(dtoAsiento);
    }

    //Eliminar Asientos REST API
    @DeleteMapping("{asiento_id}")
    public ResponseEntity<String> deleteAsiento(@PathVariable("asiento_id") Integer asiento_id){
        servicioAsiento.deleteAsiento(asiento_id);
        return ResponseEntity.ok("Asiento eliminado");
    }
}