package com.fag.lucasmartins.mvc.controller;

import com.fag.lucasmartins.mvc.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.service.ProdutoService;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoBO produtoBO = ProdutoDTOMapper.toBo(dto);
        
        ProdutoBO produtoSalvoBO = produtoService.cadastrarProduto(produtoBO);
        
        ProdutoDTO produtoSalvoDTO = ProdutoDTOMapper.toDto(produtoSalvoBO);
        
        return ResponseEntity.status(201).body(produtoSalvoDTO);
    }
}