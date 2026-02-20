package com.senai.smartfila.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.smartfila.entities.Turma;
import com.senai.smartfila.services.TurmaService;

@RestController
@RequestMapping("/turmas")
@CrossOrigin("*")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping
    public List<Turma> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Turma buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Turma criar(@RequestBody Turma turma) {
        return service.salvar(turma);
    }

    @PutMapping("/{id}")
    public Turma atualizar(@PathVariable Long id, @RequestBody Turma turma) {
        return service.atualizar(id, turma);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
