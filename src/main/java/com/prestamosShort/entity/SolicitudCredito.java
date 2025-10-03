package com.prestamosShort.entity;


import com.prestamosShort.enumm.EstadoSolicitud;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "solicitud_credito")
public class SolicitudCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer montoSolicitado;
    private String proposito;
    private EstadoSolicitud estadoSolicitud;
    private LocalTime fechaCreacion;
    private LocalTime fechaActualizacion;
}
