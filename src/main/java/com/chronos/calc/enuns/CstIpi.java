/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.enuns;

/**
 *
 * @author John Vanderson M L
 */
public enum CstIpi {

    Cst00("00", "00 - Entrada com Recuperação de Crédito"),
    Cst01("01", "01 - Entrada Tributada com Alíquota Zero"),
    Cst02("02", "02 - Entrada Isenta"),
    Cst03("03", "03 - Entrada Não Tributada"),
    Cst04("04", "04 - Entrada Imune"),
    Cst05("05", "05 - Entrada com Suspensão"),
    Cst49("49", "49 - Outras Entradas"),
    Cst50("50", "50 - Saída Tributada"),
    Cst51("51", "51 - Saída Tributável com Alíquota Zero"),
    Cst52("52", "52 - Saída Isenta"),
    Cst53("53", "53 - Saída Não Tributada"),
    Cst54("54", "54 - Saída Imune"),
    Cst55("55", "55 - Saída com Suspensão"),
    Cst90("99", "90 - Outras Saídas");

    private String descricao;
    private String codigo;

    CstIpi(String codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
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
