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
public enum ModalidadeDeterminacaoBcIcmsSt {

    PrecoTabeladoOuMaximoSugerido("Preço tabelado ou máximo sugerido", "0"),
    ListaNegativa("Lista Negativa (valor)", "1"),
    ListaPositiva("Lista Positiva (valor)", "2"),
    ListaNeutra("Lista Neutra (valor)", "3"),
    MargemValorAgregado("Margem Valor Agregado(%)", "4"),
    Pauta("Pauta (valor)", "5");
    
    private final String codigo;
    private final String nomeExibicao;

    private ModalidadeDeterminacaoBcIcmsSt(String nomeExibicao, String codigo) {
        this.codigo = codigo;
        this.nomeExibicao = nomeExibicao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

}
