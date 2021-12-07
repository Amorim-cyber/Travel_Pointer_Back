package com.app.travelPointer.mapper;

import com.app.travelPointer.model.Usuario;
import com.app.travelPointer.model.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCdUsuario(dto.getCdUsuario());
        usuario.setNmUsuario(dto.getNmUsuario());
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCdUsuario(usuario.getCdUsuario());
        dto.setNmUsuario(usuario.getNmUsuario());
        dto.setLogin(usuario.getLogin());
        dto.setSenha(usuario.getSenha());
        return dto;
    }

    public List<UsuarioDTO> toDto(List<Usuario> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
