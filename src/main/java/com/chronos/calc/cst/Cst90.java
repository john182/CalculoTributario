/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.cst;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.ModalidadeDeterminacaoBcIcms;
import com.chronos.calc.enuns.ModalidadeDeterminacaoBcIcmsSt;
import com.chronos.calc.enuns.OrigemMercadoria;
import com.chronos.calc.resultados.IResultadoCalculoCredito;
import com.chronos.calc.resultados.IResultadoCalculoIcms;
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Cst90 extends CstBase {

    private ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt;
    private ModalidadeDeterminacaoBcIcms modalidadeDeterminacaoBcIcms;
    private BigDecimal percentualCredito;
    private BigDecimal valorCredito;
    private BigDecimal percentualMva;
    private BigDecimal percentualReducaoSt;
    private BigDecimal valorBcIcmsSt;
    private BigDecimal percentualIcmsSt;
    private BigDecimal valorIcmsSt;
    private BigDecimal percentualReducaoIcmsBc;
    private BigDecimal percentualIcms;
    private BigDecimal valorBcIcms;
    private BigDecimal valorIcms;

    public Cst90() {
        modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms.ValorOperacao;
        modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
        cst = Cst.Cst90;
    }

    public Cst90(OrigemMercadoria OrigemMercadoria) {
        super(OrigemMercadoria);
        modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms.ValorOperacao;
        modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
    }

    @Override
    public void calcular(ITributavel tributos) {
        calcularIcms(tributos);
        calcularCredito(tributos);
        calculatIcmsSt(tributos);
    }

    private void calcularCredito(ITributavel tributos) {
        IResultadoCalculoCredito result = new CalcTributacao(tributos).calcularIcmsCredito();
        percentualCredito = tributos.getPercentualCredito().setScale(2);
        valorCredito = result.getValor().setScale(2);
    }

    private void calculatIcmsSt(ITributavel tributos) {
        percentualMva = tributos.getPercentualMva().setScale(2);
        percentualReducaoSt = tributos.getPercentualReducaoSt().setScale(2);
        percentualIcmsSt = tributos.getPercentualIcmsSt().setScale(2);

        CalcTributacao calcular = new CalcTributacao(tributos);

        tributos.setValorIpi(calcular.calcularIpi().getValor());

        IResultadoCalculoIcmsSt resultado = calcular.calcularIcmsSt();

        valorBcIcmsSt = resultado.getBaseCalculoIcmsSt();
        valorIcmsSt = resultado.getValorIcmsSt();
    }

    private void calcularIcms(ITributavel tributos) {
        percentualReducaoIcmsBc = tributos.getPercentualReducao();
        percentualIcms = tributos.getPercentualIcms().setScale(2);

        CalcTributacao calcular = new CalcTributacao(tributos);

        tributos.setValorIpi(calcular.calcularIpi().getValor());

        IResultadoCalculoIcms result = calcular.calcularIcms();
        valorBcIcms = result.getBaseCalculo();
        valorIcms = result.getValor();
    }

    public ModalidadeDeterminacaoBcIcmsSt getModalidadeDeterminacaoBcIcmsSt() {
        return modalidadeDeterminacaoBcIcmsSt;
    }

    public void setModalidadeDeterminacaoBcIcmsSt(ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt) {
        this.modalidadeDeterminacaoBcIcmsSt = modalidadeDeterminacaoBcIcmsSt;
    }

    public BigDecimal getPercentualCredito() {
        return percentualCredito;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public BigDecimal getPercentualMva() {
        return percentualMva;
    }

    public BigDecimal getPercentualReducaoSt() {
        return percentualReducaoSt;
    }

    public BigDecimal getValorBcIcmsSt() {
        return valorBcIcmsSt;
    }

    public BigDecimal getPercentualIcmsSt() {
        return percentualIcmsSt;
    }

    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

    public BigDecimal getPercentualReducaoIcmsBc() {
        return percentualReducaoIcmsBc;
    }

    public BigDecimal getPercentualIcms() {
        return percentualIcms;
    }

    public BigDecimal getValorBcIcms() {
        return valorBcIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public ModalidadeDeterminacaoBcIcms getModalidadeDeterminacaoBcIcms() {
        return modalidadeDeterminacaoBcIcms;
    }

    public void setModalidadeDeterminacaoBcIcms(ModalidadeDeterminacaoBcIcms modalidadeDeterminacaoBcIcms) {
        this.modalidadeDeterminacaoBcIcms = modalidadeDeterminacaoBcIcms;
    }

}
