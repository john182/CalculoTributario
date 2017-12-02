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
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalculoBaseIcmsSemIpi;
import com.chronos.calc.CalculoBaseIcmsSt;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import com.chronos.calc.resultados.imp.ResultadoCalculoIcmsSt;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoIcmsSt {

    private final ITributavel tributos;
    private final CalculoBaseIcmsSemIpi baseIcmsSemIpi;
    private final CalculoBaseIcmsSt baseIcmsSt;

    public TributacaoIcmsSt(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseIcmsSt = new CalculoBaseIcmsSt(tributos, desconto);
        baseIcmsSemIpi = new CalculoBaseIcmsSemIpi(tributos, desconto);
    }

    public IResultadoCalculoIcmsSt calcular() {
        return calcularIcmsSt();
    }

    private IResultadoCalculoIcmsSt calcularIcmsSt() {
        BigDecimal baseCalculoOperacaoPropria = baseIcmsSemIpi.getBaseCalculo();
        BigDecimal valorIcmsProprio = calcularIcmsSt(baseCalculoOperacaoPropria);
        BigDecimal baseCalculoIcmsSt = baseIcmsSt.getBaseCalculo();
        BigDecimal valorIcmsSt = baseCalculoIcmsSt.multiply(tributos.getPercentualIcmsSt().divide(BigDecimal.valueOf(100)));
        valorIcmsSt = valorIcmsSt.subtract(valorIcmsProprio).setScale(2, RoundingMode.DOWN);

        return new ResultadoCalculoIcmsSt(baseCalculoOperacaoPropria, valorIcmsProprio, baseCalculoIcmsSt, valorIcmsSt);
    }

    private BigDecimal calcularIcmsSt(BigDecimal baseCalculo) {
        return baseCalculo.multiply(tributos.getPercentualIcms()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
    }
}
