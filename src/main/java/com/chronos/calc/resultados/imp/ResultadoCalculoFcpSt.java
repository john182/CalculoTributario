package com.chronos.calc.resultados.imp;

import com.chronos.calc.resultados.IResultadoCalculoFcpSt;

import java.math.BigDecimal;

public class ResultadoCalculoFcpSt implements IResultadoCalculoFcpSt {

    private final BigDecimal baseCalculo;
    private final BigDecimal valor;

    public ResultadoCalculoFcpSt(BigDecimal baseCalculo, BigDecimal valor) {
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
