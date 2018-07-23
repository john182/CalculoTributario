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
        if (ModalidadeDeterminacaoBcIcms.ValorOperacao.equals(getModalidadeDeterminacaoBcIcms())) {
            IResultadoCalculoIcms result = new CalcTributacao(tributos).calcularIcms();
            this.percentualIcms = tributos.getPercentualIcms().setScale(2);
            this.valorBcIcms = result.getBaseCalculo();
            this.valorIcms = result.getValor();
        }
    }

    public ModalidadeDeterminacaoBcIcms getModalidadeDeterminacaoBcIcms() {
        return modalidadeDeterminacaoBcIcms;
    }

    public void setModalidadeDeterminacaoBcIcms(ModalidadeDeterminacaoBcIcms modalidadeDeterminacaoBcIcms) {
        this.modalidadeDeterminacaoBcIcms = modalidadeDeterminacaoBcIcms;
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

    @Override
    public Icms getIcmsDto() {
        Icms icms = new Icms();
        icms.setValorIcms(valorIcms);
        icms.setValorBcIcms(valorBcIcms);
        icms.setPercentualIcms(percentualIcms);

        return icms;

    }
}
