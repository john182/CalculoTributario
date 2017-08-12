/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Ibpt;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoCofins;
import com.chronos.calc.resultados.IResultadoCalculoCredito;
import com.chronos.calc.resultados.IResultadoCalculoDifal;
import com.chronos.calc.resultados.IResultadoCalculoIbpt;
import com.chronos.calc.resultados.IResultadoCalculoIcms;
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import com.chronos.calc.resultados.IResultadoCalculoIpi;
import com.chronos.calc.resultados.IResultadoCalculoIssqn;
import com.chronos.calc.resultados.IResultadoCalculoPis;
import com.chronos.calc.tributacoes.TributacaoCofins;
import com.chronos.calc.tributacoes.TributacaoCreditoIcms;
import com.chronos.calc.tributacoes.TributacaoDifal;
import com.chronos.calc.tributacoes.TributacaoIbpt;
import com.chronos.calc.tributacoes.TributacaoIcms;
import com.chronos.calc.tributacoes.TributacaoIcmsSt;
import com.chronos.calc.tributacoes.TributacaoIpi;
import com.chronos.calc.tributacoes.TributacaoIssqn;
import com.chronos.calc.tributacoes.TributacaoPis;

/**
 *
 * @author John Vanderson M L
 */
public class CalcTributacao {

    private final ITributavel tributos;
    private final TipoDesconto desconto;

    public CalcTributacao(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        this.desconto = desconto;
    }
     public CalcTributacao(ITributavel tributos) {
        this.tributos = tributos;
        this.desconto = TipoDesconto.Incondicional;
    }

    public IResultadoCalculoIcms calcularIcms() {
        return new TributacaoIcms(tributos, desconto).calcular();
    }

    public IResultadoCalculoIpi calcularIpi() {
        return new TributacaoIpi(tributos, desconto).calcular();
    }

    public IResultadoCalculoCredito calcularIcmsCredito() {
        return new TributacaoCreditoIcms(tributos, desconto).Calcula();
    }

    public IResultadoCalculoCofins calcularCofins() {
        return new TributacaoCofins(tributos, desconto).calcular();
    }

    public IResultadoCalculoPis calcularPis() {
        return new TributacaoPis(tributos, desconto).calcular();
    }

    public IResultadoCalculoIssqn calcularIssqn(){
        return new TributacaoIssqn(tributos,desconto).calcular();
    }
    
    public IResultadoCalculoDifal calculaDifalFcp() {
        return new TributacaoDifal(tributos, desconto).Calcula();
    }

    public IResultadoCalculoIcmsSt calcularIcmsSt() {
        return new TributacaoIcmsSt(tributos, desconto).calcular();
    }

    public IResultadoCalculoIbpt calculaIbpt(Ibpt ibpt) {
        return new TributacaoIbpt(tributos, ibpt).calcular();
    }
}
