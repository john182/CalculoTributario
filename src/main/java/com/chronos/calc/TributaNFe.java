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

import com.chronos.calc.csosn.CsosnBase;
import com.chronos.calc.csosn.CsosnFactory;
import com.chronos.calc.cst.CstBase;
import com.chronos.calc.cst.CstFactory;
import com.chronos.calc.dto.*;
import com.chronos.calc.enuns.*;
import com.chronos.calc.iss.Issqn;
import com.chronos.calc.resultados.*;
import com.chronos.calc.resultados.imp.DadosMensagemDifal;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class TributaNFe {

    private final TributosProduto produto;
    private final CalcTributacao calcular;
    private TipoOperacao operacao;

    public TributaNFe(TributosProduto produto) {
        this.produto = produto;
        this.calcular = new CalcTributacao(produto);
    }

    public Imposto tributarNfe(Crt crt, TipoOperacao operacao, TipoPessoa pessoa) throws TributacaoException {
        Imposto imposto = new Imposto();

        this.operacao = operacao;

        if (produto.isServico()) {
            boolean calcularRetencao = (crt != Crt.SimplesNacional && pessoa != TipoPessoa.Fisica);
            Iss iss = calcularIssqn(calcularRetencao);
            imposto.setIssqn(iss);
        } else {

            Icms icms = crt.equals(Crt.SimplesNacional) ? tributarIcmsSimplesNascinal(produto.getCsosn()) : tributarIcms(produto.getCst(), pessoa);
            icms = calcularDifal(icms);

            Ipi ipi = calcularIpi();
            imposto.setIcms(icms);
            imposto.setIpi(ipi);

        }
        Pis pis = calcularPis();
        Cofins cofins = calcularCofins();
        imposto.setCofins(cofins);
        imposto.setPis(pis);
        imposto = calcularIbpt(imposto);
        return imposto;
    }

    /**
     * Simples Nacional - excesso de sublimite de receita bruta; 3 - Regime
     * Normal.
     *
     * @param cst
     * @return
     */
    private Icms tributarIcms(Cst cst, TipoPessoa tipoPessoa) throws TributacaoException {
        Icms calculo;

        //pessoa fisica inclui ipi na base de calculo do icms
        //pessoa fisica sempre usa a aliquota normal da UF emissao
        if (tipoPessoa == TipoPessoa.Fisica) {
            BigDecimal valorIpi = calcular.calcularIpi().getValor();
            produto.setValorIpi(valorIpi);
        }

        CstBase cstOperacao = CstFactory.getCst(cst);
        cstOperacao.calcular(produto);
        calculo = cstOperacao.getIcmsDto();
        calculo.setCst(produto.getCst().getCodigo());
        return calculo;
    }

    /**
     * 1 = Simples Nacional
     *
     * @param csosn
     * @return
     */
    private Icms tributarIcmsSimplesNascinal(Csosn csosn) {
        Icms calculo;

        CsosnBase csosnBase = CsosnFactory.createCsosn(csosn);
        if (csosn == Csosn.Csosn102 || csosn == Csosn.Csosn103 || csosn == Csosn.Csosn300 || csosn == Csosn.Csosn400) {
            calculo = new Icms();
        } else {
            csosnBase.calcular(produto);
            calculo = csosnBase.getIcmsDto();
        }

        calculo.setCst(produto.getCsosn().getCodigo());
        return calculo;

    }

    private Icms calcularDifal(Icms icms) {

        boolean geraDifal = produto.getCst() != null
                ? CstFactory.getCst(produto.getCst()).isGeraDifal()
                : produto.getCsosn() != null && CsosnFactory.createCsosn(produto.getCsosn()).isGeraDifal();

        if (operacao == TipoOperacao.OperacaoInterestadual
                && geraDifal
                && produto.getPercentualDifalInterna().signum() != 0
                && produto.getPercentualDifalInterestadual().signum() != 0) {

            IResultadoCalculoDifal result = calcular.calculaDifalFcp();
            BigDecimal baseCalculoDifal = result.getBaseCalculo();
            BigDecimal fcp = result.getFcp();
            BigDecimal difal = result.getDifal();
            BigDecimal valorIcmsOrigem = result.getValorIcmsOrigem();
            BigDecimal valorIcmsDestino = result.getValorIcmsDestino();

            String obs = result.getObservacao(new DadosMensagemDifal(fcp, valorIcmsDestino, valorIcmsOrigem));

            icms.setValorBcDifal(baseCalculoDifal);
            icms.setFcp(fcp);
            icms.setDifal(difal);
            icms.setValorIcmsOrigem(valorIcmsOrigem);
            icms.setValorIcmsDestino(valorIcmsDestino);
            icms.setObsDifal(obs);

        }

        return icms;
    }

    private Ipi calcularIpi() {
        if (produto.getCstIpi() != null
                && produto.getCstIpi().isGeraIpi()) {
            Ipi ipi = new Ipi();
            BigDecimal valor;
            BigDecimal baseCalculo;

            IResultadoCalculoIpi result = calcular.calcularIpi();
            valor = result.getValor();
            baseCalculo = result.getBaseCalculo();

            ipi.setCst(produto.getCstIpi().getCodigo());
            ipi.setValorBcIpi(baseCalculo);
            ipi.setValorIpi(valor);

            return ipi;

        } else {
            return null;
        }
    }

    private Pis calcularPis() {
        if (produto.getCstPisCofins() != null
                && produto.getCstPisCofins().isGeraPisCofins()) {
            Pis pis = new Pis();
            IResultadoCalculoPis result = calcular.calcularPis();
            BigDecimal valor = result.getValor();
            BigDecimal baseCalculo = result.getBaseCalculo();

            pis.setCst(produto.getCstPisCofins().getCodigo());
            pis.setBaseCalculo(baseCalculo);
            pis.setValor(valor);
            return pis;
        }
        return null;
    }

    private Cofins calcularCofins() {
        if (produto.getCstPisCofins() != null
                && produto.getCstPisCofins().isGeraPisCofins()) {
            Cofins cofins = new Cofins();
            IResultadoCalculoCofins result = calcular.calcularCofins();
            BigDecimal valor = result.getValor();
            BigDecimal baseCalculo = result.getBaseCalculo();

            cofins.setCst(produto.getCstPisCofins().getCodigo());
            cofins.setBaseCalculo(baseCalculo);
            cofins.setValor(valor);
            return cofins;
        }

        return null;
    }

    private Iss calcularIssqn(boolean calcularRetencao) {
        Iss iss = new Iss();
        Issqn issqn = new Issqn();

        issqn.calcular(produto, calcularRetencao);

        BigDecimal valor = issqn.getValorIssqn();
        BigDecimal baseCalculo = issqn.getValorBcIssqn();
        BigDecimal percentual = issqn.getPercentualIssqn();
        iss.setValor(valor);
        iss.setBaseCalculo(baseCalculo);
        iss.setPercentualIss(percentual);
        iss.setBaseCalculoInss(issqn.getBaseCalculoInss());
        iss.setBaseCalculoIrrf(issqn.getPercentualIssqn());
        iss.setValorRetCofins(issqn.getValorRetCofins());
        iss.setValorRetPis(issqn.getValorRetPis());
        iss.setValorRetIrrf(issqn.getValorRetIrrf());
        iss.setValorRetInss(issqn.getBaseCalculoInss());
        return iss;
    }

    private Imposto calcularIbpt(Imposto imposto) {

        IResultadoCalculoIbpt result = calcular.calculaIbpt(produto);
        BigDecimal tributacaoEstadual = result.getTributacaoEstadual();
        BigDecimal tributacaoFederal = result.getTributacaoFederal();
        BigDecimal tributacaoFederalImp = result.getTributacaoFederalImportados();
        BigDecimal tributacaoMunicipal = result.getTributacaoMunicipal();
        BigDecimal valorTotalTributos = result.getValorTotalTributos();
        imposto.setTributacaoEstadual(tributacaoEstadual);
        imposto.setTributacaoFederal(tributacaoFederal);
        imposto.setTributacaoFederalImp(tributacaoFederalImp);
        imposto.setTributacaoMunicipal(tributacaoMunicipal);
        imposto.setValorTotalTributos(valorTotalTributos);
        return imposto;
    }

}
