package com.meuexemplo.controledepessoas.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.meuexemplo.controledepessoas.compartilhado.PessoaDto;
import com.meuexemplo.controledepessoas.model.Pessoa;
import com.meuexemplo.controledepessoas.service.PessoaService;
import com.meuexemplo.controledepessoas.view.model.PessoaModeloRequest;
import com.meuexemplo.controledepessoas.view.model.PessoaModeloResponse;
import com.meuexemplo.controledepessoas.view.model.PessoaModeloResponseDetalhes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<PessoaModeloResponse> criarPessoa(@RequestBody @Valid PessoaModeloRequest pessoa) {
        ModelMapper mapper = new ModelMapper();
        PessoaDto dto = mapper.map(pessoa, PessoaDto.class);
        dto = service.criarPessoa(dto);
        return new ResponseEntity<>(mapper.map(dto, PessoaModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<PessoaModeloResponse>> obterTodos() {
        List<PessoaDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<PessoaModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, PessoaModeloResponse.class))
                    .collect(Collectors.toList());

        for (PessoaModeloResponse pessoaModeloResponse : resp) {
            System.out.println(mapper.map(pessoaModeloResponse, Pessoa.class));
        }

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    
    @GetMapping(value="/{id}")
    public ResponseEntity<PessoaModeloResponseDetalhes> obterPorId(@PathVariable Integer id) {
        Optional<PessoaDto> pessoa = service.obterPorId(id);

        if(pessoa.isPresent()) {

            return new ResponseEntity<>(
                new ModelMapper().map(pessoa.get(), PessoaModeloResponseDetalhes.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<PessoaModeloResponse> atualizarPessoa(@PathVariable Integer id,
        @Valid @RequestBody PessoaModeloRequest pessoa) {
        ModelMapper mapper = new ModelMapper();
        PessoaDto dto = mapper.map(pessoa, PessoaDto.class);
        dto = service.atualizarPessoa(id, dto);

        return new ResponseEntity<>(mapper.map(dto, PessoaModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerPessoa(@PathVariable Integer id) {
        service.removerPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping
    // public List<Pessoa> obterTodos(){

    //     Pessoa pessoa1 = new Pessoa();
    //     pessoa1.setNome("João");
    //     pessoa1.setEmail("joao@gmail.com");
    //     pessoa1.setTelefone("(83)99816-3915");

    //     Pessoa pessoa2 = new Pessoa();
    //     pessoa2.setNome("Maria");
    //     pessoa2.setEmail("maria@gmail.com");
    //     pessoa2.setTelefone("(83)99816-3915");

    //     List<Pessoa> pessoas = new ArrayList<Pessoa>();
    //     pessoas.add(pessoa1);
    //     pessoas.add(pessoa2);

    //     return pessoas;
    // }
    
}
