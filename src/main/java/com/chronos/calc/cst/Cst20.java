/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.cst;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.OrigemMercadoria;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Cst20 extends Cst00{

    private BigDecimal percentualReducao;
   
    public Cst20() {
        cst = Cst.Cst20;
    }

    
    
    public Cst20(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        cst = Cst.Cst20;
    }
    
    
    
    @Override
    public void calcular(ITributavel tributos) {
        super.calcular(tributos); //To change body of generated methods, choose Tools | Templates.
        percentualReducao = tributos.getPercentualReducao().setScale(2);
    }

    public BigDecimal getPercentualReducao() {
        return percentualReducao;
    }
    
    
}
