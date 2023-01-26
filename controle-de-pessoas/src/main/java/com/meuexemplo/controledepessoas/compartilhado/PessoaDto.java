package com.meuexemplo.controledepessoas.compartilhado;

import java.util.List;

public class PessoaDto {
    
    //#region
    private Integer id;
    private String nome;
    private String sobrenome;
    private List<AnimalDTO> animais;
    //#endregion

    //#region
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public List<AnimalDTO> getAnimais() {
        return animais;
    }
    public void setAnimais(List<AnimalDTO> animais) {
        this.animais = animais;
    }
    
    //#endregion
    

}
