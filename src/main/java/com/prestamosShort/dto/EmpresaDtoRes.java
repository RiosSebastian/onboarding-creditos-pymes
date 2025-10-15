package com.prestamosShort.dto;

import lombok.Builder;

@Builder
public record EmpresaDtoRes( String nombre,
                             String razonSocial,
                             String email,
                             String cuit,
                             String direccion,
                             String telefono) {
}
