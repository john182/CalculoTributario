/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalcularBaseICMS;
import com.chronos.calc.CalculoBaseIcmsSemIpi;
import com.chronos.calc.CalculoBaseIcmsSt;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import com.chronos.calc.resultados.imp.ResultadoCalculoIcmsSt;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoIcmsSt {

    private final ITributavel tributos;
    private final CalculoBaseIcmsSemIpi baseIcmsSemIpi;
    private final CalculoBaseIcmsSt baseIcmsSt;

    public TributacaoIcmsSt(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseIcmsSt = new CalculoBaseIcmsSt(tributos, desconto);
        baseIcmsSemIpi = new CalculoBaseIcmsSemIpi(tributos, desconto);
    }

    public IResultadoCalculoIcmsSt calcular() {
        return calcularIcmsSt();
    }

    private IResultadoCalculoIcmsSt calcularIcmsSt() {
        BigDecimal baseCalculoOperacaoPropria = baseIcmsSemIpi.getBaseCalculo();
        BigDecimal valorIcmsProprio = calcularIcmsSt(baseCalculoOperacaoPropria);
        BigDecimal baseCalculoIcmsSt = baseIcmsSt.getBaseCalculo();
        BigDecimal valorIcmsSt = baseCalculoIcmsSt.multiply(tributos.getPercentualIcmsSt().divide(BigDecimal.valueOf(100)));
        valorIcmsSt = valorIcmsSt.subtract(valorIcmsProprio).setScale(2, RoundingMode.DOWN);

        return new ResultadoCalculoIcmsSt(baseCalculoOperacaoPropria, valorIcmsProprio, baseCalculoIcmsSt, valorIcmsSt);
    }

    private BigDecimal calcularIcmsSt(BigDecimal baseCalculo) {
        return baseCalculo.multiply(tributos.getPercentualIcms()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
    }
}
