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

/**
 *
 * @author John Vanderson M L
 */
public class Cst00 extends CstBase {

    private ModalidadeDeterminacaoBcIcms modalidadeDeterminacaoBcIcms;
    private BigDecimal valorBcIcms;
    private BigDecimal percentualIcms;
    private BigDecimal valorIcms;

    public Cst00() {
        this.origemMercadoria = OrigemMercadoria.Nacional;
        this.cst = Cst.Cst00;
        modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms.ValorOperacao;
    }

    public Cst00(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        this.cst = Cst.Cst00;
        modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms.ValorOperacao;
    }

    @Override
    public void calcular(ITributavel tributos) {
        validacaoPadrao(tributos);
        IResultadoCalculoIcms result = new CalcTributacao(tributos).calcularIcms();
        this.percentualIcms = tributos.getPercentualIcms().setScale(2);
        this.valorBcIcms = result.getBaseCalculo();
        this.valorIcms = result.getValor();
    }

    public ModalidadeDeterminacaoBcIcms getModalidadeDeterminacaoBcIcms() {
        return modalidadeDeterminacaoBcIcms;
    }

    public void setModalidadeDeterminacaoBcIcms(ModalidadeDeterminacaoBcIcms ModalidadeDeterminacaoBcIcms) {
        this.modalidadeDeterminacaoBcIcms = ModalidadeDeterminacaoBcIcms;
    }

    public BigDecimal getValorBcIcms() {
        return valorBcIcms;
    }

    public BigDecimal getPercentualIcms() {
        return percentualIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

}
