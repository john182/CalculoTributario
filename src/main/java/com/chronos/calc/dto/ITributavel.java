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
import java.math.RoundingMode;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class ITributavel extends Ibpt {

    private BigDecimal valorProduto;
    private BigDecimal frete;
    private BigDecimal seguro;
    private BigDecimal outrasDespesas;
    private BigDecimal desconto;
    private BigDecimal valorIpi;
    private BigDecimal percentualReducao;
    private BigDecimal quantidadeProduto;
    private BigDecimal percentualIcms;
    private BigDecimal percentualCredito;
    private BigDecimal percentualDifalInterna;
    private BigDecimal percentualDifalInterestadual;
    private BigDecimal percentualFcp;
    private BigDecimal percentualFcpSt;
    private BigDecimal percentualMva;
    private BigDecimal percentualIcmsSt;
    private BigDecimal percentualIpi;
    private BigDecimal percentualCofins;
    private BigDecimal percentualCofinsRais;
    private BigDecimal percentualPis;
    private BigDecimal percentualPisReais;
    private BigDecimal percentualReducaoSt;
    private BigDecimal percentualDiferimento;
    private BigDecimal percentualIssqn;
    private BigDecimal percentualRetPis;
    private BigDecimal percentualRetCofins;
    private BigDecimal percentualRetIrrf;
    private BigDecimal percentualRetInss;
    private BigDecimal percentualRetCsll;

    public ITributavel() {
    }

    public BigDecimal getTotalProduto() {
        BigDecimal total = getQuantidadeProduto().multiply(getValorProduto()).subtract(getDesconto());
        total = total.setScale(2, RoundingMode.DOWN);
        return total;
    }

    public BigDecimal getValorProduto() {
        return Optional.ofNullable(valorProduto).orElse(BigDecimal.ZERO);
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getSeguro() {
        return seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    public BigDecimal getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(BigDecimal outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    public BigDecimal getDesconto() {
        return Optional.ofNullable(desconto).orElse(BigDecimal.ZERO);
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public BigDecimal getPercentualReducao() {
        return Optional.ofNullable(percentualReducao).orElse(BigDecimal.ZERO);
    }

    public void setPercentualReducao(BigDecimal percentualReducao) {
        this.percentualReducao = percentualReducao;
    }

    public BigDecimal getQuantidadeProduto() {
        return Optional.ofNullable(quantidadeProduto).orElse(BigDecimal.ZERO);
    }

    public void setQuantidadeProduto(BigDecimal quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getPercentualIcms() {
        return Optional.ofNullable(percentualIcms).orElse(BigDecimal.ZERO);
    }

    public void setPercentualIcms(BigDecimal percentualIcms) {
        this.percentualIcms = percentualIcms;
    }

    public BigDecimal getPercentualCredito() {
        return Optional.ofNullable(percentualCredito).orElse(BigDecimal.ZERO);
    }

    public void setPercentualCredito(BigDecimal percentualCredito) {
        this.percentualCredito = percentualCredito;
    }

    public BigDecimal getPercentualDifalInterna() {
        return Optional.ofNullable(percentualDifalInterna).orElse(BigDecimal.ZERO);
    }

    public void setPercentualDifalInterna(BigDecimal percentualDifalInterna) {
        this.percentualDifalInterna = percentualDifalInterna;
    }

    public BigDecimal getPercentualDifalInterestadual() {
        return Optional.ofNullable(percentualDifalInterestadual).orElse(BigDecimal.ZERO);
    }

    public void setPercentualDifalInterestadual(BigDecimal percentualDifalInterestadual) {
        this.percentualDifalInterestadual = percentualDifalInterestadual;
    }

    public BigDecimal getPercentualFcp() {
        return percentualFcp;
    }

    public BigDecimal getPercentualFcpSt() {
        return percentualFcpSt;
    }

    public void setPercentualFcpSt(BigDecimal percentualFcpSt) {
        this.percentualFcpSt = percentualFcpSt;
    }

    public void setPercentualFcp(BigDecimal percentualFcp) {
        this.percentualFcp = percentualFcp;
    }

    public BigDecimal getPercentualMva() {
        return Optional.ofNullable(percentualMva).orElse(BigDecimal.ZERO);
    }

    public void setPercentualMva(BigDecimal percentualMva) {
        this.percentualMva = percentualMva;
    }

    public BigDecimal getPercentualIcmsSt() {
        return Optional.ofNullable(percentualIcmsSt).orElse(BigDecimal.ZERO);
    }

    public void setPercentualIcmsSt(BigDecimal percentualIcmsSt) {
        this.percentualIcmsSt = percentualIcmsSt;
    }

    public BigDecimal getPercentualIpi() {
        return Optional.ofNullable(percentualIpi).orElse(BigDecimal.ZERO);
    }

    public void setPercentualIpi(BigDecimal percentualIpi) {
        this.percentualIpi = percentualIpi;
    }

    public BigDecimal getPercentualCofins() {
        return Optional.ofNullable(percentualCofins).orElse(BigDecimal.ZERO);
    }

    public void setPercentualCofins(BigDecimal percentualCofins) {
        this.percentualCofins = percentualCofins;
    }

    public BigDecimal getPercentualPis() {
        return Optional.ofNullable(percentualPis).orElse(BigDecimal.ZERO);
    }

    public void setPercentualPis(BigDecimal percentualPis) {
        this.percentualPis = percentualPis;
    }

    public BigDecimal getPercentualReducaoSt() {
        return Optional.ofNullable(percentualReducaoSt).orElse(BigDecimal.ZERO);
    }

    public void setPercentualReducaoSt(BigDecimal percentualReducaoSt) {
        this.percentualReducaoSt = percentualReducaoSt;
    }

    public BigDecimal getPercentualDiferimento() {
        return Optional.ofNullable(percentualDiferimento).orElse(BigDecimal.ZERO);
    }

    public void setPercentualDiferimento(BigDecimal percentualDiferimento) {
        this.percentualDiferimento = percentualDiferimento;
    }

    public BigDecimal getPercentualIssqn() {
        return percentualIssqn;
    }

    public void setPercentualIssqn(BigDecimal percentualIssqn) {
        this.percentualIssqn = percentualIssqn;
    }

    public BigDecimal getPercentualPisReais() {
        return percentualPisReais;
    }

    public void setPercentualPisReais(BigDecimal percentualPisReais) {
        this.percentualPisReais = percentualPisReais;
    }

    public BigDecimal getPercentualCofinsRais() {
        return percentualCofinsRais;
    }

    public void setPercentualCofinsRais(BigDecimal percentualCofinsRais) {
        this.percentualCofinsRais = percentualCofinsRais;
    }

    public BigDecimal getPercentualRetPis() {
        return Optional.ofNullable(percentualRetPis).orElse(BigDecimal.ZERO);
    }

    public void setPercentualRetPis(BigDecimal percentualRetPis) {
        this.percentualRetPis = percentualRetPis;
    }

    public BigDecimal getPercentualRetCofins() {
        return Optional.ofNullable(percentualRetCofins).orElse(BigDecimal.ZERO);
    }

    public void setPercentualRetCofins(BigDecimal percentualRetCofins) {
        this.percentualRetCofins = percentualRetCofins;
    }

    public BigDecimal getPercentualRetIrrf() {
        return Optional.ofNullable(percentualRetIrrf).orElse(BigDecimal.ZERO);
    }

    public void setPercentualRetIrrf(BigDecimal percentualRetIrrf) {
        this.percentualRetIrrf = percentualRetIrrf;
    }

    public BigDecimal getPercentualRetInss() {
        return Optional.ofNullable(percentualRetInss).orElse(BigDecimal.ZERO);
    }

    public void setPercentualRetInss(BigDecimal percentualRetInss) {
        this.percentualRetInss = percentualRetInss;
    }

    public BigDecimal getPercentualRetCsll() {
        return Optional.ofNullable(percentualRetCsll).orElse(BigDecimal.ZERO);
    }

    public void setPercentualRetCsll(BigDecimal percentualRetCsll) {
        this.percentualRetCsll = percentualRetCsll;
    }

}
