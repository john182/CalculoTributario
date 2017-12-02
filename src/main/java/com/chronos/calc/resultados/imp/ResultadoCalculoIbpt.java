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
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoIbpt;
import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoIbpt implements IResultadoCalculoIbpt {

    private final BigDecimal impostoAproximadoFederal;
    private final BigDecimal impostoAproximadoEstadual;
    private final BigDecimal impostoAproximadoMunicipio;
    private final BigDecimal impostoAproximadoImportados;
    private final BigDecimal baseCalculo;

    public ResultadoCalculoIbpt(BigDecimal impostoAproximadoFederal, BigDecimal impostoAproximadoMunicipio,
            BigDecimal impostoAproximadoEstadual, BigDecimal impostoAproximadoImportados, BigDecimal baseCalculo) {
        this.impostoAproximadoFederal = impostoAproximadoFederal;
        this.impostoAproximadoEstadual = impostoAproximadoEstadual;
        this.impostoAproximadoMunicipio = impostoAproximadoMunicipio;
        this.impostoAproximadoImportados = impostoAproximadoImportados;
        this.baseCalculo = baseCalculo;
    }

    @Override
    public BigDecimal getTributacaoFederal() {
        return impostoAproximadoFederal;
    }

    @Override
    public BigDecimal getTributacaoFederalImportados() {
        return impostoAproximadoImportados;
    }

    @Override
    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    @Override
    public BigDecimal getTributacaoEstadual() {
        return impostoAproximadoEstadual;
    }

    @Override
    public BigDecimal getTributacaoMunicipal() {
        return impostoAproximadoMunicipio;
    }

    @Override
    public BigDecimal getValorTotalTributos() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        valorTotal = valorTotal.add(Optional.ofNullable(impostoAproximadoFederal).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(impostoAproximadoImportados).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(impostoAproximadoEstadual).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(impostoAproximadoMunicipio).orElse(BigDecimal.ZERO));
        return valorTotal;
    }

}
