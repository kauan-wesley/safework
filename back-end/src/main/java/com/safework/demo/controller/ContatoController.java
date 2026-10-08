package com.safework.demo.controller;

import com.safework.demo.model.Contato;
import com.safework.demo.service.ContatoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin(origins = "*")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<Contato> criar(
            @RequestBody Contato contato) {

        Contato novoContato =
                contatoService.salvar(contato);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoContato);
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listar() {

        List<Contato> contatos =
                contatoService.listarTodos();

        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(
            @PathVariable Long id) {

        return contatoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(
            @PathVariable Long id,
            @RequestBody Contato dados) {

        return contatoService.atualizar(id, dados)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        boolean excluido =
                contatoService.excluir(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}