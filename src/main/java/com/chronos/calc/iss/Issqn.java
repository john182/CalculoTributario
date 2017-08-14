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

    public Issqn() {
    }
    
    
    
    public void calcular(ITributavel tributos) {
        IResultadoCalculoIssqn result = new CalcTributacao(tributos).calcularIssqn();
        valorBcIssqn = result.getBaseCalculo();
        valorIssqn = result.getValor();
        percentualIssqn = tributos.getPercentualIssqn();
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
    
    
}
