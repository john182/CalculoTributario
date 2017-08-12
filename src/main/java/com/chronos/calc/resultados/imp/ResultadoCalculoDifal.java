/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IDadosMensagemDifal;
import com.chronos.calc.resultados.IResultadoCalculoDifal;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoDifal implements IResultadoCalculoDifal {

    private final BigDecimal baseCalculo;
    private final BigDecimal difal;
    private final BigDecimal fcp;
    private final BigDecimal valorIcmsDestino;
    private final BigDecimal valorIcmsOrigem;
    private final DecimalFormatSymbols simboloDecimal;
    private final DecimalFormat formatoValor;

    public ResultadoCalculoDifal(BigDecimal baseCalculo, BigDecimal difal, BigDecimal fcp, BigDecimal valorIcmsDestino, BigDecimal valorIcmsOrigem) {
        this.baseCalculo = baseCalculo;
        this.difal = difal;
        this.fcp = fcp;
        this.valorIcmsDestino = valorIcmsDestino;
        this.valorIcmsOrigem = valorIcmsOrigem;
        this.simboloDecimal = DecimalFormatSymbols.getInstance();
        this.simboloDecimal.setDecimalSeparator('.');
        this.formatoValor = new DecimalFormat("0.00", simboloDecimal);
    }

    @Override
    public String getObservacao(IDadosMensagemDifal dadosMensagemDifal) {
        return "Valores totais do ICMS interstadual: DIFAL da UF destino "
                + formatoValor.format(dadosMensagemDifal.getValorIcmsDestino())
                + " + FCP "
                + formatoValor.format(dadosMensagemDifal.getFcp())
                + "; DIFAL da UF Origem "
                + formatoValor.format(dadosMensagemDifal.getValorIcmsOrigem());
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

    @Override
    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    @Override
    public BigDecimal getDifal() {
        return difal;
    }
}
