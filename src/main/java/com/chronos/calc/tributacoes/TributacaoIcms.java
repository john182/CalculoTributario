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

import com.chronos.calc.CalcularBaseICMS;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoIcms;
import com.chronos.calc.resultados.imp.ResultadoCalculoIcms;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoIcms {

    private final ITributavel tributos;
    private final CalcularBaseICMS baseICMS;

    public TributacaoIcms(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseICMS = new CalcularBaseICMS(tributos, desconto);
    }

    public IResultadoCalculoIcms calcular() {
        return calcularIcms();
    }

    private IResultadoCalculoIcms calcularIcms() {
        BigDecimal baseCalculo = baseICMS.getBaseCalculo();

        BigDecimal valorIcms = calcularIcms(baseCalculo);

        return new ResultadoCalculoIcms(baseCalculo, valorIcms);
    }

    private BigDecimal calcularIcms(BigDecimal baseCalculo) {
        BigDecimal valorIcms = baseCalculo.multiply(tributos.getPercentualIcms()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN);
        valorIcms = valorIcms.setScale(2, RoundingMode.HALF_DOWN);
        return valorIcms;
    }
}
