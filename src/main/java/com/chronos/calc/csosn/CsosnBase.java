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
package com.chronos.calc.csosn;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author John Vanderson M L
 */
public abstract class CsosnBase {

    protected OrigemMercadoria origemMercadoria;
    protected Csosn csosn;

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
