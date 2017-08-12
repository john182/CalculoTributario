/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.enuns;

/**
 *
 * @author John Vanderson M L
 */
public enum TipoOperacao {
    
    OperacaoInterna(1,"Operação interna"),
    OperacaoInterestadual(2,"Operação interestadual;"),
    OperacaoExterior(3,"Operação com exterior");
    
    private String descricao;
    private Integer codigo;

    TipoOperacao(Integer codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
