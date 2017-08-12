/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.csosn;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author John Vanderson M L
 */
public class Csosn103 extends CsosnBase {

    public Csosn103() {
        this.csosn = Csosn.Csosn103;
    }

    public Csosn103(OrigemMercadoria OrigemMercadoria) {
        super(OrigemMercadoria);
        this.csosn = Csosn.Csosn103;
    }

    @Override
    public void calcular(ITributavel tributos) {
        throw new UnsupportedOperationException("Não existe calculo para o  CSOSN informado"); //To change body of generated methods, choose Tools | Templates.
    }
}
