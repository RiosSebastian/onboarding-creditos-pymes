package com.prestamosShort.dto.dtoReq;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public record UsuarioDtoReq(@NotBlank String nombre,
                            @Email @NotBlank String email,
                            @NotNull LocalDate fechaRegistro) {
}
