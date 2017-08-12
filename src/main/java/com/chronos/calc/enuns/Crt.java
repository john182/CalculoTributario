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
public enum Crt {
    
    SimplesNaciona(1,"SIMPLES NACIONAL"),
    SimplesNacionalExecesso(2,"SIMPLES NACIONAL – EXCESSO DE SUBLIMITE DE RECEITA BRUTA"),
    RegimeNormal(3,"REGIME NORMAL");
    
    private String descricao;
    private Integer codigo;

    Crt(Integer codigo, String descricao) {
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
