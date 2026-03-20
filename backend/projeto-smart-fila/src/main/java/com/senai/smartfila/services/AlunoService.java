package com.senai.smartfila.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.smartfila.entities.Aluno;
import com.senai.smartfila.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;

	public List<Aluno> listarTodos() {
		return repository.findAll();
	}

	public Optional<Aluno> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public Aluno salvar(Aluno aluno) {
		return repository.save(aluno);
	}

	public Aluno atualizar(Long id, Aluno alunoAlterado) {
		Optional<Aluno> existente = buscarPorId(id);

		if (existente.isPresent()) {

			Aluno atualizado = existente.get();

			atualizado.setNome(alunoAlterado.getNome());
			atualizado.setTurma(alunoAlterado.getTurma());
			atualizado.setRa(alunoAlterado.getRa());

			if (alunoAlterado.getDocumentos() != null) {

				atualizado.setDocumentos(alunoAlterado.getDocumentos());
			}

			return repository.save(atualizado);
		}
		return null;

	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}