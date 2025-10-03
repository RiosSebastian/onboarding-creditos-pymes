package com.prestamosShort.dto.dtoReq;

import java.time.LocalDate;

public record UsuarioDtoReq(String nombre,
                            String email,
                            String passWord,
                            LocalDate fechaRegistro) {
}
