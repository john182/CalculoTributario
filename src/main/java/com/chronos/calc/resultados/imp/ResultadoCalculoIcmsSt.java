/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoIcmsSt implements IResultadoCalculoIcmsSt {

    private final BigDecimal baseCalculoOperacaoPropria;
    private final BigDecimal valorIcmsProprio;
    private final BigDecimal baseCalculoIcmsSt;
    private final BigDecimal valorIcmsSt;

    public ResultadoCalculoIcmsSt(BigDecimal baseCalculoOperacaoPropria, BigDecimal valorIcmsProprio, BigDecimal baseCalculoIcmsSt, BigDecimal valorIcmsSt) {
        this.baseCalculoOperacaoPropria = baseCalculoOperacaoPropria;
        this.valorIcmsProprio = valorIcmsProprio;
        this.baseCalculoIcmsSt = baseCalculoIcmsSt;
        this.valorIcmsSt = valorIcmsSt;
    }

    @Override
    public BigDecimal getBaseCalculoOperacaoPropria() {
        return baseCalculoOperacaoPropria;
    }

    @Override
    public BigDecimal getValorIcmsProprio() {
        return valorIcmsProprio;
    }

    @Override
    public BigDecimal getBaseCalculoIcmsSt() {
        return baseCalculoIcmsSt;
    }

    @Override
    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

}
