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
public enum Crt {

    SimplesNacional(1, "SIMPLES NACIONAL"),
    SimplesNacionalExcesso(2, "SIMPLES NACIONAL – EXCESSO DE SUBLIMITE DE RECEITA BRUTA"),
    RegimeNormal(3, "REGIME NORMAL");

    private final String descricao;
    private final Integer codigo;

    Crt(Integer codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static Crt valueOfCodigo(final Integer codigo) {
        for (final Crt crt : Crt.values()) {
            if (Objects.equals(crt.getCodigo(), codigo)) {
                return crt;
            }
        }
        // throw new IllegalArgumentException(String.format("Csosn não definido."));
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
