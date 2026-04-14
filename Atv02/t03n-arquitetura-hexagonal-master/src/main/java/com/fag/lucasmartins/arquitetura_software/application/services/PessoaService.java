package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;

@Service
public class PessoaService {

    private final PessoaRepositoryPort pessoaRepositoryPort;


    public PessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
    }

    public PessoaBO cadastrarPessoa(PessoaBO pessoaBO) {
    
        return pessoaRepositoryPort.salvar(pessoaBO);
    }
}