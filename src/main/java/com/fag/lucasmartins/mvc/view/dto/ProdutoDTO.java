package com.fag.lucasmartins.mvc.view.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull
    @Positive(message = "O preço deve ser maior que zero")
    private Double precoBase;

    @NotNull
    @PositiveOrZero(message = "A quantidade não pode ser negativa")
    private Integer quantidade;

    private Boolean premium;

    public ProdutoDTO() {}

    public ProdutoDTO(Long id, String nome, Double precoBase, Integer quantidade, Boolean premium) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
        this.quantidade = quantidade;
        this.premium = premium;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPrecoBase() { return precoBase; }
    public void setPrecoBase(Double precoBase) { this.precoBase = precoBase; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Boolean getPremium() { return premium; }
    public void setPremium(Boolean premium) { this.premium = premium; }
}