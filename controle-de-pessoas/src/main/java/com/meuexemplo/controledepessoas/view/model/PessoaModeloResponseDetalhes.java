package com.meuexemplo.controledepessoas.view.model;

import com.meuexemplo.controledepessoas.compartilhado.AnimalDTO;
import java.util.List;

public class PessoaModeloResponseDetalhes extends PessoaModeloResponse {

    private List<AnimalDTO> animais;

    public List<AnimalDTO> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDTO> animais) {
        this.animais = animais;
    }

    
    
}
