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
package com.chronos.calc.dto;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Imposto {

    private Icms icms;
    private Ipi ipi;
    private Pis pis;
    private Cofins cofins;
    private Iss issqn;
    private BigDecimal tributacaoEstadual;
    private BigDecimal tributacaoFederal;
    private BigDecimal tributacaoFederalImp;
    private BigDecimal tributacaoMunicipal;
    private BigDecimal valorTotalTributos;

    public Imposto() {
    }

    public Icms getIcms() {
        return icms;
    }

    public void setIcms(Icms icms) {
        this.icms = icms;
    }

    public Ipi getIpi() {
        return ipi;
    }

    public void setIpi(Ipi ipi) {
        this.ipi = ipi;
    }

    public Pis getPis() {
        return pis;
    }

    public void setPis(Pis pis) {
        this.pis = pis;
    }

    public Cofins getCofins() {
        return cofins;
    }

    public void setCofins(Cofins cofins) {
        this.cofins = cofins;
    }

    public Iss getIssqn() {
        return issqn;
    }

    public void setIssqn(Iss issqn) {
        this.issqn = issqn;
    }

    public BigDecimal getTributacaoEstadual() {
        return tributacaoEstadual;
    }

    public void setTributacaoEstadual(BigDecimal tributacaoEstadual) {
        this.tributacaoEstadual = tributacaoEstadual;
    }

    public BigDecimal getTributacaoFederal() {
        return tributacaoFederal;
    }

    public void setTributacaoFederal(BigDecimal tributacaoFederal) {
        this.tributacaoFederal = tributacaoFederal;
    }

    public BigDecimal getTributacaoFederalImp() {
        return tributacaoFederalImp;
    }

    public void setTributacaoFederalImp(BigDecimal tributacaoFederalImp) {
        this.tributacaoFederalImp = tributacaoFederalImp;
    }

    public BigDecimal getTributacaoMunicipal() {
        return tributacaoMunicipal;
    }

    public void setTributacaoMunicipal(BigDecimal tributacaoMunicipal) {
        this.tributacaoMunicipal = tributacaoMunicipal;
    }

    public BigDecimal getValorTotalTributos() {
        return valorTotalTributos;
    }

    public void setValorTotalTributos(BigDecimal valorTotalTributos) {
        this.valorTotalTributos = valorTotalTributos;
    }

}
