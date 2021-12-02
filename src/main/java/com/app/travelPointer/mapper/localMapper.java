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
        local.setEndLocal(dto.getEndLocal());
        local.setCdLocal(dto.getCdLocal());
        local.setCdUsuario(dto.getCdUsuario());
        local.setLatitude(dto.getLatitude());
        local.setLongitude(dto.getLongitude());
        local.setNmLocal(dto.getNmLocal());
        local.setTipo(dto.getTipo());
        return local;
    }

    public LocalDTO toDto(Local local) {
        LocalDTO dto = new LocalDTO();
        dto.setEndLocal(local.getEndLocal());
        dto.setCdLocal(local.getCdLocal());
        dto.setCdUsuario(local.getCdUsuario());
        dto.setLatitude(local.getLatitude());
        dto.setLongitude(local.getLongitude());
        dto.setNmLocal(local.getNmLocal());
        dto.setTipo(local.getTipo());
        return dto;
    }

    public List<LocalDTO> toDto(List<Local> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
