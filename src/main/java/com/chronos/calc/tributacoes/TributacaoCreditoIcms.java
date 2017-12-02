/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalcularBaseICMS;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoCredito;
import com.chronos.calc.resultados.imp.ResultadoCalculoCredito;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoCreditoIcms {

    private final ITributavel tributos;
    private final CalcularBaseICMS baseICMS;

    public TributacaoCreditoIcms(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseICMS = new CalcularBaseICMS(tributos, desconto);
    }

    public IResultadoCalculoCredito calcular() {
        return calcularIcmsCredito();
    }

    private IResultadoCalculoCredito calcularIcmsCredito() {
        BigDecimal baseCalculo = baseICMS.getBaseCalculo();

        BigDecimal valorCredito = calculaCredito(baseCalculo);

        return new ResultadoCalculoCredito(baseCalculo, valorCredito);
    }

    private BigDecimal calculaCredito(BigDecimal baseCalculo) {
        return baseCalculo.multiply(tributos.getPercentualCredito()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN);
    }

}
