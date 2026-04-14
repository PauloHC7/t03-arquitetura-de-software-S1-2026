package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.services.PessoaService;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaService pessoaService;

    public PessoaControllerAdapter(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrar(@RequestBody PessoaRequestDTO dto) {
  
        PessoaBO pessoaBO = new PessoaBO(
                null, 
                dto.getNomeCompleto(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getEmail(),
                dto.getTelefone()
        );

        PessoaBO pessoaSalva = pessoaService.cadastrarPessoa(pessoaBO);

    
        PessoaResponseDTO response = new PessoaResponseDTO();
        response.setId(pessoaSalva.getId());
        response.setNomeCompleto(pessoaSalva.getNomeCompleto());
        response.setCpf(pessoaSalva.getCpf());
        response.setDataNascimento(pessoaSalva.getDataNascimento());
        response.setEmail(pessoaSalva.getEmail());
        response.setTelefone(pessoaSalva.getTelefone());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}