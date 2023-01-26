package com.meuexemplo.controledepessoas.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.meuexemplo.controledepessoas.compartilhado.AnimalDTO;

@FeignClient(name = "controle-animais-ms")
public interface AnimaisFeignClient {
    
    @GetMapping(path = "/api/animais/{dono}/lista")
    List<AnimalDTO> obterAnimais(@PathVariable Integer dono);
}
