package com.prestamosShort.dto;

import com.prestamosShort.enumm.EstadoSolicitud;
import lombok.Builder;

import java.time.LocalTime;

@Builder
public record SolicitudCreditoDtoRes( Integer montoSolicitado,
                                     String proposito,
                                     EstadoSolicitud estadoSolicitud,
                                     LocalTime fechaCreacion,
                                     LocalTime fechaActualizacion) {
}
