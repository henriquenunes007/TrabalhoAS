package com.victormorsil.daoc.domain.service;

import com.victormorsil.daoc.domain.model.Pessoa;
import com.victormorsil.daoc.domain.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa edit(Pessoa pessoa) {
        if (!pessoaRepository.existsById(pessoa.getId())) return null;
        return this.save(pessoa);
    }

    public boolean delete(Long id) {
        if (!pessoaRepository.existsById(id)) return false;
        pessoaRepository.deleteById(id);
        return true;
    }

}
