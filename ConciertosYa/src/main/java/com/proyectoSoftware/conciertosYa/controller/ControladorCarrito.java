package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carritos")
public class ControladorCarrito {

    private final ServicioCarrito servicioCarrito;

    public ControladorCarrito(ServicioCarrito servicioCarrito) {
        this.servicioCarrito = servicioCarrito;
    }

    @PostMapping
    public ResponseEntity<DtoCarrito> crearCarrito(@RequestBody DtoCarrito dtoCarrito) {
        DtoCarrito creado = servicioCarrito.crearCarrito(dtoCarrito);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DtoCarrito> getCarrito(@PathVariable Integer id) {
        DtoCarrito dto = servicioCarrito.getCarrito(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Integer id) {
        servicioCarrito.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DtoCarrito>> listarCarritos() {
        List<DtoCarrito> lista = servicioCarrito.listarCarritos();
        return ResponseEntity.ok(lista);
    }
}
