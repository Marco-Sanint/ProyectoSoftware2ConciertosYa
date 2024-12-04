package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.service.ServicioEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import com.proyectoSoftware.conciertosYa.entity.Evento.EstadoEvento;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/eventos")
@AllArgsConstructor
public class ControladorEvento {

    private final ServicioEvento servicioEvento;
    private final ServicioLugar servicioLugar;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // Indicar que este método maneja 'multipart/form-data'
    public ResponseEntity<DtoEvento> crearEvento(
            @RequestParam("nombre") String nombre,
            @RequestParam("fecha") String fecha,
            @RequestParam("hora") String hora,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("generoMusical") String generoMusical,
            @RequestParam("estado") String estado,
            @RequestParam("lugarId") Integer lugarId,
            @RequestParam(value = "imagenCartel", required = false) MultipartFile imagenCartel) {

        // Crear el objeto DtoEvento a partir de los datos recibidos
        DtoEvento evento = new DtoEvento();
        evento.setNombre(nombre);
        evento.setFecha(LocalDate.parse(fecha)); // Convertir fecha a LocalDate
        evento.setHora(LocalTime.parse(hora)); // Convertir hora a LocalTime
        evento.setDescripcion(descripcion);
        evento.setGeneroMusical(generoMusical);
        evento.setEstado(EstadoEvento.valueOf(estado)); // Asumimos que 'estado' es un enum
        evento.setLugarId(lugarId);

        // Aquí podrías guardar la imagen y obtener su URL si es necesario
        if (imagenCartel != null && !imagenCartel.isEmpty()) {
            // Guarda la imagen en el servidor y obtén su URL
            String imagenUrl = saveImage(imagenCartel);
            evento.setImagenCartel(imagenUrl);
        }

        // Llamar al servicio para crear el evento
        DtoLugar lugarEvento = servicioLugar.getLugar(lugarId);
        DtoEvento eventoCreado = servicioEvento.crearEvento(evento, lugarEvento);
        return ResponseEntity.ok(eventoCreado);
    }

    // Método para guardar la imagen (puedes adaptarlo según tus necesidades)
    private String saveImage(MultipartFile file) {
        // Lógica para guardar la imagen y devolver la URL de la imagen
        // Ejemplo: guardar la imagen en una carpeta en el servidor
        // Aquí puedes usar cualquier lógica para almacenar la imagen y devolver su URL.
        return "url-de-la-imagen"; // Esto debe ser un URL real donde guardaste la imagen
    }

    @GetMapping("/{evento_id}")
    public ResponseEntity<DtoEvento> getEvento(@PathVariable Integer evento_id) {
        DtoEvento evento = servicioEvento.getEvento(evento_id);
        return ResponseEntity.ok(evento);
    }

    @GetMapping
    public ResponseEntity<List<DtoEvento>> getAllEventos() {
        List<DtoEvento> eventos = servicioEvento.getAllEventos();
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("/{evento_id}")
    public ResponseEntity<DtoEvento> updateEvento(@PathVariable Integer evento_id, @RequestBody DtoEvento updateEvento) {
        DtoEvento eventoActualizado = servicioEvento.updateEvento(evento_id, updateEvento);
        return ResponseEntity.ok(eventoActualizado);
    }

    @DeleteMapping("/{evento_id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Integer evento_id) {
        servicioEvento.deleteEvento(evento_id);
        return ResponseEntity.noContent().build();
    }
}
