package com.goobot.apiMPSP.controllers;

import com.goobot.apiMPSP.model.Usuario;
import com.goobot.apiMPSP.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UsuarioController {

    @Autowired
    UsuarioRepository repo;

    @GetMapping()
    @ApiOperation(value = "Retorna lista de usuarios")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> all = repo.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") Long id) {
        Optional<Usuario> param = repo.findById(id);

        return ResponseEntity.ok(param);
    }

    @PostMapping()
    @ApiOperation(value = "Adiciona um novo usuario")
    public ResponseEntity save(@RequestBody Usuario user){
        repo.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getCpf()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atuliza um usuario")
    public ResponseEntity update(@RequestBody Usuario user) {
        repo.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um usuario a partir do identificador")
    public ResponseEntity deleteById(@PathVariable("id") long id) {

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    }
