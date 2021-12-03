package com.app.travelPointer.service;

import com.app.travelPointer.exceptions.BusinessException;
import com.app.travelPointer.exceptions.NotFoundException;
import com.app.travelPointer.mapper.LocalMapper;
import com.app.travelPointer.model.Local;
import com.app.travelPointer.model.dto.LocalDTO;
import com.app.travelPointer.repository.LocalRepository;
import com.app.travelPointer.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private LocalMapper localMapper;

    @Transactional
    public LocalDTO save(LocalDTO dto){

        Optional<Local> optionalLocal = localRepository.findByCdUsuarioAndEndLocal(dto.getCdUsuario(), dto.getEndLocal());
        if(optionalLocal.isPresent()){
            throw new BusinessException(MessageUtils.LOCAL_ALREADY_EXISTS);
        }
        Local local = localMapper.toEntity(dto);
        localRepository.save(local);
        return localMapper.toDto(local);
    }

    @Transactional
    public List<LocalDTO> save(List<LocalDTO> listDto){

        listDto.stream().forEach(x->save(x));

        return listDto;

    }

    @Transactional
    public LocalDTO update(LocalDTO dto){

        Optional<Local> optionalLocal = localRepository.findByLocalUpdate(dto.getCdUsuario(), dto.getEndLocal(), dto.getCdLocal());

        if(optionalLocal.isPresent()){
            throw new BusinessException(MessageUtils.NO_RECORDS_FOUND);
        }

        Local local = localMapper.toEntity(dto);
        localRepository.save(local);
        return localMapper.toDto(local);
    }

    @Transactional
    public LocalDTO delete(Long cdLocal) {
        LocalDTO dto = this.findById(cdLocal);

        localRepository.deleteById(dto.getCdLocal());
        return dto;
    }

    @Transactional
    public List<LocalDTO> deleteAll(List<LocalDTO> listDto) {
        listDto.stream().forEach(x->delete(x.getCdLocal()));
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<LocalDTO> findAll() {
        return localMapper.toDto(localRepository.findAll());
    }


    @Transactional(readOnly = true)
    public LocalDTO findById(Long cdLocal){
        return localRepository.findById(cdLocal).map(localMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<LocalDTO> findByCdUsuario(Long cdUsuario) {
        return  localRepository.findByCdUsuario(cdUsuario).map(localMapper::toDto).orElseThrow(NotFoundException::new);
    }

}
