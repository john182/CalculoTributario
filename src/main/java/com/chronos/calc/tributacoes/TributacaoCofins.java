/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalcularBaseCalculoCofins;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoCofins;
import com.chronos.calc.resultados.imp.ResultadoCalculoCofins;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoCofins {

    private final ITributavel tributos;
    private final CalcularBaseCalculoCofins baseCalculoCofins;

    public TributacaoCofins(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseCalculoCofins = new CalcularBaseCalculoCofins(tributos, desconto);
    }

    public IResultadoCalculoCofins calcular() {
        return calcularCofins();
    }

    private IResultadoCalculoCofins calcularCofins() {
        BigDecimal baseCalculo = baseCalculoCofins.getBaseCalculo();

        BigDecimal valorIcms = calcularCofins(baseCalculo);

        return new ResultadoCalculoCofins(baseCalculo, valorIcms);
    }

    private BigDecimal calcularCofins(BigDecimal baseCalculo) {
        return baseCalculo.multiply(tributos.getPercentualCofins()).divide(BigDecimal.valueOf(100),RoundingMode.DOWN).setScale(2,RoundingMode.DOWN);
        
    }

}
