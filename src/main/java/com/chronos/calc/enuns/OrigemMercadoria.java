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
public enum OrigemMercadoria {

    Nacional(0, "Nacional"),
    EstrangeiraImportacaoDireta(1, "Estrangeira Importação Direta"),
    EstrangeiraInterna(2, "Estrangeira Interna"),
    NacionalImportacaoSuperior40(3, "Nacional Importação Inferior 40"),
    NacionalConformidadeBasicas(4, "Nacional Confirmidade Básicas"),
    NacionalImportacaoInferior40(5, "Nacional Importação Inferior 40"),
    EstrangeiraImportacaoDiretaSemSimilar(6, "Estrangeira Importação Direta Sem Similar"),
    EstrangeiraInternaSemSimilar(7, "Estrangeira Interna Sem Similar"),
    NacionalImportacaoSuperior70(8, "Nacional Importação Superior 70");

    private String descricao;
    private Integer codigo;

    OrigemMercadoria(Integer codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
