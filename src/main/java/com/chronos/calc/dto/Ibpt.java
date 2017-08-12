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
public class Ibpt {

    private BigDecimal percentualFederal;
    private BigDecimal percentualFederalImportados;
    private BigDecimal percentualEstadual;
    private BigDecimal percentualMunicipal;

    public BigDecimal getPercentualFederal() {
        return percentualFederal;
    }

    public void setPercentualFederal(BigDecimal percentualFederal) {
        this.percentualFederal = percentualFederal;
    }

    public BigDecimal getPercentualFederalImportados() {
        return percentualFederalImportados;
    }

    public void setPercentualFederalImportados(BigDecimal percentualFederalImportados) {
        this.percentualFederalImportados = percentualFederalImportados;
    }

    public BigDecimal getPercentualEstadual() {
        return percentualEstadual;
    }

    public void setPercentualEstadual(BigDecimal percentualEstadual) {
        this.percentualEstadual = percentualEstadual;
    }

    public BigDecimal getPercentualMunicipal() {
        return percentualMunicipal;
    }

    public void setPercentualMunicipal(BigDecimal percentualMunicipal) {
        this.percentualMunicipal = percentualMunicipal;
    }
}
