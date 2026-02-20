package com.senai.smartfila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.smartfila.entities.Documentos;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Long>{

}
