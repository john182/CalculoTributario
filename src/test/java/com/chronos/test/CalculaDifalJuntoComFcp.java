/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoDifal;
import com.chronos.calc.resultados.imp.DadosMensagemDifal;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class CalculaDifalJuntoComFcp {

    public CalculaDifalJuntoComFcp() {
    }

    @Test
    public void CalculaDifalJuntoComFcp() {
        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(845));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setFrete(BigDecimal.valueOf(35));
        tributos.setOutrasDespesas(BigDecimal.valueOf(80));
        tributos.setDesconto(BigDecimal.valueOf(10));
        tributos.setValorIpi(BigDecimal.valueOf(50));
        tributos.setPercentualFcp(BigDecimal.valueOf(2));
        tributos.setPercentualDifalInterna(BigDecimal.valueOf(18));
        tributos.setPercentualDifalInterestadual(BigDecimal.valueOf(12));

        CalcTributacao calcular = new CalcTributacao(tributos);

        IResultadoCalculoDifal result = calcular.calculaDifalFcp();

        BigDecimal baseCalculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(1000).setScale(2, RoundingMode.DOWN);

        BigDecimal fcp = result.getFcp();
        BigDecimal fcpTest = BigDecimal.valueOf(20).setScale(2);

        BigDecimal difal = result.getDifal();
        BigDecimal difalTest = BigDecimal.valueOf(60).setScale(2);

        BigDecimal valorIcmsOrigem = result.getValorIcmsOrigem();
        BigDecimal valorIcmsOrigemTest = BigDecimal.valueOf(24).setScale(2);

        BigDecimal valorIcmsDestino = result.getValorIcmsDestino();
        BigDecimal valorIcmsDestinoTest = BigDecimal.valueOf(36).setScale(2);

        String obs = result.getObservacao(new DadosMensagemDifal(fcp, valorIcmsDestino, valorIcmsOrigem));

        Assert.assertEquals(baseCalculoTest, baseCalculo);
        Assert.assertEquals(fcpTest, fcp);
        Assert.assertEquals(difalTest, difal);
        Assert.assertEquals(valorIcmsOrigemTest, valorIcmsOrigem);
        Assert.assertEquals(valorIcmsDestinoTest, valorIcmsDestino);

    }
}
