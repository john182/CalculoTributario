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
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoIssqn;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoIssqn implements IResultadoCalculoIssqn {

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
