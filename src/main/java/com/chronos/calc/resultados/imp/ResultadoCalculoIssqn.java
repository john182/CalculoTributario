/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoIssqn;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoIssqn implements IResultadoCalculoIssqn{

    private final BigDecimal baseCalculo;
    private final BigDecimal valor;
    
    private BigDecimal baseCalculoInss;
    private BigDecimal baseCalculoIrrf;
    private BigDecimal valorRetPis;
    private BigDecimal valorRetCofins;
    private BigDecimal valorRetCsll;
    private BigDecimal valorRetIrrf;
    private BigDecimal valorRetInss;
  

    public ResultadoCalculoIssqn(BigDecimal baseCalculo, BigDecimal valor) {
        this.baseCalculo = baseCalculo;
        this.valor = valor;
    }

    public ResultadoCalculoIssqn(BigDecimal baseCalculo, BigDecimal valor, BigDecimal baseCalculoInss, BigDecimal baseCalculoIrrf, BigDecimal valorRetPis, BigDecimal valorRetCofins, BigDecimal valorRetCsll, BigDecimal valorRetIrrf, BigDecimal valorRetInss) {
        this.baseCalculo = baseCalculo;
        this.valor = valor;
        this.baseCalculoInss = baseCalculoInss;
        this.baseCalculoIrrf = baseCalculoIrrf;
        this.valorRetPis = valorRetPis;
        this.valorRetCofins = valorRetCofins;
        this.valorRetCsll = valorRetCsll;
        this.valorRetIrrf = valorRetIrrf;
        this.valorRetInss = valorRetInss;
    }
    
    
    
    
    @Override
    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public BigDecimal getBaseCalculoInss() {
        return baseCalculoInss;
    }

    @Override
    public BigDecimal getBaseCalculoIrrf() {
        return baseCalculoIrrf;
    }

    @Override
    public BigDecimal getValorRetPis() {
        return valorRetPis;
    }

    @Override
    public BigDecimal getValorRetCofins() {
        return valorRetCofins;
    }

    @Override
    public BigDecimal getValorRetCsll() {
        return valorRetCsll;
    }

    @Override
    public BigDecimal getValorRetInss() {
        return valorRetInss;
    }

    @Override
    public BigDecimal getValorRetIrrf() {
        return valorRetIrrf;
    }
    
    
    
}
