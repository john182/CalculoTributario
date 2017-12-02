/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public final class Biblioteca {

    private Biblioteca() {
    }

    public static BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.multiply(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal divide(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.divide(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal subtrai(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.subtract(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal soma(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.add(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal porcentagem(BigDecimal valor, BigDecimal porcentagem) {
        BigDecimal result = valor.multiply(porcentagem).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        result = result.setScale(2, RoundingMode.HALF_DOWN);
        return result;
    }
}
