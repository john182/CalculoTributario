/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
