package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {
    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.id = (id != null) ? id : UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        
        validarCpf(cpf);
        validarMaioridade(dataNascimento);
        validarEmail(email);
        validarTelefone(telefone);
        
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    private void validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new DomainException("O CPF é obrigatório e deve conter exatamente 11 caracteres.");
        }
    }

    private void validarMaioridade(LocalDate dataNascimento) {
        if (dataNascimento == null || Period.between(dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new DomainException("O cliente deve ter no mínimo 18 anos para ser cadastrado.");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new DomainException("O e-mail informado é inválido. Formato exigido: deve conter '@'.");
        }
    }
    
    private void validarTelefone(String telefone) {
        if (telefone == null || telefone.length() != 11) {
            throw new DomainException("O telefone deve possuir exatamente 11 caracteres (sem parênteses ou traços).");
        }
    }

    public UUID getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
}