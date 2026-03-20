package com.senai.smartfila.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.smartfila.entities.Turma;
import com.senai.smartfila.services.TurmaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turmas")
@CrossOrigin("*")
public class TurmaController {

	@Autowired
	private TurmaService service;

	@GetMapping
	public ResponseEntity<List<Turma>> listar() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscar(@PathVariable Long id) {
		Optional<Turma> turma = service.buscarPorId(id);

		if (turma != null) {
			return ResponseEntity.ok(turma.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public Turma criar(@Valid @RequestBody Turma turma) {
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
