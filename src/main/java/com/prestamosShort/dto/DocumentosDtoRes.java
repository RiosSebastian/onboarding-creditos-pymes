package com.prestamosShort.dto;

import com.prestamosShort.enumm.Estado;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DocumentosDtoRes(  String tipo,
                                 String urlStorage,
                                 LocalDate fechaSubida,
                                 Estado estado) {
}
