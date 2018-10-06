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
package com.chronos.calc;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.dto.Ibpt;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.*;
import com.chronos.calc.tributacoes.*;

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
        return new TributacaoCreditoIcms(tributos, desconto).calcular();
    }

    public IResultadoCalculoCofins calcularCofins() {
        return new TributacaoCofins(tributos, desconto).calcular();
    }

    public IResultadoCalculoPis calcularPis() {
        return new TributacaoPis(tributos, desconto).calcular();
    }

    public IResultadoCalculoIssqn calcularIssqn(boolean calcularRetencao) {
        return new TributacaoIssqn(tributos, desconto).calcular(calcularRetencao);
    }

    public IResultadoCalculoDifal calculaDifalFcp() {
        return new TributacaoDifal(tributos, desconto).calcular();
    }

    public IResultadoCalculoFcp calcularFcp() {
        return new TributacaoFcp(tributos, desconto).calcular();
    }

    public IResultadoCalculoFcpSt calcularFcpSt() {
        return new TributacaoFcpSt(tributos, desconto).calcular();
    }


    public IResultadoCalculoIcmsSt calcularIcmsSt() {
        return new TributacaoIcmsSt(tributos, desconto).calcular();
    }

    public IResultadoCalculoIbpt calculaIbpt(Ibpt ibpt) {
        return new TributacaoIbpt(tributos, ibpt).calcular();
    }
}
