package com.prestamosShort.dto.dtoReq;

import com.prestamosShort.enumm.Resultado;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public record KycRequestDtoReq(@NotBlank String proveedor,
                               @NotBlank String respuestaRaw,
                               @NotBlank LocalTime fechaVerificacion,
                               @NotBlank  Resultado resultado) {
}
