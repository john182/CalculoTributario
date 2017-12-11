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
import com.chronos.calc.resultados.IResultadoCalculoDifal;
import com.chronos.calc.resultados.imp.ResultadoCalculoDifal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoDifal {

    private final ITributavel tributos;
    private final CalcularBaseICMS baseICMS;

    public TributacaoDifal(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseICMS = new CalcularBaseICMS(tributos, desconto);
    }

    public IResultadoCalculoDifal calcular() {
        return calcularIcms();
    }

    private IResultadoCalculoDifal calcularIcms() {
        BigDecimal baseCalculo = baseICMS.getBaseCalculo();

        BigDecimal fcp = baseCalculo.multiply(tributos.getPercentualFcp()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        BigDecimal difal = calcularDifal(baseCalculo);

        BigDecimal percentualRateoOrigem = BigDecimal.valueOf(40);
        BigDecimal percentualReteoDestino = BigDecimal.valueOf(60);
        LocalDate date = LocalDate.now();
        if (date.getYear() == 2018) {
            percentualRateoOrigem = BigDecimal.valueOf(20);
            percentualReteoDestino = BigDecimal.valueOf(80);
        }

        if (date.getYear() >= 2019) {
            percentualRateoOrigem = BigDecimal.ZERO;
            percentualReteoDestino = BigDecimal.valueOf(100);
        }

        BigDecimal aliquotaOrigem = difal.multiply(percentualRateoOrigem).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);

        BigDecimal aliquotaDestino = difal.multiply(percentualReteoDestino).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);

        return new ResultadoCalculoDifal(baseCalculo, difal, fcp, aliquotaDestino, aliquotaOrigem);
    }

    private BigDecimal calcularDifal(BigDecimal baseCalculo) {
        BigDecimal diferenca = tributos.getPercentualDifalInterna().subtract(tributos.getPercentualDifalInterestadual());
        baseCalculo = baseCalculo.multiply(diferenca.divide(BigDecimal.valueOf(100))).setScale(2, RoundingMode.DOWN);
        return baseCalculo;
    }

}
