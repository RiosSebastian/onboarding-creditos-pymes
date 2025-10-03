package com.prestamosShort.dto.dtoReq;

import com.prestamosShort.enumm.Estado;

import java.time.LocalDate;

public record DocumentosDtoReq(String tipo,
                               String urlStorage,
                               LocalDate fechaSubida,
                               Estado estado) {
}
