/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.dto;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class Icms {

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

    private BigDecimal tributacaoEstadual;
    private BigDecimal tributacaoFederal;
    private BigDecimal tributacaoFederalImp;
    private BigDecimal tributacaoMunicipal;

    public Icms() {
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getPercentualCredito() {
        return percentualCredito;
    }

    public void setPercentualCredito(BigDecimal percentualCredito) {
        this.percentualCredito = percentualCredito;
    }

    public BigDecimal getPercentualMva() {
        return percentualMva;
    }

    public void setPercentualMva(BigDecimal percentualMva) {
        this.percentualMva = percentualMva;
    }

    public BigDecimal getPercentualIcmsST() {
        return percentualIcmsST;
    }

    public void setPercentualIcmsST(BigDecimal percentualIcmsST) {
        this.percentualIcmsST = percentualIcmsST;
    }

    public BigDecimal getPercentualReducaoST() {
        return percentualReducaoST;
    }

    public void setPercentualReducaoST(BigDecimal percentualReducaoST) {
        this.percentualReducaoST = percentualReducaoST;
    }

    public BigDecimal getValorIcmsST() {
        return valorIcmsST;
    }

    public void setValorIcmsST(BigDecimal valorIcmsST) {
        this.valorIcmsST = valorIcmsST;
    }

    public BigDecimal getValorBaseCalcST() {
        return valorBaseCalcST;
    }

    public void setValorBaseCalcST(BigDecimal valorBaseCalcST) {
        this.valorBaseCalcST = valorBaseCalcST;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getValorBcIcms() {
        return valorBcIcms;
    }

    public void setValorBcIcms(BigDecimal valorBcIcms) {
        this.valorBcIcms = valorBcIcms;
    }

    public BigDecimal getPercentualIcms() {
        return percentualIcms;
    }

    public void setPercentualIcms(BigDecimal percentualIcms) {
        this.percentualIcms = percentualIcms;
    }

    public BigDecimal getPercentualReducao() {
        return percentualReducao;
    }

    public void setPercentualReducao(BigDecimal percentualReducao) {
        this.percentualReducao = percentualReducao;
    }

    public BigDecimal getPercentualDiferimento() {
        return percentualDiferimento;
    }

    public void setPercentualDiferimento(BigDecimal percentualDiferimento) {
        this.percentualDiferimento = percentualDiferimento;
    }

    public BigDecimal getValorIcmsOperacao() {
        return valorIcmsOperacao;
    }

    public void setValorIcmsOperacao(BigDecimal valorIcmsOperacao) {
        this.valorIcmsOperacao = valorIcmsOperacao;
    }

    public BigDecimal getValorIcmsDeferido() {
        return valorIcmsDeferido;
    }

    public void setValorIcmsDeferido(BigDecimal valorIcmsDeferido) {
        this.valorIcmsDeferido = valorIcmsDeferido;
    }

    public BigDecimal getValorBcDifal() {
        return valorBcDifal;
    }

    public void setValorBcDifal(BigDecimal valorBcDifal) {
        this.valorBcDifal = valorBcDifal;
    }

    public BigDecimal getDifal() {
        return difal;
    }

    public void setDifal(BigDecimal difal) {
        this.difal = difal;
    }

    public BigDecimal getFcp() {
        return fcp;
    }

    public void setFcp(BigDecimal fcp) {
        this.fcp = fcp;
    }

    public BigDecimal getValorIcmsDestino() {
        return valorIcmsDestino;
    }

    public void setValorIcmsDestino(BigDecimal valorIcmsDestino) {
        this.valorIcmsDestino = valorIcmsDestino;
    }

    public BigDecimal getValorIcmsOrigem() {
        return valorIcmsOrigem;
    }

    public void setValorIcmsOrigem(BigDecimal valorIcmsOrigem) {
        this.valorIcmsOrigem = valorIcmsOrigem;
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
    
    

}
