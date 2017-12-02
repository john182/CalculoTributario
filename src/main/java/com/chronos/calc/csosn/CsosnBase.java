/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.csosn;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author John Vanderson M L
 */
public abstract class CsosnBase {

    public OrigemMercadoria origemMercadoria;
    public Csosn csosn;

    public CsosnBase() {
        this.origemMercadoria = OrigemMercadoria.Nacional;
    }

    public CsosnBase(OrigemMercadoria origemMercadoria) {
        this.origemMercadoria = origemMercadoria;
    }

    protected void validacaoPadrao(ITributavel tributos) {
        if (tributos == null) {
            throw new IllegalArgumentException("tributos nao  inicializado");
        } else if (tributos.getValorProduto().signum() == 0) {
            throw new IllegalArgumentException("Valor do Produto não informado");
        } else if (tributos.getQuantidadeProduto().signum() == 0) {
            throw new IllegalArgumentException("Quantidade do Produto não informada");
        }
    }

    public abstract void calcular(ITributavel tributos);

    public Csosn getCsosn() {
        return csosn;
    }

    public OrigemMercadoria getOrigemMercadoria() {
        return origemMercadoria;
    }

    public void setOrigemMercadoria(OrigemMercadoria origemMercadoria) {
        this.origemMercadoria = origemMercadoria;
    }

}
