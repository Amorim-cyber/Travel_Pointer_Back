package com.app.travelPointer.service;

import com.app.travelPointer.exceptions.BusinessException;
import com.app.travelPointer.exceptions.NotFoundException;
import com.app.travelPointer.mapper.UsuarioMapper;
import com.app.travelPointer.model.Usuario;
import com.app.travelPointer.model.dto.UsuarioDTO;
import com.app.travelPointer.repository.UsuarioRepository;
import com.app.travelPointer.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO save(UsuarioDTO dto){

        Optional<Usuario> optionalUsuarioByLogin = usuarioRepository.findByLogin(dto.getLogin());
        if(optionalUsuarioByLogin.isPresent()){
            throw new BusinessException(MessageUtils.USER_ALREADY_EXISTS);
        }

        Optional<Usuario> optionalUsuarioBySenha = usuarioRepository.findBySenha(dto.getSenha());
        if(optionalUsuarioBySenha.isPresent()){
            throw new BusinessException(MessageUtils.USER_ALREADY_EXISTS);
        }

        Usuario usuario = usuarioMapper.toEntity(dto);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Transactional
    public List<UsuarioDTO> save(List<UsuarioDTO> listDto){

        listDto.stream().forEach(x->save(x));

        return listDto;

    }

    @Transactional
    public UsuarioDTO update(UsuarioDTO dto){

        Optional<Usuario> optionalUsuario = usuarioRepository.findByUsuarioUpdate(dto.getCdUsuario(), dto.getLogin(), dto.getSenha());

        if(optionalUsuario.isPresent()){
            throw new BusinessException(MessageUtils.NO_RECORDS_FOUND);
        }

        Usuario usuario = usuarioMapper.toEntity(dto);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);

    }

    @Transactional
    public UsuarioDTO delete(Long cdUsuario) {
        UsuarioDTO dto = this.findById(cdUsuario);

        usuarioRepository.deleteById(dto.getCdUsuario());
        return dto;
    }

    @Transactional
    public List<UsuarioDTO> deleteAll(List<UsuarioDTO> listDto) {
        listDto.stream().forEach(x->delete(x.getCdUsuario()));
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return usuarioMapper.toDto(usuarioRepository.findAll());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long cdUsuario){
        return usuarioRepository.findById(cdUsuario).map(usuarioMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByLoginAndSenha(String login,String senha){
        return usuarioRepository.findByLoginAndSenha(login,senha).map(usuarioMapper::toDto).orElseThrow(NotFoundException::new);
    }

}
