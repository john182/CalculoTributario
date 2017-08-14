/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoIbpt;
import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class ResultadoCalculoIbpt implements IResultadoCalculoIbpt {

    private final BigDecimal impostoAproximadoFederal;
    private final BigDecimal impostoAproximadoEstadual;
    private final BigDecimal impostoAproximadoMunicipio;
    private final BigDecimal impostoAproximadoImportados;
    private final BigDecimal baseCalculo;

    public ResultadoCalculoIbpt(BigDecimal impostoAproximadoFederal, BigDecimal impostoAproximadoMunicipio,
            BigDecimal impostoAproximadoEstadual, BigDecimal impostoAproximadoImportados, BigDecimal baseCalculo) {
        this.impostoAproximadoFederal = impostoAproximadoFederal;
        this.impostoAproximadoEstadual = impostoAproximadoEstadual;
        this.impostoAproximadoMunicipio = impostoAproximadoMunicipio;
        this.impostoAproximadoImportados = impostoAproximadoImportados;
        this.baseCalculo = baseCalculo;
    }

    @Override
    public BigDecimal getTributacaoFederal() {
        return impostoAproximadoFederal;
    }

    @Override
    public BigDecimal getTributacaoFederalImportados() {
        return impostoAproximadoImportados;
    }

    @Override
    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    @Override
    public BigDecimal getTributacaoEstadual() {
        return impostoAproximadoEstadual;
    }

    @Override
    public BigDecimal getTributacaoMunicipal() {
        return impostoAproximadoMunicipio;
    }

    @Override
    public BigDecimal getValorTotalTributos() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        valorTotal = valorTotal.add(Optional.ofNullable(impostoAproximadoFederal).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(impostoAproximadoImportados).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(impostoAproximadoEstadual).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(impostoAproximadoMunicipio).orElse(BigDecimal.ZERO));
        return valorTotal;
    }

}
