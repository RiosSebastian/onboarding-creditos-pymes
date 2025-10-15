package com.prestamosShort.mapper;

import com.prestamosShort.dto.UsuarioDtoRes;
import com.prestamosShort.dto.dtoReq.UsuarioDtoReq;
import com.prestamosShort.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioDtoRes toDto(Usuario usuario){
        return UsuarioDtoRes.builder()
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .fechaRegistro(usuario.getFechaRegistro())
                .passWord(usuario.getPassWord())
                .build();
    }

    public Usuario toUsuario(UsuarioDtoReq request){
        return Usuario.builder()
                .nombre(request.nombre())
                .email(request.email())
                .fechaRegistro(request.fechaRegistro())
                .build();
    }

}
