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

import com.chronos.calc.TributacaoException;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Icms;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.OrigemMercadoria;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class Cst70 extends Cst10 {

    @Override
    public Icms getIcmsDto() {
        Icms icms = super.getIcmsDto();

        icms.setPercentualReducao(getPercentualReducao());
        icms.setValorBcIcms(getValorBcIcms());
        icms.setPercentualIcms(getPercentualIcms());
        icms.setValorIcms(getValorIcms());

        icms.setPercentualMva(getPercentualMva());
        icms.setPercentualReducaoST(getPercentualReducaoSt());
        icms.setValorBaseCalcST(getValorBcIcmsSt());
        icms.setPercentualIcmsST(getPercentualIcmsSt());
        icms.setValorIcmsST(getValorIcmsSt());

        return icms;
    }

    private BigDecimal percentualReducao;

    public Cst70() {
        cst = Cst.Cst70;
    }

    public Cst70(OrigemMercadoria origemMercadoria) {
        super(origemMercadoria);
        cst = Cst.Cst70;
    }

    @Override
    public void calcular(ITributavel tributos) throws TributacaoException {
        super.calcular(tributos);
        percentualReducao = tributos.getPercentualReducao().setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPercentualReducao() {
        return percentualReducao;
    }

}
