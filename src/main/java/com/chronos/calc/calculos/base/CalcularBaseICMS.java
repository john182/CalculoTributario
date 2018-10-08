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
 * @author John Vanderson M L
 */
public class CalcularBaseICMS extends CalcularBaseCalculoBase {

    public CalcularBaseICMS(ITributavel tributos, TipoDesconto desconto) {
        super(tributos, desconto);
    }

    @Override
    public BigDecimal getBaseCalculo() {
        BigDecimal baseCalculo = super.getBaseCalculo()
                .add(Optional.ofNullable(getTributos().getValorIpi()).orElse(BigDecimal.ZERO));
        return aplicarReducaoBaseCalculo(baseCalculo);
    }

    private BigDecimal aplicarReducaoBaseCalculo(BigDecimal baseCalculoInicial) {
        BigDecimal reducao = baseCalculoInicial.multiply(getTributos().getPercentualReducao()).divide(BigDecimal.valueOf(100));
        baseCalculoInicial = baseCalculoInicial.subtract(reducao);
        baseCalculoInicial = baseCalculoInicial.setScale(2, RoundingMode.DOWN);

        return baseCalculoInicial;
    }

}
