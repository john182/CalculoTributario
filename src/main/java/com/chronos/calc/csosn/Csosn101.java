/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.csosn;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;
import com.chronos.calc.resultados.IResultadoCalculoCredito;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Csosn101 extends CsosnBase {

    private BigDecimal percentualCredito;
    private BigDecimal valorCredito;

    public Csosn101() {
        this.csosn = Csosn.Csosn101;
    }

    public Csosn101(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        this.csosn = Csosn.Csosn101;
    }

    @Override
    public void calcular(ITributavel tributos) {
        validacao(tributos);
        IResultadoCalculoCredito result = new CalcTributacao(tributos).calcularIcmsCredito();
        percentualCredito = tributos.getPercentualCredito().setScale(2);
        valorCredito = result.getValor().setScale(2);
    }

    private void validacao(ITributavel tributos) {
        validacaoPadrao(tributos);
        if (tributos.getPercentualCredito().signum() == 0) {
            throw new IllegalArgumentException("Percentual de credito de ICMS não informado");
        }
    }

    public BigDecimal getPercentualCredito() {
        return percentualCredito;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

}
