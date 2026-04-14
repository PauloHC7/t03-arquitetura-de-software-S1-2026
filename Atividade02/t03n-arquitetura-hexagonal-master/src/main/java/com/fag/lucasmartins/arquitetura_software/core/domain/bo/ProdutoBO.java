package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class ProdutoBO {

    private String nome;
    private Integer estoque;
    private double preco;
    private double precoFinal;

    public ProdutoBO(String nome, Integer estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        
    
        validarPrecoProdutoPremium();
        calcularPrecoFinalPorEstoqueBaixo();
    }

    private void validarPrecoProdutoPremium() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            if (this.preco < 100.0) {
                throw new DomainException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private void calcularPrecoFinalPorEstoqueBaixo(){
        if (this.estoque != null && this.estoque >= 50) {
            this.precoFinal = this.preco - (this.preco * 0.10);
        } else {
            this.precoFinal = this.preco; 
        }
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
        validarPrecoProdutoPremium(); 
        calcularPrecoFinalPorEstoqueBaixo(); 
    }


    public String getNome() { return nome; }
    public Integer getEstoque() { return estoque; }
    public double getPreco() { return preco; }
    public double getPrecoFinal() { return precoFinal; }
}