package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;
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

    public ImplServicioMetodoPago(RepoMetodoPago repoMetodoPago) {
        this.repoMetodoPago = repoMetodoPago;
    }

    @Override
    public DtoMetodoPago crearMetodoPago(DtoMetodoPago dtoMetodoPago) {
        MetodoPago metodoPago = MapperMetodoPago.mapAMetodoPago(dtoMetodoPago);
        MetodoPago metodoPagoGuardado = repoMetodoPago.save(metodoPago);
        return MapperMetodoPago.mapADtoMetodoPago(metodoPagoGuardado);
    }

    @Override
    public DtoMetodoPago obtenerMetodoPago(Integer id) {
        MetodoPago metodoPago = repoMetodoPago.findById(id)
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));
        return MapperMetodoPago.mapADtoMetodoPago(metodoPago);
    }

    @Override
    public List<DtoMetodoPago> listarMetodosPago() {
        return repoMetodoPago.findAll().stream()
                .map(MapperMetodoPago::mapADtoMetodoPago)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarMetodoPago(Integer id) {
        MetodoPago metodoPago = repoMetodoPago.findById(id)
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));
        repoMetodoPago.delete(metodoPago);
    }
}
