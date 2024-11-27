package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class ControladorTicket {

    private final ServicioTicket servicioTicket;

    @PostMapping
    public ResponseEntity<DtoTicket> createTicket(@RequestBody DtoTicket dtoTicket) {
        DtoTicket savedTicket = servicioTicket.createTicket(dtoTicket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<DtoTicket> getTicketById(@PathVariable("ticketId") Integer ticketId) {
        DtoTicket dtoTicket = servicioTicket.getTicket(ticketId);
        return ResponseEntity.ok(dtoTicket);
    }

    @GetMapping
    public ResponseEntity<List<DtoTicket>> getAllTickets() {
        List<DtoTicket> tickets = servicioTicket.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<DtoTicket> updateTicket(@PathVariable("ticketId") Integer ticketId,
                                                  @RequestBody DtoTicket updateTicket) {
        DtoTicket dtoTicket = servicioTicket.updateTicket(ticketId, updateTicket);
        return ResponseEntity.ok(dtoTicket);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId) {
        servicioTicket.deleteTicket(ticketId);
        return ResponseEntity.ok("Ticket eliminado");
    }
}