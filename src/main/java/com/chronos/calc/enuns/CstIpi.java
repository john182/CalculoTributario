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
public enum CstIpi {

    Cst00("00", "00 - Entrada com Recuperação de Crédito"),
    Cst01("01", "01 - Entrada Tributada com Alíquota Zero"),
    Cst02("02", "02 - Entrada Isenta"),
    Cst03("03", "03 - Entrada Não Tributada"),
    Cst04("04", "04 - Entrada Imune"),
    Cst05("05", "05 - Entrada com Suspensão"),
    Cst49("49", "49 - Outras Entradas"),
    Cst50("50", "50 - Saída Tributada"),
    Cst51("51", "51 - Saída Tributável com Alíquota Zero"),
    Cst52("52", "52 - Saída Isenta"),
    Cst53("53", "53 - Saída Não Tributada"),
    Cst54("54", "54 - Saída Imune"),
    Cst55("55", "55 - Saída com Suspensão"),
    Cst90("99", "90 - Outras Saídas");

    private final String descricao;
    private final String codigo;

    CstIpi(String codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static CstIpi valueOfCodigo(final String codigo) {
        for (final CstIpi cst : CstIpi.values()) {
            if (Objects.equals(cst.getCodigo(), codigo)) {
                return cst;
            }
        }
         throw new IllegalArgumentException(String.format("Cst IPI não definido."));
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

}
