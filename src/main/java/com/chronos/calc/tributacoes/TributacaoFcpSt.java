package com.chronos.calc.tributacoes;

import com.chronos.calc.CalculoBaseIcmsSt;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoFcpSt;
import com.chronos.calc.resultados.imp.ResultadoCalculoFcpSt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TributacaoFcpSt {

    private final ITributavel tributos;
    private final CalculoBaseIcmsSt baseIcmsSt;

    public TributacaoFcpSt(ITributavel tributos, TipoDesconto tipoDesconto) {
        this.tributos = tributos;
        this.baseIcmsSt = new CalculoBaseIcmsSt(tributos, tipoDesconto);
    }

    public IResultadoCalculoFcpSt calcular() {
        return calcularFcpSt();
    }


    public IResultadoCalculoFcpSt calcularFcpSt() {
        BigDecimal baseCalculo = baseIcmsSt.getBaseCalculo();
        BigDecimal fcp = baseCalculo.multiply(tributos.getPercentualFcpSt()).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.DOWN);

        return new ResultadoCalculoFcpSt(baseCalculo, fcp);

    }


}
