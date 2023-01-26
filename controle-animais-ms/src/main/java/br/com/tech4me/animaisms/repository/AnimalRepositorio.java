package br.com.tech4me.animaisms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.animaisms.model.Animal;

@Repository
// public interface AnimalRepositorio extends MongoRepository<Animal, Integer> {
public interface AnimalRepositorio extends JpaRepository<Animal, Integer>{

	List<Animal> findByDono(Integer dono);
    
}
