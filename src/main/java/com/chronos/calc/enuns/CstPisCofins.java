/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.enuns;

import java.util.Objects;

/**
 *
 * @author John Vanderson M L
 */
public enum CstPisCofins {

    Cst01("01", "01 - Operação Tributável com Alíquota Básica"),
    Cst02("02", "02 - Operação Tributável com Alíquota Diferenciada"),
    Cst03("03", "03 - Operação Tributável com Alíquota por Unidade de Medida de Produto"),
    Cst04("04", "04 - Operação Tributável Monofásica - Revenda a Alíquota Zero"),
    Cst05("05", "05 - Operação Tributável por Substituição Tributária"),
    Cst06("06", "06 - Operação Tributável a Alíquota Zero"),
    Cst07("07", "07 - Operação Isenta da Contribuição"),
    Cst08("08", "08 - Operação sem Incidência da Contribuição"),
    Cst09("09", "09 - Operação com Suspensão da Contribuição"),
    Cst49("49", "49 - Outras Operações de Saída"),
    Cst50("50", "50 - Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno"),
    Cst51("51", "51 - Operação com Direito a Crédito – Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno"),
    Cst52("52", "52 - Operação com Direito a Crédito - Vinculada Exclusivamente a Receita de Exportação"),
    Cst53("53", "53 - Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno"),
    Cst54("54", "54 - Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação"),
    Cst55("55", "55 - Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação"),
    Cst56("56", "56 - Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação"),
    Cst60("60", "60 - Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno"),
    Cst61("61", "61 - Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno"),
    Cst62("62", "62 - Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação"),
    Cst63("63", "63 - Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno"),
    Cst64("64", "64 - Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação"),
    Cst65("65", "65 - Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação"),
    Cst66("66", "66 - Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação"),
    Cst67("67", "67 - Crédito Presumido - Outras Operações"),
    Cst70("70", "70 - Operação de Aquisição sem Direito a Crédito"),
    Cst71("71", "71 - Operação de Aquisição com Isenção"),
    Cst72("72", "72 - Operação de Aquisição com Suspensão"),
    Cst73("73", "73 - Operação de Aquisição a Alíquota Zero"),
    Cst74("74", "74 - Operação de Aquisição sem Incidência da Contribuição"),
    Cst75("75", "75 - Operação de Aquisição por Substituição Tributária"),
    Cst98("98", "98 - Outras Operações de Entrada"),
    Cst99("99", "99 - Outras Operações");

    private String descricao;
    private String codigo;

    CstPisCofins(String codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static CstPisCofins valueOfCodigo(final String codigo) {
        for (final CstPisCofins cst : CstPisCofins.values()) {
            if (Objects.equals(cst.getCodigo(), codigo)) {
                return cst;
            }
        }
        // throw new IllegalArgumentException(String.format("Cst não definido."));
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
