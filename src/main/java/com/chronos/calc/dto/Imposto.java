/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

/**
 *
 * @author John Vanderson M L
 */
public class Imposto {
    
    private Icms icms;    
    private Ipi ipi;
    private Pis pis;
    private Cofins cofins;
    private Issqn issqn;

    public Imposto() {
    }

    public Icms getIcms() {
        return icms;
    }

    public void setIcms(Icms icms) {
        this.icms = icms;
    }

    public Ipi getIpi() {
        return ipi;
    }

    public void setIpi(Ipi ipi) {
        this.ipi = ipi;
    }

    public Pis getPis() {
        return pis;
    }

    public void setPis(Pis pis) {
        this.pis = pis;
    }

    public Cofins getCofins() {
        return cofins;
    }

    public void setCofins(Cofins cofins) {
        this.cofins = cofins;
    }

    public Issqn getIssqn() {
        return issqn;
    }

    public void setIssqn(Issqn issqn) {
        this.issqn = issqn;
    }
    
    
}
