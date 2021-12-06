package com.app.travelPointer.mapper;

import com.app.travelPointer.model.Usuario;
import com.app.travelPointer.model.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

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
        dto.setCdUsuario(dto.getCdUsuario());
        dto.setNmUsuario(dto.getNmUsuario());
        dto.setLogin(dto.getLogin());
        dto.setSenha(dto.getSenha());
        return dto;
    }

    public List<UsuarioDTO> toDto(List<Usuario> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
