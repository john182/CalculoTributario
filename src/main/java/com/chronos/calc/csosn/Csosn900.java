/* 
 * The MIT License
 *
 * Copyright 2017 Chronusinfo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.chronos.calc.csosn;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Icms;
import com.chronos.calc.enuns.Csosn;
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
public class Csosn900 extends CsosnBase {

    private ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt;
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

    public Csosn900() {
        this.csosn = Csosn.Csosn900;
        this.modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
    }

    public Csosn900(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        this.csosn = Csosn.Csosn900;
        this.modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
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
        percentualIcms = tributos.getPercentualIcms();

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

    @Override
    public Icms getIcmsDto() {
        Icms icms = super.getIcmsDto();
        icms.setPercentualCredito(getPercentualCredito());
        icms.setValorCredito(getValorCredito());
        icms.setValorIcms(getValorIcms());
        icms.setValorBcIcms(getValorBcIcms());
        icms.setPercentualMva(getPercentualMva());
        icms.setPercentualIcmsST(getPercentualIcmsSt());
        icms.setPercentualReducaoST(getPercentualReducaoSt());
        icms.setValorIcmsST(getValorIcmsSt());
        icms.setValorBaseCalcST(getValorBcIcmsSt());

        return icms;
    }

}
