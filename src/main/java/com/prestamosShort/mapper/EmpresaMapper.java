package com.prestamosShort.mapper;

import com.prestamosShort.dto.EmpresaDtoRes;
import com.prestamosShort.dto.dtoReq.EmpresaDtoReq;
import com.prestamosShort.entity.Empresa;

public class EmpresaMapper {
    public EmpresaDtoRes toDto(Empresa empresa){
        return EmpresaDtoRes.builder()
                .cuit(empresa.getCuit())
                .direccion(empresa.getDireccion())
                .razonSocial(empresa.getRazonSocial())
                .telefono(empresa.getTelefono())
                .build();
    }

    public Empresa toEmpresa(EmpresaDtoReq empresaDtoReq){
        return Empresa.builder()
                .cuit(empresaDtoReq.cuit())
                .direccion(empresaDtoReq.direccion())
                .telefono(empresaDtoReq.telefono())
                .razonSocial(empresaDtoReq.razonSocial())
                .build();
    }
}
