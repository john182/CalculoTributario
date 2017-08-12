/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class CalcularBaseCalculoIpi extends CalcularBaseCalculoBase{

    private final ITributavel tributos;
    private final TipoDesconto desconto;

    public CalcularBaseCalculoIpi(ITributavel tributos, TipoDesconto desconto) {
        super(tributos);
        this.tributos = tributos;
        this.desconto = desconto;
    }

    public BigDecimal getBaseCalculo() {
        BigDecimal baseCalculo = calcularBaseCalculo();

        return desconto == TipoDesconto.Condincional ? calculaIcmsComDescontoCondicional(baseCalculo) : calculaIcmsComDescontoIncondicional(baseCalculo);
    }

    private BigDecimal calculaIcmsComDescontoCondicional(BigDecimal baseCalculo) {
        BigDecimal valor = baseCalculo.add(tributos.getDesconto());
        return valor;
    }

    private BigDecimal calculaIcmsComDescontoIncondicional(BigDecimal baseCalculo) {

        baseCalculo = baseCalculo.subtract(tributos.getDesconto());
        return baseCalculo;
    }
    
    
}
