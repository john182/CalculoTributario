/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalcularBaseCalculoIpi;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoIpi;
import com.chronos.calc.resultados.imp.ResultadoCalculoIpi;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoIpi {

    private final ITributavel tributos;
    private final CalcularBaseCalculoIpi baseCalculoIpi;

    public TributacaoIpi(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseCalculoIpi = new CalcularBaseCalculoIpi(tributos, desconto);
    }

    public IResultadoCalculoIpi calcular() {
        return calcularIpi();
    }

    private IResultadoCalculoIpi calcularIpi() {
        BigDecimal baseCalculo = baseCalculoIpi.getBaseCalculo();

        BigDecimal valorIpi = calcularIpi(baseCalculo);

        return new ResultadoCalculoIpi(baseCalculo, valorIpi);
    }

    private BigDecimal calcularIpi(BigDecimal baseCalculo) {
        return baseCalculo.multiply(tributos.getPercentualIpi()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
    }
}
