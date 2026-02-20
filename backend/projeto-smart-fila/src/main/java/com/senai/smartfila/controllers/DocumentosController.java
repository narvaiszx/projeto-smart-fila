package com.senai.smartfila.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.smartfila.entities.Documentos;
import com.senai.smartfila.services.DocumentosService;

@RestController
@RequestMapping("/documentos")
@CrossOrigin("*")
public class DocumentosController {

    @Autowired
    private DocumentosService service;

    @GetMapping
    public List<Documentos> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Documentos buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Documentos criar(@RequestBody Documentos documentos) {
        return service.salvar(documentos);
    }

    @PutMapping("/{id}")
    public Documentos atualizar(@PathVariable Long id, @RequestBody Documentos documentos) {
        return service.atualizar(id, documentos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}