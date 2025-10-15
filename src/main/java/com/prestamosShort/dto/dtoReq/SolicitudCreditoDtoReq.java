package com.prestamosShort.dto.dtoReq;

import com.prestamosShort.enumm.EstadoSolicitud;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public record SolicitudCreditoDtoReq(@NotBlank Integer montoSolicitado,
                                     @NotBlank String plazo,
                                     @NotBlank String proposito,
                                     @NotBlank EstadoSolicitud estadoSolicitud,
                                     @NotBlank LocalTime fechaCreacion,
                                     @NotBlank  LocalTime fechaActualizacion) {
}
