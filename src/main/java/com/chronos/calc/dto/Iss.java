/* 
 * The MIT License
 *
 * Copyright 2017 Chronusinfo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
    private BigDecimal baseCalculoInss;
    private BigDecimal baseCalculoIrrf;
    private BigDecimal valorRetPis;
    private BigDecimal valorRetCofins;
    private BigDecimal valorRetCsll;
    private BigDecimal valorRetIrrf;
    private BigDecimal valorRetInss;

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

    public BigDecimal getBaseCalculoInss() {
        return baseCalculoInss;
    }

    public void setBaseCalculoInss(BigDecimal baseCalculoInss) {
        this.baseCalculoInss = baseCalculoInss;
    }

    public BigDecimal getBaseCalculoIrrf() {
        return baseCalculoIrrf;
    }

    public void setBaseCalculoIrrf(BigDecimal baseCalculoIrrf) {
        this.baseCalculoIrrf = baseCalculoIrrf;
    }

    public BigDecimal getValorRetPis() {
        return valorRetPis;
    }

    public void setValorRetPis(BigDecimal valorRetPis) {
        this.valorRetPis = valorRetPis;
    }

    public BigDecimal getValorRetCofins() {
        return valorRetCofins;
    }

    public void setValorRetCofins(BigDecimal valorRetCofins) {
        this.valorRetCofins = valorRetCofins;
    }

    public BigDecimal getValorRetCsll() {
        return valorRetCsll;
    }

    public void setValorRetCsll(BigDecimal valorRetCsll) {
        this.valorRetCsll = valorRetCsll;
    }

    public BigDecimal getValorRetIrrf() {
        return valorRetIrrf;
    }

    public void setValorRetIrrf(BigDecimal valorRetIrrf) {
        this.valorRetIrrf = valorRetIrrf;
    }

    public BigDecimal getValorRetInss() {
        return valorRetInss;
    }

    public void setValorRetInss(BigDecimal valorRetInss) {
        this.valorRetInss = valorRetInss;
    }
    
    

}
