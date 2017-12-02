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
package com.chronos.calc.dto;

import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author John Vanderson M L
 */
public class Ibpt {

    private BigDecimal percentualFederal;
    private BigDecimal percentualFederalImportados;
    private BigDecimal percentualEstadual;
    private BigDecimal percentualMunicipal;

    public BigDecimal getPercentualFederal() {
        return Optional.ofNullable(percentualFederal).orElse(BigDecimal.ZERO);
    }

    public void setPercentualFederal(BigDecimal percentualFederal) {
        this.percentualFederal = percentualFederal;
    }

    public BigDecimal getPercentualFederalImportados() {
        return Optional.ofNullable(percentualFederalImportados).orElse(BigDecimal.ZERO);
    }

    public void setPercentualFederalImportados(BigDecimal percentualFederalImportados) {
        this.percentualFederalImportados = percentualFederalImportados;
    }

    public BigDecimal getPercentualEstadual() {
        return Optional.ofNullable(percentualEstadual).orElse(BigDecimal.ZERO);
    }

    public void setPercentualEstadual(BigDecimal percentualEstadual) {
        this.percentualEstadual = percentualEstadual;
    }

    public BigDecimal getPercentualMunicipal() {
        return Optional.ofNullable(percentualMunicipal).orElse(BigDecimal.ZERO);
    }

    public void setPercentualMunicipal(BigDecimal percentualMunicipal) {
        this.percentualMunicipal = percentualMunicipal;
    }
}
