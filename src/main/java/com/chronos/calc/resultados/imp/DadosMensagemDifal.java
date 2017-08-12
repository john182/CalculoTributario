/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IDadosMensagemDifal;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class DadosMensagemDifal implements IDadosMensagemDifal {

    private final BigDecimal fcp;
    private final BigDecimal valorIcmsDestino;
    private final BigDecimal valorIcmsOrigem;

    public DadosMensagemDifal(BigDecimal fcp, BigDecimal valorIcmsDestino, BigDecimal valorIcmsOrigem) {
        this.fcp = fcp;
        this.valorIcmsDestino = valorIcmsDestino;
        this.valorIcmsOrigem = valorIcmsOrigem;
    }

    @Override
    public BigDecimal getFcp() {
        return fcp;
    }

    @Override
    public BigDecimal getValorIcmsDestino() {
        return valorIcmsDestino;
    }

    @Override
    public BigDecimal getValorIcmsOrigem() {
        return valorIcmsOrigem;
    }

}
