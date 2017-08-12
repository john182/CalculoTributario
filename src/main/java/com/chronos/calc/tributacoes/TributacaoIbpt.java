/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.tributacoes;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Ibpt;
import com.chronos.calc.resultados.IResultadoCalculoIbpt;
import com.chronos.calc.resultados.imp.ResultadoCalculoIbpt;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class TributacaoIbpt {

    private final ITributavel tributos;
    private final Ibpt ibpt;

    public TributacaoIbpt(ITributavel tributos, Ibpt ibpt) {
        this.tributos = tributos;
        this.ibpt = ibpt;
    }

    public IResultadoCalculoIbpt calcular() {
        BigDecimal baseCalculo = tributos.getTotalProduto();

        BigDecimal impostoAproximadoFederal = baseCalculo.multiply(ibpt.getPercentualFederal()).divide(BigDecimal.valueOf(100),RoundingMode.DOWN);
        BigDecimal impostoAproximadoMunicipio = baseCalculo.multiply(ibpt.getPercentualMunicipal()).divide(BigDecimal.valueOf(100),RoundingMode.DOWN); 
        BigDecimal impostoAproximadoEstadual = baseCalculo.multiply(ibpt.getPercentualEstadual()).divide(BigDecimal.valueOf(100),RoundingMode.DOWN); 
        BigDecimal impostoAproximadoImportados =baseCalculo.multiply(ibpt.getPercentualFederalImportados()).divide(BigDecimal.valueOf(100),RoundingMode.DOWN); 

        return new ResultadoCalculoIbpt(impostoAproximadoFederal, impostoAproximadoMunicipio, impostoAproximadoEstadual, impostoAproximadoImportados, baseCalculo);
    }
}
