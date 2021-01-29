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
import com.chronos.calc.resultados.IResultadoCalculoValorDesonerado;
import com.chronos.calc.resultados.imp.ResultadoCalculoValorDesonerado;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author John Vanderson M L
 */
public class TributacaoIcmsDesonerado {

    private final ITributavel tributos;
    private final CalcularBaseICMS baseICMS;

    public TributacaoIcmsDesonerado(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseICMS = new CalcularBaseICMS(tributos, desconto);
    }

    public IResultadoCalculoValorDesonerado calcular() {
        return calcularIcmsDesonerado();
    }

    private IResultadoCalculoValorDesonerado calcularIcmsDesonerado() {
        BigDecimal baseCalculo = baseICMS.getBaseCalculoSemReducao();

        BigDecimal valorDesonerado = tributos.getPercentualReducao().signum() > 0
                ? calcularComReducao(baseCalculo, tributos.getPercentualReducao())
                : calcular(baseCalculo);

        return new ResultadoCalculoValorDesonerado(baseCalculo, valorDesonerado);
    }

    private BigDecimal calcular(BigDecimal baseCalculo) {
        // Valor do ICMS desonerado = (Pre&ccedil;o na Nota Fiscal / (1 - Al&iacute;quota)) * Al&iacute;quota
        BigDecimal one = BigDecimal.ONE;
        BigDecimal valorDesonerado = baseCalculo.divide((one.subtract(tributos.getPercentualIcms())), MathContext.DECIMAL64);
        valorDesonerado = valorDesonerado.multiply(tributos.getPercentualIcms());
        valorDesonerado.setScale(2, RoundingMode.HALF_UP);
        return valorDesonerado;
    }

    private BigDecimal calcularComReducao(BigDecimal baseCalculo, BigDecimal percentualReducao) {
        // Valor do ICMS desonerado = Preço na Nota Fiscal * (1 - (Alíquota * (1 - Percentual de redução da BC))) / (1 - Alíquota) - Preço na Nota Fiscal
        float valorNf = baseCalculo.floatValue();
        float valorReducao = percentualReducao.floatValue();
        float valorAliquota = tributos.getPercentualIcms().floatValue();
        float valor = valorNf * (1 - (valorAliquota * (1 - valorReducao))) / (1 - valorAliquota) - valorNf;

        BigDecimal one = BigDecimal.ONE;

        BigDecimal calcPrimeroParenteseEsq = one.subtract(percentualReducao, MathContext.DECIMAL64);
        BigDecimal calcSegundoParenteseEsq = tributos.getPercentualIcms().multiply(calcPrimeroParenteseEsq, MathContext.DECIMAL64);
        BigDecimal calcTerceiroParenteseEsq = one.subtract(calcSegundoParenteseEsq, MathContext.DECIMAL64);


        BigDecimal calcPrimeroParenteseDir = one.subtract(tributos.getPercentualIcms(), MathContext.DECIMAL64);

        BigDecimal calcExpressaoMulti = baseCalculo.multiply(calcTerceiroParenteseEsq, MathContext.DECIMAL64);

        BigDecimal expressaoDividir = calcExpressaoMulti.divide(calcPrimeroParenteseDir, MathContext.DECIMAL64);


        BigDecimal valorDesonerado = expressaoDividir.subtract(baseCalculo, MathContext.DECIMAL64);

        valorDesonerado.setScale(2, RoundingMode.HALF_UP);

        return valorDesonerado;
    }

}
