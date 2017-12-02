/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.enuns;

import java.util.Objects;

/**
 *
 * @author John Vanderson M L
 */
public enum Csosn {
    Csosn101("101", "101 - Tributada pelo Simples Nacional com permissão de crédito"),
    Csosn102("102", "102 - Tributada pelo Simples Nacional sem permissão de crédito"),
    Csosn103("103", "103 - Isenção do ICMS no Simples Nacional para faixa de receita bruta"),
    Csosn201("104", "201 - Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS substituição tributária"),
    Csosn202("202", "202 - Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS substituição tributária"),
    Csosn203("203", "203 - Isenção do ICMS no Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária"),
    Csosn300("300", "300 - Imune"),
    Csosn400("400", "400 - Não tributada pelo Simples Nacional"),
    Csosn500("500", "500 - ICMS cobrado anteriormente por substituição tributária"),
    Csosn900("900", "900 - Outros");

    private final String descricao;
    private final String codigo;

    Csosn(String codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static Csosn valueOfCodigo(final String codigo) {
        for (final Csosn csosn : Csosn.values()) {
            if (Objects.equals(csosn.getCodigo(), codigo)) {
                return csosn;
            }
        }
        // throw new IllegalArgumentException(String.format("Csosn não definido."));
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

}
