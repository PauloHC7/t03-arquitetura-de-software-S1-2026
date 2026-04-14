package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, UUID> {
}