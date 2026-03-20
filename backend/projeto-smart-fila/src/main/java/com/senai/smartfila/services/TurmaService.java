package com.senai.smartfila.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.smartfila.entities.Turma;
import com.senai.smartfila.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public List<Turma> listarTodos(){
		return repository.findAll();
	}
	
	public Optional<Turma> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Turma salvar (Turma turma) {
		return repository.save(turma);
	}
	
	public Turma atualizar(Long id, Turma turmaAlterada) {
		Optional<Turma> turmaExistente = buscarPorId(id);
		
		if (turmaExistente.isPresent()) {
			
			Turma atualizado = turmaExistente.get();
			
			atualizado.setNome(turmaAlterada.getNome());
			atualizado.setAlunos(turmaAlterada.getAlunos());
			
			return repository.save(atualizado);
		}
		return null;
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
