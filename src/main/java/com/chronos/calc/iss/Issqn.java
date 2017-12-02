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
        baseCalculoInss = valorRetInss!=null && valorRetInss.signum()>0 ? result.getBaseCalculoInss():BigDecimal.ZERO;
        baseCalculoIrrf = valorRetIrrf!=null && valorRetIrrf.signum() > 0? result.getBaseCalculoIrrf():BigDecimal.ZERO;
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
