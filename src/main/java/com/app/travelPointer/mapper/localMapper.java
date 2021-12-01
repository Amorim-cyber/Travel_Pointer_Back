package com.app.travelPointer.mapper;

import com.app.travelPointer.model.Local;
import com.app.travelPointer.model.dto.LocalDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class localMapper {

    public Local toEntity(LocalDTO dto) {
        Local local = new Local();
        local.setEndereco(dto.getEndereco());
        local.setId(dto.getId());
        local.setIdUsuario(dto.getIdUsuario());
        local.setLatitude(dto.getLatitude());
        local.setLongitude(dto.getLongitude());
        local.setNome(dto.getNome());
        local.setTipo(dto.getTipo());
        return local;
    }

    public LocalDTO toDto(Local local) {
        LocalDTO dto = new LocalDTO();
        dto.setEndereco(local.getEndereco());
        dto.setId(local.getId());
        dto.setIdUsuario(local.getIdUsuario());
        dto.setLatitude(local.getLatitude());
        dto.setLongitude(local.getLongitude());
        dto.setNome(local.getNome());
        dto.setTipo(local.getTipo());
        return dto;
    }

    public List<LocalDTO> toDto(List<Local> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
