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
package com.chronos.calc.cst;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Icms;
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
        if (ModalidadeDeterminacaoBcIcms.ValorOperacao.equals(getModalidadeDeterminacaoBcIcms())) {
            CalcTributacao calc = new CalcTributacao(tributos);
            IResultadoCalculoIcms result = calc.calcularIcms();
            percentualReducao = tributos.getPercentualReducao().setScale(2);
            valorBcIcms = result.getBaseCalculo().setScale(2);
            percentualIcms = tributos.getPercentualIcms().setScale(2);
            valorIcmsOperacao = valorBcIcms.multiply(percentualIcms).divide(BigDecimal.valueOf(100)).setScale(2);
            percentualDiferimento = tributos.getPercentualDiferimento();
            valorIcmsDiferido = percentualDiferimento.multiply(valorIcmsOperacao.divide(BigDecimal.valueOf(100))).setScale(2, RoundingMode.UP);
            valorIcms = valorIcmsOperacao.subtract(valorIcmsDiferido).setScale(2);
        }
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

    @Override
    public Icms getIcmsDto() {
        Icms icmsDto = new Icms();

        icmsDto.setPercentualReducao(percentualReducao);
        icmsDto.setValorBcIcms(valorBcIcms);
        icmsDto.setPercentualIcms(percentualIcms);
        icmsDto.setValorIcmsOperacao(valorIcmsOperacao);
        icmsDto.setPercentualDiferimento(percentualDiferimento);
        icmsDto.setValorIcmsDeferido(valorIcmsDiferido);
        icmsDto.setValorIcms(valorIcms);

        return icmsDto;
    }

}
