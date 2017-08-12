/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.util;

import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class BigDecimalUtil extends BigDecimal{
    
    private final BigDecimal valor;

    public BigDecimalUtil(BigDecimal valor) {
       super(valor.toPlainString());
       this.valor = Optional.ofNullable(valor).orElse(BigDecimal.ZERO);
    }


    public BigDecimal somar(){
        return somar(valor);
    }
    
    public BigDecimalUtil somar(BigDecimal valor){
        valor = valor.add(Optional.ofNullable(valor).orElse(BigDecimal.ZERO));
        return new BigDecimalUtil(valor);
    }

 

    
    
    public BigDecimal adds(BigDecimal valor){        
        valor = valor.add(Optional.ofNullable(valor).orElse(BigDecimal.ZERO));        
        return valor;
    }
}
