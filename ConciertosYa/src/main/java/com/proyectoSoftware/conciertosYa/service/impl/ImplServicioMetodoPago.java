package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperMetodoPago;
import com.proyectoSoftware.conciertosYa.repository.RepoMetodoPago;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioMetodoPago implements ServicioMetodoPago {

    private final RepoMetodoPago repoMetodoPago;

    @Override
    public DtoMetodoPago crearMetodoPago(DtoMetodoPago dtoMetodoPago) {
        MetodoPago metodoPago = MapperMetodoPago.mapAMetodoPago(dtoMetodoPago);
        MetodoPago salvadoMetodoPago = repoMetodoPago.save(metodoPago);
        return MapperMetodoPago.mapADtoMetodoPago(salvadoMetodoPago);
    }

    @Override
    public DtoMetodoPago getMetodoPago(Integer metodo_pago_id) {
        MetodoPago metodoPago = repoMetodoPago.findById(metodo_pago_id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado: " + metodo_pago_id));
        return MapperMetodoPago.mapADtoMetodoPago(metodoPago);
    }

    @Override
    public List<DtoMetodoPago> getAllMetodosPago() {
        List<MetodoPago> metodosPago = repoMetodoPago.findAll();
        return metodosPago.stream()
                .map(MapperMetodoPago::mapADtoMetodoPago)
                .collect(Collectors.toList());
    }

    @Override
    public DtoMetodoPago updateMetodoPago(Integer metodo_pago_id, DtoMetodoPago updateMetodoPago) {
        MetodoPago metodoPago = repoMetodoPago.findById(metodo_pago_id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado: " + metodo_pago_id));

        metodoPago.setTipo(updateMetodoPago.getTipo());
        MetodoPago actualizado = repoMetodoPago.save(metodoPago);
        return MapperMetodoPago.mapADtoMetodoPago(actualizado);
    }

    @Override
    public void deleteMetodoPago(Integer metodo_pago_id) {
        MetodoPago metodoPago = repoMetodoPago.findById(metodo_pago_id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado: " + metodo_pago_id));
        repoMetodoPago.delete(metodoPago);
    }
}