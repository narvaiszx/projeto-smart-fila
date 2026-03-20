package com.senai.smartfila.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.smartfila.validations.annotations.TelefoneBR;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(
    		regexp="^[\\p{L}]+( [\\p{L]]+)*$",
    		message = "O nome do aluno deve conter apenas letras e espaços.")
    @NotBlank(message ="O nome é obrigatório.")
    private String nome;

    @Pattern(regexp="^RA-\\d{4}-\\d{4}$",
    		message = "O RA deve conter apenas letras, números e hífen.")
    @Column(unique = true, nullable = false, length = 20)
    @Size (min = 5, max = 20, message = "O RA deve ter entre 5 e 20 caracteres")
    @NotBlank
    private String ra;
    
    @Email(message = "E-mail inválido.")
    @Size(max = 120, message = "E-mail deve ter no máximo 120 caracteres.")
    @Column(unique = true, length = 120)
    private String email;
    
    @TelefoneBR(message="Telefone deve estar no padrão brasileiro.")
    @Column(length = 20, unique = true)
    @NotBlank(message="O telefone é obrigatório.")
    private String telefone;
    
    @ManyToOne
    @JoinColumn(name = "fk_turma")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Turma turma;
    
    @OneToOne
    @JoinColumn(name = "fk_documentos")
    @JsonManagedReference
    private Documentos documentos;
    
    public Aluno() {}
    public Aluno(String nome, String ra, Turma turma, Documentos documentos) {
    	this.nome = nome;
    	this.ra = ra;
    	this.turma = turma;
    	this.documentos = documentos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }
    public Documentos getDocumentos() {return documentos;}
    public void setDocumentos(Documentos documentos) {this.documentos = documentos;}
}