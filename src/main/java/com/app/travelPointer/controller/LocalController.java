package com.app.travelPointer.controller;

import com.app.travelPointer.model.dto.LocalDTO;
import com.app.travelPointer.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalDTO> save(@Valid @RequestBody LocalDTO dto){
        return ResponseEntity.ok(localService.save(dto));
    }

    @PostMapping(value = "/createAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalDTO>> save(@Valid @RequestBody List<LocalDTO> list){
        return ResponseEntity.ok(localService.save(list));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalDTO> update(@RequestBody LocalDTO dto){
        return ResponseEntity.ok(localService.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalDTO>> findAll(){

        return ResponseEntity.ok(localService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<LocalDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(localService.findById(id));

    }

    @GetMapping(value = "/search/{clientCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalDTO>> findByClientCode(@PathVariable Long clientCode){
        return ResponseEntity.ok(localService.findByCdUsuario(clientCode));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(localService.delete(id));
    }

    @DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalDTO>> deleteAll(@RequestBody List<LocalDTO> list){
        return ResponseEntity.ok(localService.deleteAll(list));
    }

}
