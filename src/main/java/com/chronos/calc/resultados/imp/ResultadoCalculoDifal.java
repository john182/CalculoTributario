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

import com.chronos.calc.resultados.IDadosMensagemDifal;
import com.chronos.calc.resultados.IResultadoCalculoDifal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoDifal implements IResultadoCalculoDifal {

    private final BigDecimal baseCalculo;
    private final BigDecimal difal;
    private final BigDecimal fcp;
    private final BigDecimal valorIcmsDestino;
    private final BigDecimal valorIcmsOrigem;
    private final DecimalFormat formatoValor;

    public ResultadoCalculoDifal(BigDecimal baseCalculo, BigDecimal difal, BigDecimal fcp, BigDecimal valorIcmsDestino, BigDecimal valorIcmsOrigem) {
        this.baseCalculo = baseCalculo;
        this.difal = difal;
        this.fcp = fcp;
        this.valorIcmsDestino = valorIcmsDestino;
        this.valorIcmsOrigem = valorIcmsOrigem;
        DecimalFormatSymbols simboloDecimal = DecimalFormatSymbols.getInstance();
        simboloDecimal.setDecimalSeparator('.');
        this.formatoValor = new DecimalFormat("0.00", simboloDecimal);
    }

    @Override
    public String getObservacao(IDadosMensagemDifal dadosMensagemDifal) {
        return "Valores totais do ICMS interstadual: DIFAL da UF destino "
                + formatoValor.format(dadosMensagemDifal.getValorIcmsDestino())
                + " + FCP "
                + formatoValor.format(dadosMensagemDifal.getFcp())
                + "; DIFAL da UF Origem "
                + formatoValor.format(dadosMensagemDifal.getValorIcmsOrigem());
    }

    @Override
    public BigDecimal getFcp() {
        return fcp;
    }

    @Override
    public BigDecimal getValorIcmsDestino() {
        return valorIcmsDestino;
    }

    @Override
    public BigDecimal getValorIcmsOrigem() {
        return valorIcmsOrigem;
    }

    @Override
    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    @Override
    public BigDecimal getDifal() {
        return difal;
    }
}
