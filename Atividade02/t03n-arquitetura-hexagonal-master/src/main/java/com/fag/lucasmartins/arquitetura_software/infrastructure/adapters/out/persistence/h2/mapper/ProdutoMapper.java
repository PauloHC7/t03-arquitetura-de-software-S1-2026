package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;

public class ProdutoMapper {

    private ProdutoMapper() {
    }

    public static ProdutoEntity toEntity(ProdutoBO produtoBO) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoBO.getNome());
        produtoEntity.setEstoque(produtoBO.getEstoque());
        produtoEntity.setPreco(produtoBO.getPreco());
        produtoEntity.setPrecoFinal(produtoBO.getPrecoFinal());
        return produtoEntity;
    }

    public static ProdutoBO toBo(ProdutoEntity produtoEntity) {
        return new ProdutoBO(
            produtoEntity.getNome(),
            produtoEntity.getEstoque(),
            produtoEntity.getPreco()
        );
    }
}