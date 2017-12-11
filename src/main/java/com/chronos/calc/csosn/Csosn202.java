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
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import java.math.BigDecimal;

/**
 * Tributada pelo Simples Nacional sem permissão de crédito 
 * e com cobrança do ICMS por substituição tributária    
 * @author John Vanderson M L
 */
public class Csosn202 extends Csosn102 {

    protected ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt;
    private BigDecimal percentualMva;
    private BigDecimal percentualReducaoSt;
    private BigDecimal valorBcIcmsSt;
    private BigDecimal percentualIcmsSt;
    private BigDecimal valorIcmsSt;

    public Csosn202() {
        this.csosn = Csosn.Csosn202;
        this.modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
    }

    public Csosn202(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        this.csosn = Csosn.Csosn202;
        this.modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
    }

    @Override
    public void calcular(ITributavel tributos) {

        percentualMva = tributos.getPercentualMva().setScale(2);
        percentualReducaoSt = tributos.getPercentualReducaoSt().setScale(2);
        percentualIcmsSt = tributos.getPercentualIcmsSt().setScale(2);

        CalcTributacao calcular = new CalcTributacao(tributos);

        tributos.setValorIpi(calcular.calcularIpi().getValor());

        IResultadoCalculoIcmsSt resultado = calcular.calcularIcmsSt();

        valorBcIcmsSt = resultado.getBaseCalculoIcmsSt();
        valorIcmsSt = resultado.getValorIcmsSt();
    }

    public ModalidadeDeterminacaoBcIcmsSt getModalidadeDeterminacaoBcIcmsSt() {
        return modalidadeDeterminacaoBcIcmsSt;
    }

    public void setModalidadeDeterminacaoBcIcmsSt(ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt) {
        this.modalidadeDeterminacaoBcIcmsSt = modalidadeDeterminacaoBcIcmsSt;
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

    @Override
    public Icms getIcmsDto() {
        Icms icms = super.getIcmsDto();
        switch (getModalidadeDeterminacaoBcIcmsSt()) {
            case ListaNegativa:
                //lista Negativa(valor)
                break;
            case ListaPositiva:
                //Lista Positiva(valor)
                break;
            case ListaNeutra:
                //Lista Neutra(valor)
                break;
            case MargemValorAgregado:
                //Margem valor Agregado(%)

                icms.setPercentualMva(getPercentualMva());
                icms.setPercentualIcmsST(getPercentualIcmsSt());
                icms.setPercentualReducaoST(getPercentualReducaoSt());
                icms.setValorIcmsST(getValorIcmsSt());
                icms.setValorBaseCalcST(getValorBcIcmsSt());

                break;
            case Pauta:

                break;
            case PrecoTabeladoOuMaximoSugerido:
                //Preço Tabelado ou Máximo Sugerido
                break;
        }

        return icms;
    }

}
