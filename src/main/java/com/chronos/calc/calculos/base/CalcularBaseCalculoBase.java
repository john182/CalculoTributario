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
package com.chronos.calc.calculos.base;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public abstract class CalcularBaseCalculoBase {

    private final ITributavel tributos;
    private final TipoDesconto desconto;

    public CalcularBaseCalculoBase(ITributavel tributos) {
        this.tributos = tributos;
        this.desconto = TipoDesconto.Incondicional;
    }

    public CalcularBaseCalculoBase(ITributavel tributos, TipoDesconto desconto) {
        this.tributos = tributos;
        this.desconto = desconto;
    }

    public ITributavel getTributos() {
        return tributos;
    }

    public TipoDesconto getDesconto() {
        return desconto;
    }

    public BigDecimal getBaseCalculo() {
        BigDecimal valor = tributos.getValorProduto().multiply(tributos.getQuantidadeProduto());
        valor = valor.add(Optional.ofNullable(tributos.getFrete()).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(tributos.getOutrasDespesas()).orElse(BigDecimal.ZERO))
                .add(Optional.ofNullable(tributos.getSeguro()).orElse(BigDecimal.ZERO));

        valor = valor.setScale(2, RoundingMode.DOWN);

        return desconto == TipoDesconto.Condicional
                ? calculaComDescontoCondicional(valor)
                : calculaComDescontoIncondicional(valor);
    }

    private BigDecimal calculaComDescontoCondicional(BigDecimal baseCalculo) {
        return baseCalculo.add(tributos.getDesconto());
    }

    private BigDecimal calculaComDescontoIncondicional(BigDecimal baseCalculo) {
        return baseCalculo.subtract(tributos.getDesconto());
    }
}
