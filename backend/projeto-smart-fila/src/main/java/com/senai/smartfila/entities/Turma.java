package com.senai.smartfila.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_turma")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "nome_turma")
	private String nome;
	
	@Pattern(
			regexp="^[A-Z]{2,5}\\d{1}[A-Z]?-//d{4}-[12]$",
			message="Código da turma deve seguir o seguinte padrão: DEV1D-2025-2.")
	@NotBlank(message = "O código da turma é obrigatório")
	@Size(min=2, max=5, message="O código da tura deve ter entre 2 e 5 digitos")
	private String codigoTurma;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnore
	private List<Aluno> alunos;
	
	public Turma() {}
	
	public Turma(String nome, List<Aluno> alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
