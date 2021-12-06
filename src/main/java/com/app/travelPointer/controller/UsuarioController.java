package com.app.travelPointer.controller;

import com.app.travelPointer.model.dto.UsuarioDTO;
import com.app.travelPointer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(usuarioService.save(dto));
    }

    @PostMapping(value = "/createAll",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> save(@Valid @RequestBody List<UsuarioDTO> list){
        return ResponseEntity.ok(usuarioService.save(list));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(usuarioService.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> findAll(){

        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));

    }

    @GetMapping(value = "/{login}/{senha}", produces = MediaType.APPLICATION_JSON_VALUE )
    public  ResponseEntity<UsuarioDTO> findByLoginAndSenha(@PathVariable String login, @PathVariable String senha){
        return ResponseEntity.ok(usuarioService.findByLoginAndSenha(login,senha));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.delete(id));
    }

    @DeleteMapping(value = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> deleteAll(@RequestBody List<UsuarioDTO> list){
        return ResponseEntity.ok(usuarioService.deleteAll(list));
    }
}
