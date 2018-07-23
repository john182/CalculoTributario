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
public enum Cst {

    Cst00("00", "00 - Tributada integralmente"),
    Cst10("10", "10 - Tributada e com cobrança do ICMS por substituição tributária"),
    Cst20("20", "20 - Com redução de Base de Cálculo"),
    Cst30("30", "30 - Isenta ou não tributada e com cobrança do ICMS por substituição tributária"),
    Cst40("40", "40 - Isenta"),
    Cst41("41", "41 - Não tributada"),
    Cst50("50", "50 - Com suspensão"),
    Cst51("51", "51 - Com diferimento"),
    Cst60("60", "60 - ICMS cobrado anteriormente por substituição tributária"),
    Cst70("70", "70 - Com redução da Base de Cálculo e cobrança do ICMS por substituição tributária"),
    Cst90("90", "90 - Outros");

    private final String descricao;
    private final String codigo;

    Cst(String codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static Cst valueOfCodigo(final String codigo) {
        for (final Cst cst : Cst.values()) {
            if (Objects.equals(cst.getCodigo(), codigo)) {
                return cst;
            }
        }
        throw new IllegalArgumentException(String.format("Cst %s não definido.", codigo));
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

}
