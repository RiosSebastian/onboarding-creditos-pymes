package com.prestamosShort.servis;

import com.prestamosShort.dto.UsuarioDtoRes;
import com.prestamosShort.dto.dtoReq.UsuarioDtoReq;

import java.util.List;

public interface UsuarioServis {

    UsuarioDtoRes createUser(UsuarioDtoReq userDTOReq);

    // Firma del método para obtener un usuario por su ID
    UsuarioDtoRes getUserById(Long id);

    // Firma del método para actualizar un usuario
    UsuarioDtoRes updateUser(Long id, UsuarioDtoReq userDTOReq);

    // Firma del método para eliminar un usuario por su ID
    void deleteUser(Long id);

    // Firma del método para obtener todos los usuarios
    List<UsuarioDtoRes> getAllUsers();

    UsuarioDtoRes updateProfileImage(Long id, String imageUrl);
}
