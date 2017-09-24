/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class Cofins {

    private BigDecimal valor;
    private BigDecimal baseCalculo;

    public Cofins() {
    }

    public BigDecimal getValor() {
        return Optional.ofNullable(valor).orElse(BigDecimal.ZERO);
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getBaseCalculo() {
        return Optional.ofNullable(baseCalculo).orElse(BigDecimal.ZERO);
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }
}
