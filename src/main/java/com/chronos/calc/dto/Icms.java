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
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class Icms {

    private String cst;

    private BigDecimal valorCredito;
    private BigDecimal percentualCredito;
    private BigDecimal percentualReducao;

    private BigDecimal valorIcms;
    private BigDecimal valorBcIcms;
    private BigDecimal percentualIcms;

    private BigDecimal percentualMva;
    private BigDecimal percentualIcmsST;
    private BigDecimal percentualReducaoST;
    private BigDecimal valorIcmsST;
    private BigDecimal valorBaseCalcST;

    private BigDecimal percentualDiferimento;
    private BigDecimal valorIcmsOperacao;
    private BigDecimal valorIcmsDeferido;

    private BigDecimal valorBcDifal;
    private BigDecimal difal;
    private BigDecimal fcp;
    private BigDecimal valorIcmsDestino;
    private BigDecimal valorIcmsOrigem;
    private String obsDifal;

    public Icms() {
    }

    public BigDecimal getValorCredito() {
        return Optional.ofNullable(valorCredito).orElse(BigDecimal.ZERO);
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getPercentualCredito() {
        return Optional.ofNullable(percentualCredito).orElse(BigDecimal.ZERO);
    }

    public void setPercentualCredito(BigDecimal percentualCredito) {
        this.percentualCredito = percentualCredito;
    }

    public BigDecimal getPercentualMva() {
        return Optional.ofNullable(percentualMva).orElse(BigDecimal.ZERO);
    }

    public void setPercentualMva(BigDecimal percentualMva) {
        this.percentualMva = percentualMva;
    }

    public BigDecimal getPercentualIcmsST() {
        return Optional.ofNullable(percentualIcmsST).orElse(BigDecimal.ZERO);
    }

    public void setPercentualIcmsST(BigDecimal percentualIcmsST) {
        this.percentualIcmsST = percentualIcmsST;
    }

    public BigDecimal getPercentualReducaoST() {
        return Optional.ofNullable(percentualReducaoST).orElse(BigDecimal.ZERO);
    }

    public void setPercentualReducaoST(BigDecimal percentualReducaoST) {
        this.percentualReducaoST = percentualReducaoST;
    }

    public BigDecimal getValorIcmsST() {
        return Optional.ofNullable(valorIcmsST).orElse(BigDecimal.ZERO);
    }

    public void setValorIcmsST(BigDecimal valorIcmsST) {
        this.valorIcmsST = valorIcmsST;
    }

    public BigDecimal getValorBaseCalcST() {
        return Optional.ofNullable(valorBaseCalcST).orElse(BigDecimal.ZERO);
    }

    public void setValorBaseCalcST(BigDecimal valorBaseCalcST) {
        this.valorBaseCalcST = valorBaseCalcST;
    }

    public BigDecimal getValorIcms() {
        return Optional.ofNullable(valorIcms).orElse(BigDecimal.ZERO);
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getValorBcIcms() {
        return Optional.ofNullable(valorBcIcms).orElse(BigDecimal.ZERO);
    }

    public void setValorBcIcms(BigDecimal valorBcIcms) {
        this.valorBcIcms = valorBcIcms;
    }

    public BigDecimal getPercentualIcms() {
        return Optional.ofNullable(percentualIcms).orElse(BigDecimal.ZERO);
    }

    public void setPercentualIcms(BigDecimal percentualIcms) {
        this.percentualIcms = percentualIcms;
    }

    public BigDecimal getPercentualReducao() {
        return Optional.ofNullable(percentualReducao).orElse(BigDecimal.ZERO);
    }

    public void setPercentualReducao(BigDecimal percentualReducao) {
        this.percentualReducao = percentualReducao;
    }

    public BigDecimal getPercentualDiferimento() {
        return Optional.ofNullable(percentualDiferimento).orElse(BigDecimal.ZERO);
    }

    public void setPercentualDiferimento(BigDecimal percentualDiferimento) {
        this.percentualDiferimento = percentualDiferimento;
    }

    public BigDecimal getValorIcmsOperacao() {
        return Optional.ofNullable(valorIcmsOperacao).orElse(BigDecimal.ZERO);
    }

    public void setValorIcmsOperacao(BigDecimal valorIcmsOperacao) {
        this.valorIcmsOperacao = valorIcmsOperacao;
    }

    public BigDecimal getValorIcmsDeferido() {
        return Optional.ofNullable(valorIcmsDeferido).orElse(BigDecimal.ZERO);
    }

    public void setValorIcmsDeferido(BigDecimal valorIcmsDeferido) {
        this.valorIcmsDeferido = valorIcmsDeferido;
    }

    public BigDecimal getValorBcDifal() {
        return Optional.ofNullable(valorBcDifal).orElse(BigDecimal.ZERO);
    }

    public void setValorBcDifal(BigDecimal valorBcDifal) {
        this.valorBcDifal = valorBcDifal;
    }

    public BigDecimal getDifal() {
        return Optional.ofNullable(difal).orElse(BigDecimal.ZERO);
    }

    public void setDifal(BigDecimal difal) {
        this.difal = difal;
    }

    public BigDecimal getFcp() {
        return Optional.ofNullable(fcp).orElse(BigDecimal.ZERO);
    }

    public void setFcp(BigDecimal fcp) {
        this.fcp = fcp;
    }

    public BigDecimal getValorIcmsDestino() {
        return Optional.ofNullable(valorIcmsDestino).orElse(BigDecimal.ZERO);
    }

    public void setValorIcmsDestino(BigDecimal valorIcmsDestino) {
        this.valorIcmsDestino = valorIcmsDestino;
    }

    public BigDecimal getValorIcmsOrigem() {
        return Optional.ofNullable(valorIcmsOrigem).orElse(BigDecimal.ZERO);
    }

    public void setValorIcmsOrigem(BigDecimal valorIcmsOrigem) {
        this.valorIcmsOrigem = valorIcmsOrigem;
    }

    public String getObsDifal() {
        return obsDifal;
    }

    public void setObsDifal(String obsDifal) {
        this.obsDifal = obsDifal;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }
}
