/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;
import com.chronos.calc.resultados.IResultadoCalculoCredito;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John Vanderson M L
 */
public class CalculoIcmsCreditoTest {

    private ITributavel tributos;
    private CalcTributacao calcular;

    public CalculoIcmsCreditoTest() {
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
    public void CalcularIcmsCreditoComQuantidadeUm() {
        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualCredito(BigDecimal.valueOf(17));

        IResultadoCalculoCredito result = calcular.calcularIcmsCredito();

        BigDecimal valor = result.getValor();
        BigDecimal baseCalculo = result.getBaseCalculo();
        BigDecimal valorTest = BigDecimal.valueOf(170).setScale(2);

        assertEquals(valorTest, valor);

    }

    @Test
    public void CalcularIcmsCreditoComQuantidadeDois() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setPercentualCredito(BigDecimal.valueOf(17));

        IResultadoCalculoCredito result = calcular.calcularIcmsCredito();

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(680).setScale(2);

        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIcmsCreditoComDescontoCondicional() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setPercentualCredito(BigDecimal.valueOf(12));
        tributos.setDesconto(BigDecimal.valueOf(1000));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);
        IResultadoCalculoCredito result = calcular.calcularIcmsCredito();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(5000).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(600).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIcmsCreditoComReducao() {
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setPercentualCredito(BigDecimal.valueOf(7));
        tributos.setDesconto(BigDecimal.valueOf(1000));
        tributos.setPercentualReducao(BigDecimal.valueOf(25));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);
        IResultadoCalculoCredito result = calcular.calcularIcmsCredito();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(3750).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(262.5).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIcmsCreditoComFrete() {

        tributos.setPercentualCredito(BigDecimal.valueOf(15));
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setDesconto(BigDecimal.valueOf(1000));
        tributos.setPercentualReducao(BigDecimal.valueOf(25));
        tributos.setFrete(BigDecimal.valueOf(373.5));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);
        IResultadoCalculoCredito result = calcular.calcularIcmsCredito();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(4030.12).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(604.52).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);
    }

    @Test
    public void CalcularIcmsComOutrasDespesasESeguro() {
        tributos.setPercentualCredito(BigDecimal.valueOf(12));
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(2));
        tributos.setDesconto(BigDecimal.valueOf(1000));
        tributos.setPercentualReducao(BigDecimal.valueOf(25));
        tributos.setFrete(BigDecimal.valueOf(373.5));
        tributos.setSeguro(BigDecimal.valueOf(5.73));
        tributos.setOutrasDespesas(BigDecimal.valueOf(233.10));

        calcular = new CalcTributacao(tributos, TipoDesconto.Condicional);

        IResultadoCalculoCredito result = calcular.calcularIcmsCredito();

        BigDecimal baseCaculo = result.getBaseCalculo();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(4209.24).setScale(2);

        BigDecimal valor = result.getValor();
        BigDecimal valorTest = BigDecimal.valueOf(505.11).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorTest, valor);

    }
}
