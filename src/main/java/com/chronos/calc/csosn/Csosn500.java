/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.csosn;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Csosn500 extends CsosnBase {

    private BigDecimal percentualBcStRetido;
    private BigDecimal valorBcStRetido;
    
    public Csosn500() {
        this.csosn = Csosn.Csosn500;
    }

    public Csosn500(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        this.csosn = Csosn.Csosn500;
    }

    @Override
    public void calcular(ITributavel tributos) {
        
    }

    public BigDecimal getPercentualBcStRetido() {
        return percentualBcStRetido;
    }

    public void setPercentualBcStRetido(BigDecimal percentualBcStRetido) {
        this.percentualBcStRetido = percentualBcStRetido;
    }

    public BigDecimal getValorBcStRetido() {
        return valorBcStRetido;
    }

    public void setValorBcStRetido(BigDecimal valorBcStRetido) {
        this.valorBcStRetido = valorBcStRetido;
    }
    
    

}
