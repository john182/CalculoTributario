/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.CalcularBaseICMS;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoDifal;
import com.chronos.calc.resultados.imp.ResultadoCalculoDifal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoDifal {

    private final ITributavel tributos;
    private final CalcularBaseICMS baseICMS;

    public TributacaoDifal(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        baseICMS = new CalcularBaseICMS(tributos, desconto);
    }

    public IResultadoCalculoDifal Calcula() {
        return calcularIcms();
    }

    private IResultadoCalculoDifal calcularIcms() {
        BigDecimal baseCalculo = baseICMS.getBaseCalculo();

        BigDecimal fcp = baseCalculo.multiply(tributos.getPercentualFcp()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        BigDecimal difal = CalcularDifal(baseCalculo);

        BigDecimal percentualRateoOrigem = BigDecimal.valueOf(40);
        BigDecimal percentualReteoDestino = BigDecimal.valueOf(60);
        LocalDate date = LocalDate.now();
        if (date.getYear() == 2018) {
            percentualRateoOrigem = BigDecimal.valueOf(20);
            percentualReteoDestino = BigDecimal.valueOf(80);
        }

        if (date.getYear() >= 2019) {
            percentualRateoOrigem = BigDecimal.ZERO;
            percentualReteoDestino = BigDecimal.valueOf(100);
        }

        BigDecimal aliquotaOrigem = difal.multiply(percentualRateoOrigem).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);

        BigDecimal aliquotaDestino = difal.multiply(percentualReteoDestino).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);

        return new ResultadoCalculoDifal(baseCalculo, difal, fcp, aliquotaDestino, aliquotaOrigem);
    }

    private BigDecimal CalcularDifal(BigDecimal baseCalculo) {
        BigDecimal diferenca = tributos.getPercentualDifalInterna().subtract(tributos.getPercentualDifalInterestadual());
        baseCalculo = baseCalculo.multiply(diferenca.divide(BigDecimal.valueOf(100))).setScale(2,RoundingMode.DOWN);
        return baseCalculo;
    }

}
