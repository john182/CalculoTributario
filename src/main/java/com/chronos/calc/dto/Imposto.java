/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Imposto {

    private Icms icms;
    private Ipi ipi;
    private Pis pis;
    private Cofins cofins;
    private Iss issqn;
    private BigDecimal tributacaoEstadual;
    private BigDecimal tributacaoFederal;
    private BigDecimal tributacaoFederalImp;
    private BigDecimal tributacaoMunicipal;
    private BigDecimal valorTotalTributos;

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

    public Iss getIssqn() {
        return issqn;
    }

    public void setIssqn(Iss issqn) {
        this.issqn = issqn;
    }

    public BigDecimal getTributacaoEstadual() {
        return tributacaoEstadual;
    }

    public void setTributacaoEstadual(BigDecimal tributacaoEstadual) {
        this.tributacaoEstadual = tributacaoEstadual;
    }

    public BigDecimal getTributacaoFederal() {
        return tributacaoFederal;
    }

    public void setTributacaoFederal(BigDecimal tributacaoFederal) {
        this.tributacaoFederal = tributacaoFederal;
    }

    public BigDecimal getTributacaoFederalImp() {
        return tributacaoFederalImp;
    }

    public void setTributacaoFederalImp(BigDecimal tributacaoFederalImp) {
        this.tributacaoFederalImp = tributacaoFederalImp;
    }

    public BigDecimal getTributacaoMunicipal() {
        return tributacaoMunicipal;
    }

    public void setTributacaoMunicipal(BigDecimal tributacaoMunicipal) {
        this.tributacaoMunicipal = tributacaoMunicipal;
    }

    public BigDecimal getValorTotalTributos() {
        return valorTotalTributos;
    }

    public void setValorTotalTributos(BigDecimal valorTotalTributos) {
        this.valorTotalTributos = valorTotalTributos;
    }
    
    

}
