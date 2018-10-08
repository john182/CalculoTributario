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
package com.chronos.calc.csosn;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Icms;
import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;
import com.chronos.calc.resultados.IResultadoCalculoCredito;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Tributada pelo Simples Nacional com permissão de crédito
 *
 * @author John Vanderson M L
 */
public class Csosn101 extends CsosnBase {

    private BigDecimal percentualCredito;
    private BigDecimal valorCredito;

    public Csosn101() {
        this.csosn = Csosn.Csosn101;
    }

    public Csosn101(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        this.csosn = Csosn.Csosn101;
    }

    @Override
    public void calcular(ITributavel tributos) {
        validacao(tributos);
        IResultadoCalculoCredito result = new CalcTributacao(tributos).calcularIcmsCredito();
        percentualCredito = tributos.getPercentualCredito().setScale(2);
        valorCredito = result.getValor().setScale(2, RoundingMode.HALF_DOWN);
    }

    private void validacao(ITributavel tributos) {
        validacaoPadrao(tributos);
        if (tributos.getPercentualCredito().signum() == 0) {
            throw new IllegalArgumentException("Percentual de credito de ICMS não informado");
        }
    }

    public BigDecimal getPercentualCredito() {
        return percentualCredito;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    @Override
    public Icms getIcmsDto() {
        Icms icms = super.getIcmsDto();

        icms.setValorCredito(getValorCredito());
        icms.setPercentualCredito(getPercentualCredito());

        return icms;

    }
}
