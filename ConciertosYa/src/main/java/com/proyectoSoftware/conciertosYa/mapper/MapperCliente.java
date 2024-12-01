package com.proyectoSoftware.conciertosYa.mapper;


import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.entity.Cliente;


public class MapperCliente {

    public static DtoCliente mapADtoCliente(Cliente cliente){
        return new DtoCliente(
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getTelefono(),
                cliente.getMail(),
                cliente.getDireccion(),
                cliente.getPassword()
        );
    }

    public  static Cliente mapACliente(DtoCliente dtoCliente){
        return new Cliente(
                dtoCliente.getCedula(),
                dtoCliente.getNombre(),
                dtoCliente.getTelefono(),
                dtoCliente.getMail(),
                dtoCliente.getDireccion(),
                dtoCliente.getPassword()
        );
    }
}
