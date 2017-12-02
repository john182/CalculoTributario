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

import com.chronos.calc.CalcularBaseCalculoPis;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoPis;
import com.chronos.calc.resultados.imp.ResultadoCalculoPis;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoPis  {
    private final ITributavel tributos;
    private final CalcularBaseCalculoPis baseCalculoPis;

    public TributacaoPis(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseCalculoPis = new CalcularBaseCalculoPis(tributos, desconto);
    }

    public IResultadoCalculoPis calcular() {
        return calcularPis();
    }

    private IResultadoCalculoPis calcularPis() {
        BigDecimal baseCalculo = baseCalculoPis.getBaseCalculo();

        BigDecimal valorIcms = calcularPis(baseCalculo);

        return new ResultadoCalculoPis(baseCalculo, valorIcms);
    }

    private BigDecimal calcularPis(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualPis());
        valor = valor.divide(BigDecimal.valueOf(100)).setScale(2,RoundingMode.DOWN);
        return valor;        
    }

}
