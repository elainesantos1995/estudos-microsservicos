package com.meuexemplo.controledepessoas.service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuexemplo.controledepessoas.compartilhado.AnimalDTO;
import com.meuexemplo.controledepessoas.compartilhado.PessoaDto;
import com.meuexemplo.controledepessoas.http.AnimaisFeignClient;
import com.meuexemplo.controledepessoas.model.Pessoa;
import com.meuexemplo.controledepessoas.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository repo;

    @Autowired
    private AnimaisFeignClient animaisMsClient;

    @Override
    public PessoaDto criarPessoa(PessoaDto pessoa) {
        return salvarPessoa(pessoa);
    }

    @Override
    public List<PessoaDto> obterTodos() {
        List<Pessoa> pessoas = repo.findAll();

        return pessoas.stream()
            .map(pessoa -> new ModelMapper().map(pessoa, PessoaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<PessoaDto> obterPorId(Integer id) {
        Optional<Pessoa> pessoa = repo.findById(id);
        PessoaDto dto = new ModelMapper().map(pessoa.get(), PessoaDto.class);

       if(pessoa.isPresent()) {

            // aqui retornamos os animais da pessoa
            List<AnimalDTO> animais = animaisMsClient.obterAnimais(id);
            // aqui adicionamosa lista de animais da pessoa vinda do ms de animais
            dto.setAnimais(animais);

            return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerPessoa(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public PessoaDto atualizarPessoa(Integer id, PessoaDto pessoa) {
        pessoa.setId(id);
        return salvarPessoa(pessoa);
    }

    private PessoaDto salvarPessoa(PessoaDto pessoa) {
        ModelMapper mapper = new ModelMapper();
        Pessoa pessoaEntidade = mapper.map(pessoa, Pessoa.class);
        pessoaEntidade = repo.save(pessoaEntidade);

        System.out.println(pessoaEntidade.toString() + "====================");

        return mapper.map(pessoaEntidade, PessoaDto.class);
    }
    
    
}
