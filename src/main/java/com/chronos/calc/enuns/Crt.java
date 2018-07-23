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
        throw new IllegalArgumentException(String.format("Regime tributário %d não definido.", codigo));

    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
