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
public class Csosn102 extends CsosnBase {

    public Csosn102() {
        this.csosn = Csosn.Csosn102;
    }

    public Csosn102(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
         this.csosn = Csosn.Csosn102;
    }

    @Override
    public void calcular(ITributavel tributos) {
        throw new UnsupportedOperationException("Não existe calculo para o  CSOSN informado");
    }
}
