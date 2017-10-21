/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.iss;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoIssqn;
import java.math.BigDecimal;

/**
 *
 * @author john
 */
public class Issqn {
    
    private BigDecimal valorBcIssqn;
    private BigDecimal percentualIssqn;
    private BigDecimal valorIssqn;
    
    private BigDecimal baseCalculoInss;
    private BigDecimal baseCalculoIrrf;
    private BigDecimal valorRetPis;
    private BigDecimal valorRetCofins;
    private BigDecimal valorRetCsll;
    private BigDecimal valorRetIrrf;
    private BigDecimal valorRetInss;

    public Issqn() {
    }
    
    
    
    public void calcular(ITributavel tributos,boolean calcularRetencao) {
        IResultadoCalculoIssqn result = new CalcTributacao(tributos).calcularIssqn(calcularRetencao);
        valorBcIssqn = result.getBaseCalculo();
        valorIssqn = result.getValor();
        percentualIssqn = tributos.getPercentualIssqn();
        //Retencoes       
        valorRetIrrf = result.getValorRetIrrf();
        valorRetPis = result.getValorRetPis();
        valorRetCofins = result.getValorRetCofins();
        valorRetCsll = result.getValorRetCsll();
        valorRetInss = result.getValorRetInss();
        baseCalculoInss = valorRetInss.signum()>0 ? result.getBaseCalculoInss():BigDecimal.ZERO;
        baseCalculoIrrf = valorRetIrrf.signum() > 0? result.getBaseCalculoIrrf():BigDecimal.ZERO;
    }

    public BigDecimal getValorBcIssqn() {
        return valorBcIssqn;
    }

    public BigDecimal getPercentualIssqn() {
        return percentualIssqn;
    }

    

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public BigDecimal getBaseCalculoInss() {
        return baseCalculoInss;
    }

    public BigDecimal getBaseCalculoIrrf() {
        return baseCalculoIrrf;
    }

    public BigDecimal getValorRetPis() {
        return valorRetPis;
    }

    public BigDecimal getValorRetCofins() {
        return valorRetCofins;
    }

    public BigDecimal getValorRetCsll() {
        return valorRetCsll;
    }

    public BigDecimal getValorRetIrrf() {
        return valorRetIrrf;
    }

    public BigDecimal getValorRetInss() {
        return valorRetInss;
    }
    
    
    
    
}
