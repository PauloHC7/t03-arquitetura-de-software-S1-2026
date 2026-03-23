package com.fag.lucasmartins.mvc.model.service.impl;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.ProdutoRepository;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.ProdutoRepository;
import com.fag.lucasmartins.mvc.model.service.ProdutoService;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBO cadastrarProduto(ProdutoBO produtoBO) {
        
        return produtoRepository.salvar(produtoBO);
    }
}