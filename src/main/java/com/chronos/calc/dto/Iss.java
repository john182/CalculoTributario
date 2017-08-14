/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Iss {

    private BigDecimal valor;
    private BigDecimal baseCalculo;
    private BigDecimal percentualIss;

    public Iss() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public BigDecimal getPercentualIss() {
        return percentualIss;
    }

    public void setPercentualIss(BigDecimal percentualIss) {
        this.percentualIss = percentualIss;
    }
    
    
    
    
}
