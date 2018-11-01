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

import com.chronos.calc.calculos.base.CalcularBaseICMS;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoCredito;
import com.chronos.calc.resultados.imp.ResultadoCalculoCredito;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoCreditoIcms {

    private final ITributavel tributos;
    private final CalcularBaseICMS baseICMS;

    public TributacaoCreditoIcms(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseICMS = new CalcularBaseICMS(tributos, desconto);
    }

    public IResultadoCalculoCredito calcular() {
        return calcularIcmsCredito();
    }

    private IResultadoCalculoCredito calcularIcmsCredito() {
        BigDecimal baseCalculo = baseICMS.getBaseCalculo();

        BigDecimal valorCredito = calculaCredito(baseCalculo);

        return new ResultadoCalculoCredito(baseCalculo, valorCredito);
    }

    private BigDecimal calculaCredito(BigDecimal baseCalculo) {
        BigDecimal valorCredito = baseCalculo.multiply(tributos.getPercentualCredito()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN);
        valorCredito = valorCredito.setScale(2, RoundingMode.HALF_DOWN);
        return valorCredito;
    }

}
