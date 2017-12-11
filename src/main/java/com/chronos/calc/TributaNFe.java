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

import com.chronos.calc.csosn.Csosn101;
import com.chronos.calc.csosn.Csosn201;
import com.chronos.calc.csosn.Csosn202;
import com.chronos.calc.csosn.Csosn203;
import com.chronos.calc.csosn.Csosn900;
import com.chronos.calc.csosn.CsosnFactory;
import com.chronos.calc.cst.CstBase;
import com.chronos.calc.cst.CstFactory;
import com.chronos.calc.dto.Cofins;
import com.chronos.calc.dto.Icms;
import com.chronos.calc.dto.Imposto;
import com.chronos.calc.dto.Ipi;
import com.chronos.calc.dto.Iss;
import com.chronos.calc.dto.Pis;
import com.chronos.calc.dto.TributosProduto;
import com.chronos.calc.enuns.Crt;
import com.chronos.calc.enuns.Csosn;
import static com.chronos.calc.enuns.Csosn.Csosn203;
import static com.chronos.calc.enuns.Csosn.Csosn900;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.CstPisCofins;
import com.chronos.calc.enuns.TipoOperacao;
import com.chronos.calc.enuns.TipoPessoa;
import com.chronos.calc.iss.Issqn;
import com.chronos.calc.resultados.IResultadoCalculoCofins;
import com.chronos.calc.resultados.IResultadoCalculoDifal;
import com.chronos.calc.resultados.IResultadoCalculoIbpt;
import com.chronos.calc.resultados.IResultadoCalculoIpi;
import com.chronos.calc.resultados.IResultadoCalculoPis;
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
    private TipoPessoa pessoa;

    public TributaNFe(TributosProduto produto) {
        this.produto = produto;
        this.calcular = new CalcTributacao(produto);
    }

    public Imposto tributarNfe(TributosProduto produto, Crt crt, TipoOperacao operacao, TipoPessoa pessoa) {
        Imposto imposto = new Imposto();
        this.pessoa = pessoa;
        this.operacao = operacao;

        if (produto.isServico()) {
            boolean calcularRetencao = (crt != Crt.SimplesNacional && pessoa != TipoPessoa.Fisica);
            Iss iss = calcularIssqn(false);
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
    private Icms tributarIcms(Cst cst, TipoPessoa tipoPessoa) {
        Icms calculo = new Icms();

        //pessoa fisica inclui ipi na base de calculo do icms
        //pessoa fisica sempre usa a aliquota normal da UF emissao
        if (tipoPessoa == TipoPessoa.Fisica) {
            BigDecimal valorIpi = calcular.calcularIpi().getValor();
            produto.setValorIpi(valorIpi);
        }

        CstBase cstOperacao = CstFactory.getCst(cst);
        cstOperacao.calcular(produto);
        calculo = cstOperacao.getIcmsDto();

        return calculo;
    }

    /**
     * 1 = Simples Nacional
     *
     * @param cosn
     * @return
     */
    private Icms tributarIcmsSimplesNascinal(Csosn cosn) {
        Icms calculo = new Icms();
        BigDecimal percentualCredito;
        BigDecimal valorCredito;
        switch (cosn) {
            //101 Tributada pelo Simples Nacional com permissão de crédito
            case Csosn101:

                Csosn101 csosn = new Csosn101();
                csosn.calcular(produto);
                valorCredito = csosn.getValorCredito();
                percentualCredito = csosn.getPercentualCredito();
                calculo.setValorCredito(valorCredito);
                calculo.setPercentualCredito(percentualCredito);

                break;

            case Csosn102:
                //102 Tributada pelo Simples Nacional sem permissão de crédito
                //nao tem calculo
                break;
            case Csosn103:
                //103 Isenção do ICMS no Simples Nacional para faixa de receita bruta
                //nao tem calculo
                break;
            //201 Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária    
            case Csosn201:

                Csosn201 csosn201 = new Csosn201();

                csosn201.calcular(produto);

                percentualCredito = csosn201.getPercentualCredito();
                valorCredito = csosn201.getValorCredito();

                calculo.setValorCredito(valorCredito);
                calculo.setPercentualCredito(percentualCredito);

                switch (csosn201.getModalidadeDeterminacaoBcIcmsSt()) {
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
                        BigDecimal percentualMva = csosn201.getPercentualMva();
                        BigDecimal percentualIcmsST = csosn201.getPercentualIcmsSt();
                        BigDecimal percentualReducaoST = csosn201.getPercentualReducaoSt();
                        BigDecimal valorIcmsST = csosn201.getValorIcmsSt();
                        BigDecimal valorBaseCalcST = csosn201.getValorBcIcmsSt();

                        calculo.setPercentualMva(percentualMva);
                        calculo.setPercentualIcmsST(percentualIcmsST);
                        calculo.setPercentualReducaoST(percentualReducaoST);
                        calculo.setValorIcmsST(valorIcmsST);
                        calculo.setValorBaseCalcST(valorBaseCalcST);

                        break;
                    case Pauta:

                        break;
                    case PrecoTabeladoOuMaximoSugerido:
                        //Preço Tabelado ou Máximo Sugerido
                        break;
                }
                break;
            //202 Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária    
            case Csosn202:
                Csosn202 csosn202 = new Csosn202();
                csosn202.calcular(produto);

                switch (csosn202.getModalidadeDeterminacaoBcIcmsSt()) {
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
                        BigDecimal percentualMva = csosn202.getPercentualMva();
                        BigDecimal percentualIcmsST = csosn202.getPercentualIcmsSt();
                        BigDecimal percentualReducaoST = csosn202.getPercentualReducaoSt();
                        BigDecimal valorIcmsST = csosn202.getValorIcmsSt();
                        BigDecimal valorBaseCalcST = csosn202.getValorBcIcmsSt();

                        calculo.setPercentualMva(percentualMva);
                        calculo.setPercentualIcmsST(percentualIcmsST);
                        calculo.setPercentualReducaoST(percentualReducaoST);
                        calculo.setValorIcmsST(valorIcmsST);
                        calculo.setValorBaseCalcST(valorBaseCalcST);

                        break;
                    case Pauta:

                        break;
                    case PrecoTabeladoOuMaximoSugerido:
                        //Preço Tabelado ou Máximo Sugerido
                        break;
                }

                break;
            //203 Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária    
            case Csosn203:
                Csosn203 csosn203 = new Csosn203();
                csosn203.calcular(produto);

                switch (csosn203.getModalidadeDeterminacaoBcIcmsSt()) {
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
                        BigDecimal percentualMva = csosn203.getPercentualMva();
                        BigDecimal percentualIcmsST = csosn203.getPercentualIcmsSt();
                        BigDecimal percentualReducaoST = csosn203.getPercentualReducaoSt();
                        BigDecimal valorIcmsST = csosn203.getValorIcmsSt();
                        BigDecimal valorBaseCalcST = csosn203.getValorBcIcmsSt();

                        calculo.setPercentualMva(percentualMva);
                        calculo.setPercentualIcmsST(percentualIcmsST);
                        calculo.setPercentualReducaoST(percentualReducaoST);
                        calculo.setValorIcmsST(valorIcmsST);
                        calculo.setValorBaseCalcST(valorBaseCalcST);

                        break;
                    case Pauta:

                        break;
                    case PrecoTabeladoOuMaximoSugerido:
                        //Preço Tabelado ou Máximo Sugerido
                        break;
                }

                break;

            case Csosn300:
                //300 Imune - Classificam-se neste código as operações praticadas por optantes pelo Simples Nacional contempladas com imunidade do ICMS
                //nao tem calculo
                break;

            case Csosn400:
                //400 Não tributada pelo Simples Nacional - Classificam-se neste código as operações praticadas por optantes pelo Simples Nacional não sujeitas à tributação pelo ICMS dentro do Simples Nacional
                //nao tem calculo
                break;
            case Csosn500:
                //500 ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação - Classificam-se neste código as operações sujeitas exclusivamente ao regime de substituição tributária na condição de substituído tributário ou no caso de antecipações
                //nao tem calculo

                break;

            case Csosn900:
                Csosn900 csosn900 = new Csosn900();
                csosn900.calcular(produto);

                percentualCredito = csosn900.getPercentualCredito();
                BigDecimal percentualMva = csosn900.getPercentualMva();
                BigDecimal percentualIcmsST = csosn900.getPercentualIcmsSt();
                BigDecimal percentualReducaoST = csosn900.getPercentualReducaoSt();
                BigDecimal valorIcmsST = csosn900.getValorIcmsSt();
                BigDecimal valorBaseCalcST = csosn900.getValorBcIcmsSt();
                valorCredito = csosn900.getValorCredito();
                BigDecimal valorIcms = csosn900.getValorIcms();
                BigDecimal valorBcIcms = csosn900.getValorBcIcms();

                calculo.setPercentualCredito(percentualCredito);
                calculo.setValorCredito(valorCredito);
                calculo.setValorIcms(valorIcms);
                calculo.setValorBcIcms(valorBcIcms);
                calculo.setPercentualMva(percentualMva);
                calculo.setPercentualIcmsST(percentualIcmsST);
                calculo.setPercentualReducaoST(percentualReducaoST);
                calculo.setValorIcmsST(valorIcmsST);
                calculo.setValorBaseCalcST(valorBaseCalcST);

                break;

        }

        return calculo;
    }

    private Icms calcularDifal(Icms icms) {

        boolean geraDifal = produto.getCst() != null ? 
                CstFactory.getCst(produto.getCst()).isGeraDifal() 
                : produto.getCsosn() != null ? 
                CsosnFactory.createCsosn(produto.getCsosn()).isGeraDifal()
                : false;
        
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
        if (produto.getCstIpi() == null) {
            return null;
        }
        Ipi ipi = new Ipi();
        String cst = produto.getCstIpi().getCodigo();
        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal baseCalculo = BigDecimal.ZERO;

        if (cst.equals("00")
                || cst.equals("49")
                || cst.equals("50")
                || cst.equals("99")) {
            IResultadoCalculoIpi result = calcular.calcularIpi();
            valor = result.getValor();
            baseCalculo = result.getBaseCalculo();
        } else {
            return null;
        }

        ipi.setValorBcIpi(baseCalculo);
        ipi.setValorIpi(valor);

        return ipi;
    }

    private Pis calcularPis() {
        Pis pis = new Pis();
        if (produto.getCstPisCofins() == null) {
            return null;
        }
        CstPisCofins cst = produto.getCstPisCofins();

        if (cst == CstPisCofins.Cst01 || cst == CstPisCofins.Cst02) {
            IResultadoCalculoPis result = calcular.calcularPis();
            BigDecimal valor = result.getValor();
            BigDecimal baseCalculo = result.getBaseCalculo();
            pis.setBaseCalculo(baseCalculo);
            pis.setValor(valor);
        }

        return pis;
    }

    private Cofins calcularCofins() {
        if (produto.getCstPisCofins() == null) {
            return null;
        }
        Cofins cofins = new Cofins();
        CstPisCofins cst = produto.getCstPisCofins();
        if (cst == CstPisCofins.Cst01 || cst == CstPisCofins.Cst02) {
            IResultadoCalculoCofins result = calcular.calcularCofins();
            BigDecimal valor = result.getValor();
            BigDecimal baseCalculo = result.getBaseCalculo();
            cofins.setBaseCalculo(baseCalculo);
            cofins.setValor(valor);
        }

        return cofins;
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

    private boolean cstGeraDifal(String cst) {
        return cst.equals("00") || cst.equals("20") || cst.equals("40") || cst.equals("41") || cst.equals("60") || cst.equals("102") || cst.equals("103") || cst.equals("400") || cst.equals("500");
    }
}
