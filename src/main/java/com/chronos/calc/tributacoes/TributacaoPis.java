/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
