/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.Cst;

/**
 *
 * @author John Vanderson M L
 */
public class Produto extends ITributavel{
    
    private Cst cst;
    private Csosn csosn;

    public Produto() {
    }

    public Cst getCst() {
        return cst;
    }

    public void setCst(Cst cst) {
        this.cst = cst;
    }

    public Csosn getCsosn() {
        return csosn;
    }

    public void setCsosn(Csosn csosn) {
        this.csosn = csosn;
    }
    
    
    
    
}
