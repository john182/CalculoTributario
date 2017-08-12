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
public class Cst60 extends CstBase {

    private BigDecimal percentualBcStRetido;
    private BigDecimal valorBcStRetido;

    public Cst60() {
        cst = Cst.Cst60;
    }

    public Cst60(OrigemMercadoria OrigemMercadoria) {
        super(OrigemMercadoria);
        cst = Cst.Cst60;
    }

    @Override
    public void calcular(ITributavel tributos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
