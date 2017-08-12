/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class NFeCalculo {    
    
    private BigDecimal valorCredito;
    private BigDecimal percentualCredito;
    
    private BigDecimal valorIcms;
    private BigDecimal valorBcIcms; 
            

    private BigDecimal percentualMva;
    private BigDecimal percentualIcmsST;
    private BigDecimal percentualReducaoST;
    private BigDecimal valorIcmsST;
    private BigDecimal valorBaseCalcST;
    
    
    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getPercentualCredito() {
        return percentualCredito;
    }

    public void setPercentualCredito(BigDecimal percentualCredito) {
        this.percentualCredito = percentualCredito;
    }

    public BigDecimal getPercentualMva() {
        return percentualMva;
    }

    public void setPercentualMva(BigDecimal percentualMva) {
        this.percentualMva = percentualMva;
    }

    public BigDecimal getPercentualIcmsST() {
        return percentualIcmsST;
    }

    public void setPercentualIcmsST(BigDecimal percentualIcmsST) {
        this.percentualIcmsST = percentualIcmsST;
    }

    public BigDecimal getPercentualReducaoST() {
        return percentualReducaoST;
    }

    public void setPercentualReducaoST(BigDecimal percentualReducaoST) {
        this.percentualReducaoST = percentualReducaoST;
    }

    public BigDecimal getValorIcmsST() {
        return valorIcmsST;
    }

    public void setValorIcmsST(BigDecimal valorIcmsST) {
        this.valorIcmsST = valorIcmsST;
    }

    public BigDecimal getValorBaseCalcST() {
        return valorBaseCalcST;
    }

    public void setValorBaseCalcST(BigDecimal valorBaseCalcST) {
        this.valorBaseCalcST = valorBaseCalcST;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getValorBcIcms() {
        return valorBcIcms;
    }

    public void setValorBcIcms(BigDecimal valorBcIcms) {
        this.valorBcIcms = valorBcIcms;
    }
    
    
    
}
