package com.fag.lucasmartins.mvc.controller.mapper;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper() {}

    public static ProdutoBO toBo(ProdutoDTO dto) {
        return new ProdutoBO(
                dto.getId(),
                dto.getNome(),
                dto.getPrecoBase(),
                dto.getQuantidade(),
                dto.getPremium() != null ? dto.getPremium() : false
        );
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        return new ProdutoDTO(
                bo.getId(),
                bo.getNome(),
                bo.getPrecoBase(),
                bo.getQuantidade(),
                bo.isPremium()
        );
    }
}