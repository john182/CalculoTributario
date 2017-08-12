/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.CstIpi;
import com.chronos.calc.enuns.CstPisCofins;

/**
 *
 * @author John Vanderson M L
 */
public class Produto extends ITributavel{
    private boolean servico;
    private Cst cst;
    private Csosn csosn;
    private CstIpi cstIpi;
    private CstPisCofins cstPisCofins;

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

    public CstIpi getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(CstIpi cstIpi) {
        this.cstIpi = cstIpi;
    }

    public CstPisCofins getCstPisCofins() {
        return cstPisCofins;
    }

    public void setCstPisCofins(CstPisCofins cstPisCofins) {
        this.cstPisCofins = cstPisCofins;
    }

    public boolean isServico() {
        return servico;
    }

    public void setServico(boolean servico) {
        this.servico = servico;
    }
    
    
    
    
}
