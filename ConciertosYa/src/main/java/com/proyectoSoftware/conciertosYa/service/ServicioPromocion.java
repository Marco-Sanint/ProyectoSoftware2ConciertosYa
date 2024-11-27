package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;

import java.util.List;

public interface ServicioPromocion {
    DtoPromocion crearPromocion(DtoPromocion dtoPromocion);
    DtoPromocion getPromocion(Integer promocion_id);
    List<DtoPromocion> getAllPromociones();
    DtoPromocion updatePromocion(Integer promocion_id, DtoPromocion updatePromocion);
    void deletePromocion(Integer promocion_id);
}