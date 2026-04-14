package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entities.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository.PessoaJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository jpaRepository;

    public PessoaRepositoryAdapter(PessoaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        PessoaEntity entity = new PessoaEntity();
        entity.setId(pessoaBO.getId());
        entity.setNomeCompleto(pessoaBO.getNomeCompleto());
        entity.setCpf(pessoaBO.getCpf());
        entity.setDataNascimento(pessoaBO.getDataNascimento());
        entity.setEmail(pessoaBO.getEmail());
        entity.setTelefone(pessoaBO.getTelefone());

        PessoaEntity savedEntity = jpaRepository.save(entity);

        return new PessoaBO(
                savedEntity.getId(),
                savedEntity.getNomeCompleto(),
                savedEntity.getCpf(),
                savedEntity.getDataNascimento(),
                savedEntity.getEmail(),
                savedEntity.getTelefone()
        );
    }
}