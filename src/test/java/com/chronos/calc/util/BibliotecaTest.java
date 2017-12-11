/*
 * The MIT License
 *
 * Copyright 2017 Chronosinfo.
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
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Renan Esposte
 */
public class BibliotecaTest {

    public BibliotecaTest() {
    }

    @Test
    public void testMultiplica() {
        BigDecimal valor1 = new BigDecimal("2.324");
        BigDecimal valor2 = new BigDecimal("7.917");
        BigDecimal expResult = new BigDecimal("18.39");
        BigDecimal result = Biblioteca.multiplica(valor1, valor2);
        assertEquals(expResult, result);
    }

    @Test
    public void testDivide() {
        BigDecimal valor1 = new BigDecimal("271.489");
        BigDecimal valor2 = new BigDecimal("7.33");
        BigDecimal expResult = new BigDecimal("37.03"); // 3703,683492496589
        BigDecimal result = Biblioteca.divide(valor1, valor2);
        assertEquals(expResult, result);
    }

    @Test
    public void testSubtrai() {
        BigDecimal valor1 = new BigDecimal("271.489");
        BigDecimal valor2 = new BigDecimal("7.33");
        BigDecimal expResult = new BigDecimal("264.15"); // 264,159
        BigDecimal result = Biblioteca.subtrai(valor1, valor2);
        assertEquals(expResult, result);
    }

    @Test
    public void testSoma() {
        BigDecimal valor1 = new BigDecimal("261.489");
        BigDecimal valor2 = new BigDecimal("41.79876");
        BigDecimal expResult = new BigDecimal("303.28"); // 303,28776
        BigDecimal result = Biblioteca.soma(valor1, valor2);
        assertEquals(expResult, result);
    }

    @Test
    public void testPorcetagem() {
        BigDecimal valor = new BigDecimal("311.713");
        BigDecimal porcetagem = new BigDecimal("21.419");
        BigDecimal expResult = new BigDecimal("66.77");
        BigDecimal result = Biblioteca.porcentagem(valor, porcetagem);
        assertEquals(expResult, result);
    }

}
