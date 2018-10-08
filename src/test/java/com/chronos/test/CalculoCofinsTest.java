package com.chronos.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoCofins;
import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author John Vanderson M L
 */
public class CalculoCofinsTest {

    public CalculoCofinsTest() {
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
    public void CalculaCofins() {
        ITributavel tributos = new ITributavel();
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualCofins(BigDecimal.valueOf(3.00));
        tributos.setValorProduto(BigDecimal.valueOf(1000));

        CalcTributacao calcular = new CalcTributacao(tributos);

        IResultadoCalculoCofins resultado = calcular.calcularCofins();
        BigDecimal baseCalculo = resultado.getBaseCalculo();
        BigDecimal valor = resultado.getValor();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(1000);
        BigDecimal valorTest = BigDecimal.valueOf(30).setScale(2);

        baseCalculoTest = baseCalculoTest.setScale(2, RoundingMode.DOWN);

        Assert.assertEquals(baseCalculoTest, baseCalculo);
        Assert.assertEquals(valorTest, valor);
    }
}
