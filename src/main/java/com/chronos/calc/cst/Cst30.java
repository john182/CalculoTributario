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
import com.chronos.calc.enuns.ModalidadeDeterminacaoBcIcmsSt;
import com.chronos.calc.enuns.OrigemMercadoria;
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Cst30 extends CstBase {

    private ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt;
    private BigDecimal percentualMva;
    private BigDecimal percentualReducaoSt;
    private BigDecimal valorBcIcmsSt;
    private BigDecimal percentualIcmsSt;
    private BigDecimal valorIcmsSt;

    public Cst30() {
        cst = Cst.Cst30;
        modalidadeDeterminacaoBcIcmsSt = ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado;
    }

    public Cst30(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        cst = Cst.Cst30;
    }

    @Override
    public void calcular(ITributavel tributos) {
        if (ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado.equals(getModalidadeDeterminacaoBcIcmsSt())) {
            percentualMva = tributos.getPercentualMva().setScale(2);
            percentualReducaoSt = tributos.getPercentualReducaoSt().setScale(2);
            percentualIcmsSt = tributos.getPercentualIcmsSt().setScale(2);

            CalcTributacao calc = new CalcTributacao(tributos);

            tributos.setValorIpi(calc.calcularIpi().getValor());

            IResultadoCalculoIcmsSt result = calc.calcularIcmsSt();

            valorBcIcmsSt = result.getBaseCalculoIcmsSt();
            valorIcmsSt = result.getValorIcmsSt();
        }

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

    public ModalidadeDeterminacaoBcIcmsSt getModalidadeDeterminacaoBcIcmsSt() {
        return modalidadeDeterminacaoBcIcmsSt;
    }

    public void setModalidadeDeterminacaoBcIcmsSt(ModalidadeDeterminacaoBcIcmsSt modalidadeDeterminacaoBcIcmsSt) {
        this.modalidadeDeterminacaoBcIcmsSt = modalidadeDeterminacaoBcIcmsSt;
    }

    @Override
    public Icms getIcmsDto() {
        Icms icmsDto = new Icms();

        icmsDto.setPercentualMva(getPercentualMva());
        icmsDto.setPercentualReducaoST(getPercentualReducaoSt());
        icmsDto.setValorBaseCalcST(getValorBcIcmsSt());
        icmsDto.setPercentualIcmsST(getPercentualIcmsSt());
        icmsDto.setValorIcmsST(getValorIcmsSt());

        return icmsDto;

    }

}
