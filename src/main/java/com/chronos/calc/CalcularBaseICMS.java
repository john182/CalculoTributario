/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.util.Biblioteca;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class CalcularBaseICMS extends CalcularBaseCalculoBase {
    
    private final ITributavel tributos;
    private final TipoDesconto desconto;
    
    public CalcularBaseICMS(ITributavel tributos, TipoDesconto desconto) {
        super(tributos);
        this.tributos = tributos;
        this.desconto = desconto;
    }
    
    public BigDecimal getBaseCalculo() {
        BigDecimal baseCalculo = calcularBaseCalculo().add(Optional.ofNullable(tributos.getValorIpi()).orElse(BigDecimal.ZERO));
        
        return desconto == TipoDesconto.Condincional ? calculaIcmsComDescontoCondicional(baseCalculo) : calculaIcmsComDescontoIncondicional(baseCalculo);
    }
    
    private BigDecimal calculaIcmsComDescontoIncondicional(BigDecimal baseCalculoInicial) {
        BigDecimal baseCalc = Biblioteca.subtrai(baseCalculoInicial, tributos.getDesconto());        
        
        return calcularDesconto(baseCalc);
    }
    
    private BigDecimal calculaIcmsComDescontoCondicional(BigDecimal baseCalculoInicial) {
        BigDecimal baseCalc = baseCalculoInicial.add(tributos.getDesconto());
        return calcularDesconto(baseCalc);
    }
    
    private BigDecimal calcularDesconto(BigDecimal baseCalculoInicial) {     
        BigDecimal reducao = baseCalculoInicial.multiply(tributos.getPercentualReducao()).divide(BigDecimal.valueOf(100));
        baseCalculoInicial = baseCalculoInicial.subtract(reducao);
        baseCalculoInicial = baseCalculoInicial.setScale(2, RoundingMode.DOWN);
        
        return baseCalculoInicial;
    }
    
}
