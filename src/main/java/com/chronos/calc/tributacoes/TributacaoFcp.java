package com.chronos.calc.tributacoes;

import com.chronos.calc.calculos.base.CalcularBaseFcp;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoFcp;
import com.chronos.calc.resultados.imp.ResultadoCalculoFcp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TributacaoFcp {

    private final ITributavel tributos;
    private final CalcularBaseFcp baseFcp;

    public TributacaoFcp(ITributavel tributos, TipoDesconto tipoDesconto) {
        this.tributos = tributos;
        this.baseFcp = new CalcularBaseFcp(tributos, tipoDesconto);
    }

    public IResultadoCalculoFcp calcular() {
        return calcularFcp();
    }


    public IResultadoCalculoFcp calcularFcp() {
        BigDecimal baseCalculo = baseFcp.getBaseCalculo();
        BigDecimal fcp = baseCalculo.multiply(tributos.getPercentualFcp()).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.DOWN);

        return new ResultadoCalculoFcp(baseCalculo, fcp);

    }


}
