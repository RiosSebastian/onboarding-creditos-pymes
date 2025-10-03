package com.prestamosShort.entity;

import com.prestamosShort.enumm.Resultado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kyc")
public class KycRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String proveedor;
    private String respuestaRaw;
    private LocalTime fechaVerificacion;
    private Resultado resultado;
}
