
package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    // Ruta de login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");  // Cambiar "email" según lo que envíe el frontend
        String password = requestBody.get("password");

        boolean isAuthenticated = servicioCliente.authenticate(email, password);

        if (isAuthenticated) {
            return ResponseEntity.ok(Map.of("message", "Autenticación exitosa"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Credenciales incorrectas"));
        }
    }

    //Encontrar Cliente De API REST
    @GetMapping("{cedula}")
    public ResponseEntity<DtoCliente> getClienteById(@PathVariable("cedula") String cedulaCliente){
        DtoCliente dtoCliente = servicioCliente.getCliente(cedulaCliente);
        return ResponseEntity.ok(dtoCliente);
    }

    //Mostrar Todos Los Clientes De API REST
    @GetMapping
    public  ResponseEntity<List<DtoCliente>> getAllClientes(){
        List<DtoCliente> clientes =  servicioCliente.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    //Actualizar Cliente De API REST
    @PutMapping("{cedula}")
    public ResponseEntity<DtoCliente> updateCliente(@PathVariable("cedula") String cedulaCliente, @RequestBody DtoCliente updatedCliente){
        DtoCliente dtoCliente = servicioCliente.updateCliente(cedulaCliente, updatedCliente);
        return ResponseEntity.ok(dtoCliente);
    }

    //Eliminar Cliente REST API
    @DeleteMapping("{cedula}")
    public ResponseEntity<String> deleteCliente(@PathVariable("cedula") String cedulaCliente){
        servicioCliente.deleteCliente(cedulaCliente);
        return ResponseEntity.ok("Cliente eliminado");
    }
}