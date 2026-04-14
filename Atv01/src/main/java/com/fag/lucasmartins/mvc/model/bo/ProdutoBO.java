package com.fag.lucasmartins.mvc.model.bo;

public class ProdutoBO {

    private Long id;
    private String nome;
    private Double precoBase;
    private Integer quantidade;
    private boolean premium;

    public ProdutoBO(Long id, String nome, Double precoBase, Integer quantidade, boolean premium) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
        this.quantidade = quantidade;
        this.premium = premium;
        
        validarRegraPremium();
    }

    private void validarRegraPremium() {
        if (this.premium && this.precoBase < 100.0) {
            throw new RuntimeException("Um produto Premium não pode custar menos de R$ 100,00.");
        }
    }

    public Double calcularValorTotalEstoque() {
        if (this.premium) {
            return this.precoBase * this.quantidade; 
        }
        
        if (this.quantidade >= 10) {
            double precoComDesconto = this.precoBase * 0.85;
            return precoComDesconto * this.quantidade;
        }
        
        return this.precoBase * this.quantidade;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPrecoBase() { return precoBase; }
    public void setPrecoBase(Double precoBase) { this.precoBase = precoBase; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public boolean isPremium() { return premium; }
    public void setPremium(boolean premium) { this.premium = premium; }
}