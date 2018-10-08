/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoIpi;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author John Vanderson M L
 */
public class CalculoIpiTest {

    private ITributavel tributos;
    private CalcTributacao calcular;

    public CalculoIpiTest() {
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
    public void CalcularIpiComQuantidadeUm() {
        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIpi(BigDecimal.valueOf(17));

        IResultadoCalculoIpi result = calcular.calcularIpi();

        BigDecimal valor = result.getValor();
        BigDecimal baseCalculo = result.getBaseCalculo();
        BigDecimal valorTest = BigDecimal.valueOf(170).setScale(2);

        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIpiComQuantidadeDois() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setPercentualIpi(BigDecimal.valueOf(17));

        IResultadoCalculoIpi result = calcular.calcularIpi();

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(680).setScale(2);

        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIpiComDescontoCondicional() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setDesconto(BigDecimal.valueOf(1000));
        tributos.setPercentualIpi(BigDecimal.valueOf(12));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);
        IResultadoCalculoIpi result = calcular.calcularIpi();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(5000).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(600).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIpiComFrete() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setDesconto(BigDecimal.valueOf(1000));
        tributos.setPercentualIpi(BigDecimal.valueOf(15));
        tributos.setFrete(BigDecimal.valueOf(373.5));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);
        IResultadoCalculoIpi result = calcular.calcularIpi();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(5373.50).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(806.02).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIpiComOutrasDespesasESeguro() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setDesconto(BigDecimal.valueOf(1000));
        tributos.setPercentualIpi(BigDecimal.valueOf(12));
        tributos.setFrete(BigDecimal.valueOf(373.5));
        tributos.setSeguro(BigDecimal.valueOf(5.73));
        tributos.setOutrasDespesas(BigDecimal.valueOf(233.10));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);
        IResultadoCalculoIpi result = calcular.calcularIpi();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(5612.33).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(673.47).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);
    }

}
