/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.cst;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author John Vanderson M L
 */
public class Cst40 extends CstBase {

    public Cst40() {
        cst = Cst.Cst40;
    }

    public Cst40(OrigemMercadoria OrigemMercadoria) {
        super(OrigemMercadoria);
        cst = Cst.Cst40;
    }

    @Override
    public void calcular(ITributavel tributos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
