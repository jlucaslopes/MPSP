package com.goobot.apiMPSP.controllers;

import com.goobot.apiMPSP.model.Chamado;
import com.goobot.apiMPSP.repository.ChamadoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Chamado")
public class ChamadoController {

    @Autowired
    ChamadoRepository repo;

    @GetMapping()
    @ApiOperation(value = "Retorna lista de chamados")
    public ResponseEntity<List<Chamado>> findAll() {
        List<Chamado> all = repo.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um chamados")
    public ResponseEntity<Optional<Chamado>> findById(@PathVariable("id") long id) {
        Optional<Chamado> chamado = repo.findById(id);

        return ResponseEntity.ok(chamado);
    }

    @PostMapping()
    @ApiOperation(value = "Adiciona um novo chamado")
    public ResponseEntity save(@RequestBody Chamado chamado){
        repo.save(chamado);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(chamado.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um chamado a partir do identificador")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Chamado chamado) {

        chamado.setId(id);
        repo.save(chamado);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um chamado a partir do identificador")
    public ResponseEntity deleteById(@PathVariable("id") long id) {

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    }
