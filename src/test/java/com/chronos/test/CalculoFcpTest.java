/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoFcp;
import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author John Vanderson M L
 */
public class CalculoFcpTest {

    public CalculoFcpTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CalculaFcp() {
        ITributavel tributos = new ITributavel();
        tributos.setPercentualFcp(BigDecimal.TEN);
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setValorProduto(BigDecimal.valueOf(1000));

        CalcTributacao calcular = new CalcTributacao(tributos);

        IResultadoCalculoFcp resultado = calcular.calcularFcp();

        BigDecimal baseCalculo = resultado.getBaseCalculo();
        BigDecimal valor = resultado.getValor();

        BigDecimal baseCalculoTest = BigDecimal.valueOf(1000);
        BigDecimal valorTest = BigDecimal.valueOf(100).setScale(2);

        baseCalculoTest = baseCalculoTest.setScale(2, RoundingMode.DOWN);

        Assert.assertEquals(baseCalculoTest, baseCalculo);
        Assert.assertEquals(valorTest, valor);
    }
}
