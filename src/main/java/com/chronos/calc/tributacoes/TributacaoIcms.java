/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.resultados.IResultadoCalculoIcms;
import com.chronos.calc.CalcularBaseICMS;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
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
