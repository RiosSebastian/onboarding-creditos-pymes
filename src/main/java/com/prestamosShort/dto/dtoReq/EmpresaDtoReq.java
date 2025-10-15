package com.prestamosShort.dto.dtoReq;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpresaDtoReq( @NotNull String razonSocial,
                             @NotBlank String nombre,
                            @NotBlank String cuit,
                             @NotBlank String email,
                            @NotBlank String direccion,
                            @NotNull String telefono) {
}
