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
public class Ipi {
    
    private BigDecimal valorBcIpi;
    private BigDecimal valorIpi;

    public Ipi() {
    }

    public BigDecimal getValorBcIpi() {
        return valorBcIpi;
    }

    public void setValorBcIpi(BigDecimal valorBcIpi) {
        this.valorBcIpi = valorBcIpi;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }
    
    
}
