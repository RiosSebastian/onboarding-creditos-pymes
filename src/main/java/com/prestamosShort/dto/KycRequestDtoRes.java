package com.prestamosShort.dto;

import com.prestamosShort.enumm.Resultado;
import lombok.Builder;

import java.time.LocalTime;

@Builder
public record KycRequestDtoRes(
         String proveedor,
         String respuestaRaw,
         LocalTime fechaVerificacion,
         Resultado resultado
) {
}
