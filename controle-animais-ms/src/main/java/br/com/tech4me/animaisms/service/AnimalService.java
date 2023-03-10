package br.com.tech4me.animaisms.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.animaisms.compartilhado.AnimalDto;

public interface AnimalService {
    AnimalDto criarAnimal(AnimalDto animal);
    List<AnimalDto> obterTodos();
    Optional<AnimalDto> obterPorId(Integer id);
    List<AnimalDto> obterPorDono(Integer dono);
    void removerAnimal(Integer id);
    boolean definirComoMorto(Integer id);
    AnimalDto atualizarAnimal(Integer id, AnimalDto animal);
}
