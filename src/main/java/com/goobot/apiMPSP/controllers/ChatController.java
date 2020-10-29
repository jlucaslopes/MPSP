package com.goobot.apiMPSP.controllers;

import com.goobot.apiMPSP.model.Chat;
import com.goobot.apiMPSP.repository.ChatRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Chat")
public class ChatController {

    @Autowired
    ChatRepository repo;

    @GetMapping()
    @ApiOperation(value = "Retorna lista de conversas")
    public ResponseEntity<List<Chat>> findAll() {
        List<Chat> all = repo.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um chamados")
    public ResponseEntity<Optional<Chat>> findById(@PathVariable("id") long id) {
        Optional<Chat> chat = repo.findById(id);

        return ResponseEntity.ok(chat);
    }

    @PostMapping()
    @ApiOperation(value = "Adiciona um novo chat")
    public ResponseEntity save(@RequestBody Chat chat){
        repo.save(chat);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(chat.getId()).toUri();

        return ResponseEntity.created(location).build();
    }



    }
