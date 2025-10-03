package com.prestamosShort.entity;

import com.prestamosShort.enumm.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documentos")
public class Documentos {
    private Long id;
    private String tipo;
    private String urlStorage;
    private LocalDate fechaSubida;
    private Estado estado;
}
