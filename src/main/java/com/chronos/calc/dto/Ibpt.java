/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import java.math.BigDecimal;
import java.util.Optional;

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
        return Optional.ofNullable(percentualFederal).orElse(BigDecimal.ZERO);
    }

    public void setPercentualFederal(BigDecimal percentualFederal) {
        this.percentualFederal = percentualFederal;
    }

    public BigDecimal getPercentualFederalImportados() {
        return Optional.ofNullable(percentualFederalImportados).orElse(BigDecimal.ZERO);
    }

    public void setPercentualFederalImportados(BigDecimal percentualFederalImportados) {
        this.percentualFederalImportados = percentualFederalImportados;
    }

    public BigDecimal getPercentualEstadual() {
        return Optional.ofNullable(percentualEstadual).orElse(BigDecimal.ZERO);
    }

    public void setPercentualEstadual(BigDecimal percentualEstadual) {
        this.percentualEstadual = percentualEstadual;
    }

    public BigDecimal getPercentualMunicipal() {
        return Optional.ofNullable(percentualMunicipal).orElse(BigDecimal.ZERO);
    }

    public void setPercentualMunicipal(BigDecimal percentualMunicipal) {
        this.percentualMunicipal = percentualMunicipal;
    }
}
