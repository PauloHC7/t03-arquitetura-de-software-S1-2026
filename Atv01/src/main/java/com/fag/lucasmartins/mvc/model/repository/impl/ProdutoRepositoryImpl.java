package com.fag.lucasmartins.mvc.model.repository.impl;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.ProdutoRepository;
import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.mvc.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.mvc.model.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @SuppressWarnings("null")
    @Override
    public ProdutoBO salvar(ProdutoBO produtoBO) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(produtoBO);
        
        ProdutoEntity savedEntity = jpaRepository.save(entity);
        
        return ProdutoEntityMapper.toBo(savedEntity);
    }
}