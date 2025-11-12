package com.prestamosShort.servis.servisImpl;

import com.prestamosShort.dto.UsuarioDtoRes;
import com.prestamosShort.dto.dtoReq.UsuarioDtoReq;
import com.prestamosShort.entity.Usuario;
import com.prestamosShort.enumm.Rol;
import com.prestamosShort.mapper.UsuarioMapper;
import com.prestamosShort.repository.UsuarioRepository;
import com.prestamosShort.servis.UsuarioServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServisImpl implements UsuarioServis {

    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDtoRes createUser(UsuarioDtoReq userDTOReq) {
        Usuario usuario = usuarioMapper.toUsuario(userDTOReq);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDtoRes getUserById(Long id) throws ChangeSetPersister.NotFoundException {

        return usuarioMapper.toDto(usuarioRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException()));
    }

    @Override
    public UsuarioDtoRes updateUser(Long id, UsuarioDtoReq userDTOReq) throws ChangeSetPersister.NotFoundException {
        Usuario existingUser = usuarioRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        existingUser.setNombre(userDTOReq.nombre());
        existingUser.setPassWord(userDTOReq.passWord());
        existingUser.setEmail(userDTOReq.email());

        existingUser = usuarioRepository.save(existingUser);
        return usuarioMapper.toDto(existingUser);
    }

    @Override
    public void deleteUser(Long id) throws ChangeSetPersister.NotFoundException {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        usuarioRepository.delete(user);

    }

    @Override
    public List<UsuarioDtoRes> getAllUsers() {
        List<Usuario> users = usuarioRepository.findAll();
        return users.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDtoRes updateProfileImage(Long id, String imageUrl) throws ChangeSetPersister.NotFoundException {

        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        //user.setProfileImage(imageUrl);
        usuarioRepository.save(user);
        return usuarioMapper.toDto(user);

    }
}
