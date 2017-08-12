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

    public IResultadoCalculoIssqn calcular() {
        return calcularIpi();
    }

    private IResultadoCalculoIssqn calcularIpi() {
        BigDecimal baseCalculo = baseCalculoIssqn.getBaseCalculo();

        BigDecimal valorIss = calcularIssqn(baseCalculo);

        return new ResultadoCalculoIssqn(baseCalculo, valorIss);
    }

    private BigDecimal calcularIssqn(BigDecimal baseCalculo) {
        return baseCalculo.multiply(tributos.getPercentualIssqn()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
    }
}
