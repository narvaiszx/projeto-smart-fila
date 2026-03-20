package com.senai.smartfila.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.smartfila.entities.Documentos;
import com.senai.smartfila.repositories.DocumentosRepository;

@Service
public class DocumentosService {
	
	@Autowired
	private DocumentosRepository repository;
	
	public List<Documentos> listarTodos(){
		return repository.findAll();
	}
	
	public Optional<Documentos> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Documentos salvar (Documentos documentos) {
		return repository.save(documentos);
	}
	
	public Documentos atualizar(Long id, Documentos documentosAlterados) {
		Optional<Documentos> documentosExistentes = buscarPorId(id);
		
		if(documentosExistentes.isPresent()) {
			
			Documentos atualizado = documentosExistentes.get();
			
			atualizado.setCpf(documentosAlterados.getCpf());
			atualizado.setRg(documentosAlterados.getRg());
			atualizado.setAluno(documentosAlterados.getAluno());
			
			return repository.save(atualizado);
		}
		return null;
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}
