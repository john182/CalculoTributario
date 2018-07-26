/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoFcpSt;
import org.junit.*;

import java.math.BigDecimal;

/**
 * @author John Vanderson M L
 */
public class CalculoFcpStTest {

    public CalculoFcpStTest() {
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
    public void CalculaFcpStValor56() {
        ITributavel tributos = new ITributavel();
        tributos.setPercentualFcpSt(BigDecimal.valueOf(2));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setPercentualMva(BigDecimal.valueOf(40));

        CalcTributacao calcular = new CalcTributacao(tributos);

        IResultadoCalculoFcpSt resultado = calcular.calcularFcpSt();


        BigDecimal valor = resultado.getValor();


        BigDecimal valorTest = BigDecimal.valueOf(56).setScale(2);


        Assert.assertEquals(valorTest, valor);
    }

    @Test
    public void CalculaFcpStValor260() {
        ITributavel tributos = new ITributavel();
        tributos.setPercentualFcpSt(BigDecimal.valueOf(2));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setPercentualMva(BigDecimal.valueOf(30));

        CalcTributacao calcular = new CalcTributacao(tributos);

        IResultadoCalculoFcpSt resultado = calcular.calcularFcpSt();


        BigDecimal valor = resultado.getValor();


        BigDecimal valorTest = BigDecimal.valueOf(2.60).setScale(2);


        Assert.assertEquals(valorTest, valor);
    }
}
