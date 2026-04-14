package com.fag.lucasmartins.mvc.model.repository.mapper;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;

public class ProdutoEntityMapper {

    private ProdutoEntityMapper() {}

    public static ProdutoEntity toEntity(ProdutoBO bo) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(bo.getId());
        entity.setNome(bo.getNome());
        entity.setPrecoBase(bo.getPrecoBase());
        entity.setQuantidade(bo.getQuantidade());
        entity.setPremium(bo.isPremium());
        return entity;
    }

    public static ProdutoBO toBo(ProdutoEntity entity) {
        return new ProdutoBO(
                entity.getId(),
                entity.getNome(),
                entity.getPrecoBase(),
                entity.getQuantidade(),
                entity.getPremium()
        );
    }
}