package com.prestamosShort.dto;

import com.prestamosShort.enumm.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DocumentosDtoRes(   @NotBlank String tipo,
                                 @NotNull String urlStorage,
                                  @NotNull LocalDate fechaSubida,
                                  @NotBlank Estado estado) {
}
