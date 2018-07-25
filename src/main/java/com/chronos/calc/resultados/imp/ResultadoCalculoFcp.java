package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoFcp;

import java.math.BigDecimal;

public class ResultadoCalculoFcp implements IResultadoCalculoFcp {

    private final BigDecimal baseCalculo;
    private final BigDecimal valor;

    public ResultadoCalculoFcp(BigDecimal baseCalculo, BigDecimal valor) {
        this.baseCalculo = baseCalculo;
        this.valor = valor;
    }

    @Override
    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}
