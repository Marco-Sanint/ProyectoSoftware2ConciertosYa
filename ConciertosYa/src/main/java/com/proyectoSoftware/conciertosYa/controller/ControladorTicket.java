package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@AllArgsConstructor
public class ControladorTicket {

    private final ServicioTicket servicioTicket;

    public ControladorTicket(ServicioTicket servicioTicket) {
        this.servicioTicket = servicioTicket;
    }

    @PostMapping
    public ResponseEntity<DtoTicket> crearTicket(@RequestBody DtoTicket dtoTicket) {
        DtoTicket ticketCreado = servicioTicket.crearTicket(dtoTicket);
        return new ResponseEntity<>(ticketCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoTicket> obtenerTicket(@PathVariable Integer id) {
        DtoTicket ticket = servicioTicket.obtenerTicket(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<DtoTicket>> listarTicketsPorCliente(@PathVariable String clienteId) {
        List<DtoTicket> tickets = servicioTicket.listarTicketsPorCliente(clienteId);
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Integer id) {
        servicioTicket.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }
}
