/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalcularBaseCalculoIssqn;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoIssqn;
import com.chronos.calc.resultados.imp.ResultadoCalculoIssqn;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoIssqn {

    private final ITributavel tributos;
    private final CalcularBaseCalculoIssqn baseCalculoIssqn;

    public TributacaoIssqn(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseCalculoIssqn = new CalcularBaseCalculoIssqn(tributos, desconto);
    }

    public IResultadoCalculoIssqn calcular(boolean calcularRetencoes) {
        return calcularIssqn(calcularRetencoes);
    }

    private IResultadoCalculoIssqn calcularIssqn(boolean calcularRetencoes) {
        BigDecimal baseCalculo = baseCalculoIssqn.getBaseCalculo();

        BigDecimal valorIss = calcularIssqn(baseCalculo);

        return !calcularRetencoes ? new ResultadoCalculoIssqn(baseCalculo, valorIss) : calcularRetencoes(baseCalculo, valorIss);
    }

    private IResultadoCalculoIssqn calcularRetencoes(BigDecimal baseCalculo, BigDecimal valorIss) {
        BigDecimal baseCalculoInss = baseCalculo;
        BigDecimal baseCalculoIrrf = baseCalculo;
        BigDecimal valorRetPis = calcularRetPis(baseCalculo);
        BigDecimal valorRetCofins = calcularRetCofins(baseCalculo);
        BigDecimal valorRetCsll = calcularRetCsll(baseCalculo);
        BigDecimal valorRetIrrf = calcularRetIrrf(baseCalculo);
        BigDecimal valorRetInss = calcularRetInss(baseCalculo);

        return new ResultadoCalculoIssqn(baseCalculo, valorIss, baseCalculoInss, baseCalculoIrrf, valorRetPis, valorRetCofins, valorRetCsll, valorRetIrrf, valorRetInss);

    }

    private BigDecimal calcularIssqn(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualIssqn()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        return valor.compareTo(BigDecimal.valueOf(29)) >= 0 ? valor : BigDecimal.ZERO;
    }

    private BigDecimal calcularRetPis(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualRetPis()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        return valor.compareTo(BigDecimal.valueOf(10)) >= 0 ? valor : BigDecimal.ZERO;
    }

    private BigDecimal calcularRetCofins(BigDecimal baseCalculo) {

        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualRetCofins()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        return valor.compareTo(BigDecimal.valueOf(10)) >= 0 ? valor : BigDecimal.ZERO;
    }

    private BigDecimal calcularRetCsll(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualRetCsll()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        return valor.compareTo(BigDecimal.valueOf(10)) >= 0 ? valor : BigDecimal.ZERO;
    }

    private BigDecimal calcularRetIrrf(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualRetIrrf()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        return valor.compareTo(BigDecimal.valueOf(10)) >= 0 ? valor : BigDecimal.ZERO;
    }

    private BigDecimal calcularRetInss(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.multiply(tributos.getPercentualRetInss()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        return valor.compareTo(BigDecimal.valueOf(10)) >= 0 ? valor : BigDecimal.ZERO;
    }

}
