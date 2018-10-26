/* 
 * The MIT License
 *
 * Copyright 2017 Chronusinfo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
    Csosn201("201", "201 - Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS substituição tributária"),
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
        throw new IllegalArgumentException(String.format("Csosn %s não definido.", codigo));
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

}
