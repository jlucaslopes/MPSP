package com.goobot.apiMPSP.controllers;

import com.goobot.apiMPSP.model.Parametrizacao;
import com.goobot.apiMPSP.repository.ParametrizacaoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Param")
public class ParametrizacaoController {

    @Autowired
    ParametrizacaoRepository repo;

    @GetMapping()
    @ApiOperation(value = "Retorna lista de parametros")
    public ResponseEntity<List<Parametrizacao>> findAll() {
        List<Parametrizacao> all = repo.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{chave}")
    @ApiOperation(value = "Retorna uma Parametrizacao")
    public ResponseEntity<Optional<Parametrizacao>> findById(@PathVariable("chave") String chave) {
        Optional<Parametrizacao> param = Optional.ofNullable(repo.findByKey(chave));

        return ResponseEntity.ok(param);
    }

    @PostMapping()
    @ApiOperation(value = "Adiciona um novo parametro")
    public ResponseEntity save(@RequestBody Parametrizacao param){
        repo.save(param);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(param.getChave()).toUri();

        return ResponseEntity.created(location).build();
    }



    }
