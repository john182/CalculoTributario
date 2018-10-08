/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoIssqn;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author John Vanderson M L
 */
public class CalculoIssqnTest {

    private ITributavel tributos;
    private CalcTributacao calcular;

    public CalculoIssqnTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tributos = new ITributavel();
        calcular = new CalcTributacao(tributos);
    }

    @After
    public void tearDown() {
        tributos = new ITributavel();
        calcular = new CalcTributacao(tributos);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CalcularIssqnComQuantidadeUm() {
        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIssqn(BigDecimal.valueOf(5));

        IResultadoCalculoIssqn result = calcular.calcularIssqn(false);

        BigDecimal valor = result.getValor();
        BigDecimal baseCalculo = result.getBaseCalculo();
        BigDecimal valorTest = BigDecimal.valueOf(50).setScale(2);

        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIssqnComRetencao() {
        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIssqn(BigDecimal.valueOf(5));
        tributos.setPercentualReducao(BigDecimal.valueOf(50));

        IResultadoCalculoIssqn result = calcular.calcularIssqn(false);

        BigDecimal valor = result.getValor();
        BigDecimal baseCalculo = result.getBaseCalculo();
        BigDecimal valorTest = BigDecimal.valueOf(25).setScale(2);

        assertEquals(valorTest, valor);
        assertEquals(BigDecimal.valueOf(500).setScale(2), baseCalculo);
    }


}
