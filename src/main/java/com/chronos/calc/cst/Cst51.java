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
import com.chronos.calc.enuns.OrigemMercadoria;
import com.chronos.calc.resultados.IResultadoCalculoIcms;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class Cst51 extends CstBase {

    private ModalidadeDeterminacaoBcIcms modalidadeDeterminacaoBcIcms;
    private BigDecimal percentualDiferimento;
    private BigDecimal valorIcmsDiferido;
    private BigDecimal valorIcmsOperacao;
    private BigDecimal percentualIcms;
    private BigDecimal percentualReducao;
    private BigDecimal valorBcIcms;
    private BigDecimal valorIcms;

    public Cst51() {
        cst = Cst.Cst50;
        modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms.ValorOperacao;
    }

    public Cst51(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        cst = Cst.Cst50;
        modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms.ValorOperacao;
    }

    @Override
    public void calcular(ITributavel tributos) {
        CalcTributacao calc = new CalcTributacao(tributos);
        IResultadoCalculoIcms result = calc.calcularIcms();
        percentualReducao = tributos.getPercentualReducao().setScale(2);
        valorBcIcms = result.getBaseCalculo().setScale(2);
        percentualIcms = tributos.getPercentualIcms().setScale(2);
        valorIcmsOperacao = valorBcIcms.multiply(percentualIcms).divide(BigDecimal.valueOf(100)).setScale(2);
        percentualDiferimento = tributos.getPercentualDiferimento();
        valorIcmsDiferido = percentualDiferimento.multiply(valorIcmsOperacao.divide(BigDecimal.valueOf(100))).setScale(2,RoundingMode.UP);
        valorIcms = valorIcmsOperacao.subtract(valorIcmsDiferido).setScale(2);
    }

    public ModalidadeDeterminacaoBcIcms getModalidadeDeterminacaoBcIcms() {
        return modalidadeDeterminacaoBcIcms;
    }

    public void setModalidadeDeterminacaoBcIcms(ModalidadeDeterminacaoBcIcms modalidadeDeterminacaoBcIcms) {
        this.modalidadeDeterminacaoBcIcms = modalidadeDeterminacaoBcIcms;
    }

    public BigDecimal getPercentualDiferimento() {
        return percentualDiferimento;
    }

    public BigDecimal getValorIcmsDiferido() {
        return valorIcmsDiferido;
    }

    public BigDecimal getValorIcmsOperacao() {
        return valorIcmsOperacao;
    }

    public BigDecimal getPercentualIcms() {
        return percentualIcms;
    }

    public BigDecimal getPercentualReducao() {
        return percentualReducao;
    }

    public BigDecimal getValorBcIcms() {
        return valorBcIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

}
