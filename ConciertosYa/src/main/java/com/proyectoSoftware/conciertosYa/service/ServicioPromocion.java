package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;

import java.util.List;

public interface ServicioPromocion {
    DtoPromocion crearPromocion(DtoPromocion dtoPromocion);

    DtoPromocion obtenerPromocion(Integer id);

    List<DtoPromocion> listarPromociones();

    List<DtoPromocion> listarPromocionesPorTipo(String tipo);

    DtoPromocion actualizarPromocion(Integer id, DtoPromocion dtoPromocion);

    void eliminarPromocion(Integer id);
}
