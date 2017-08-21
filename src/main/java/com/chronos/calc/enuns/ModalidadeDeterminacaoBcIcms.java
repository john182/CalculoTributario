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
public enum ModalidadeDeterminacaoBcIcms {
    MargemValorAgregado("Margem Valor Agregado (%)", "0"),
    PautaValor("Pauta (Valor)", "1"),
    PrecoTabeladoMax("Preço Tabelado Máx. (valor)", "2"),
    ValorOperacao("Valor da Operação", "3");

    private String codigo;
    private String nomeExibicao;

    private ModalidadeDeterminacaoBcIcms(String nomeExibicao, String codigo) {
        this.codigo = codigo;
        this.nomeExibicao = nomeExibicao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }
}
