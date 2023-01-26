package com.meuexemplo.controledepessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.meuexemplo.controledepessoas.model.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{
    
}
