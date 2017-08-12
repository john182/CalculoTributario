/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.cst;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author John Vanderson M L
 */
public abstract class CstBase {

    protected OrigemMercadoria origemMercadoria;
    protected Cst cst;

    public CstBase() {
        this.origemMercadoria = OrigemMercadoria.Nacional;
    }

    public CstBase(OrigemMercadoria OrigemMercadoria) {
        this.origemMercadoria = OrigemMercadoria;
    }

    public abstract void calcular(ITributavel tributos);

    protected void validacaoPadrao(ITributavel tributos) {
        if (tributos == null) {
            throw new IllegalArgumentException("tributos nao  inicializado");
        } else if (tributos.getValorProduto().signum() == 0) {
            throw new IllegalArgumentException("Valor do Produto não informado");
        } else if (tributos.getQuantidadeProduto().signum() == 0) {
            throw new IllegalArgumentException("Quantidade do Produto não informada");
        }
    }

    public OrigemMercadoria getOrigemMercadoria() {
        return origemMercadoria;
    }

    public void setOrigemMercadoria(OrigemMercadoria OrigemMercadoria) {
        this.origemMercadoria = OrigemMercadoria;
    }

    public Cst getCst() {
        return cst;
    }
    
    
}
