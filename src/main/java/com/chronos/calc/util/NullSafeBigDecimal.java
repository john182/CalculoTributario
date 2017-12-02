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
package com.chronos.calc.util;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public class NullSafeBigDecimal {

    private BigDecimal value;

    public NullSafeBigDecimal(BigDecimal value) {
        this.value = value;
    }

    public NullSafeBigDecimal add(BigDecimal val) {
        value = value.add(nullsafeBigDecimal(val));
        return this;
    }

    public NullSafeBigDecimal divide(BigDecimal val) {
        value = value.divide(nullsafeBigDecimal(val));
        return this;
    }

    public NullSafeBigDecimal multiply(BigDecimal val) {
        value = value.multiply(nullsafeBigDecimal(val));
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    private BigDecimal nullsafeBigDecimal(BigDecimal val) {
        return val == null ? new BigDecimal(0) : val;
    }
}
