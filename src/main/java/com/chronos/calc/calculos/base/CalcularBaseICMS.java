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
package com.chronos.calc.calculos.base;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * @author John Vanderson M L
 */
public class CalcularBaseICMS extends CalcularBaseCalculoBase {

    private BigDecimal valorIpi;

    // Não compreenderá, na base de cálculo do ICMS, o montante do imposto sobre produtos industrializados,
    // quando a operação, realizada entre contribuintes e relativa a produto destinado à industrialização ou à comercialização,
    // configure fato gerador dos dois impostos (ICMS e IPI).
    // http://www.portaltributario.com.br/artigos/icmssobreipi.htm
    // Caso precisamos contralar essa situação teremos que alguma flag
    public CalcularBaseICMS(ITributavel tributos, TipoDesconto desconto) {
        super(tributos, desconto);
        valorIpi = Optional.ofNullable(getTributos().getValorIpi()).orElse(BigDecimal.ZERO);
    }

    @Override
    public BigDecimal getBaseCalculo() {
        BigDecimal baseCalculo = somarComponentesDaBase();
        baseCalculo = aplicarReducaoBaseCalculo(baseCalculo);
        return aplicarCalculoPorDentroSeImportacao(baseCalculo);
    }

    public BigDecimal getBaseCalculoSemReducao() {
        return somarComponentesDaBase();
    }

    /**
     * Na importação direta, a base do ICMS é inteiramente definida pelos dados da Declaração de
     * Importação — Valor Aduaneiro (CIF) + II + IPI + PIS-Importação + COFINS-Importação +
     * despesas aduaneiras (Siscomex, AFRMM, capatazia etc.) — Lei Kandir art. 13, §1º-I. A
     * legislação não menciona "valor do produto"; por isso a base de importação NÃO usa
     * {@code super.getBaseCalculo()} (valorProduto + frete + seguro + outras despesas), que é a
     * base do mercado interno — {@code valorProduto} é só o valor comercial digitado pelo
     * chamador, sem relação garantida com o CIF.
     */
    private BigDecimal somarComponentesDaBase() {
        if (getTributos().isOperacaoImportacao()) {
            return getTributos().getValorAduaneiro()
                    .add(getTributos().getValorImpostoImportacao())
                    .add(valorIpi)
                    .add(Optional.ofNullable(getTributos().getValorPis()).orElse(BigDecimal.ZERO))
                    .add(Optional.ofNullable(getTributos().getValorCofins()).orElse(BigDecimal.ZERO))
                    .add(getTributos().getValorDespesasAduaneiras());
        }

        return super.getBaseCalculo().add(valorIpi);
    }

    /**
     * "Cálculo por dentro" do ICMS na importação: o próprio imposto integra sua base
     * (Lei Kandir art. 13, §1º, I). Algebricamente, Base = Soma / (1 - alíquota), pois
     * Base = Soma + ICMS e ICMS = Base * alíquota.
     */
    private BigDecimal aplicarCalculoPorDentroSeImportacao(BigDecimal baseCalculo) {
        if (!getTributos().isOperacaoImportacao()) {
            return baseCalculo;
        }

        BigDecimal fatorDivisor = BigDecimal.ONE.subtract(
                getTributos().getPercentualIcms().divide(BigDecimal.valueOf(100)));

        return baseCalculo.divide(fatorDivisor, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal aplicarReducaoBaseCalculo(BigDecimal baseCalculoInicial) {
        BigDecimal reducao = baseCalculoInicial.multiply(getTributos().getPercentualReducao()).divide(BigDecimal.valueOf(100));
        baseCalculoInicial = baseCalculoInicial.subtract(reducao);
        baseCalculoInicial = baseCalculoInicial.setScale(2, RoundingMode.DOWN);

        return baseCalculoInicial;
    }

}
