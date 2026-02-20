package com.senai.smartfila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.smartfila.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository <Turma, Long> {

}
