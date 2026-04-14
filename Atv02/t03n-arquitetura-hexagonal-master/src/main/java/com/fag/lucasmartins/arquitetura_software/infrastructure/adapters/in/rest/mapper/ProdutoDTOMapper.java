package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.ProdutoDTO;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper() {
    }

    public static ProdutoBO toBo(ProdutoDTO dto) {
        return new ProdutoBO(
            dto.getNome(),
            dto.getEstoque(),
            dto.getPreco()
        );
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        final ProdutoDTO dto = new ProdutoDTO();
        dto.setNome(bo.getNome());
        dto.setPreco(bo.getPreco());
        dto.setEstoque(bo.getEstoque());

        return dto;
    }

}
