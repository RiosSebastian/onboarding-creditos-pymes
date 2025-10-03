package com.prestamosShort.dto;

import lombok.Builder;

@Builder
public record EmpresaDtoRes( String razonSocial,
                             String cuit,
                             String direccion,
                             String telefono) {
}
