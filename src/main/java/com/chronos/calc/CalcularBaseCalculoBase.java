/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc;

import com.chronos.calc.dto.ITributavel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public abstract class CalcularBaseCalculoBase {
    private final ITributavel tributos;

    public CalcularBaseCalculoBase(ITributavel tributos) {
        this.tributos = tributos;
    }
    
    protected BigDecimal calcularBaseCalculo(){
        BigDecimal valor = BigDecimal.ZERO;
        valor =  tributos.getValorProduto().multiply(tributos.getQuantidadeProduto());
        valor = valor.add(Optional.ofNullable(tributos.getFrete()).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(tributos.getOutrasDespesas()).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(tributos.getSeguro()).orElse(BigDecimal.ZERO));
                      
        valor = valor.setScale(2,RoundingMode.DOWN);
        return valor;
    }
    
  
    
}
