/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoIcmsSt;
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
public class CalculoIcmsStTest {

    public CalculoIcmsStTest() {
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
    public void TestaIcmsSt() {
        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);

        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setPercentualIpi(BigDecimal.valueOf(15));
        tributos.setPercentualMva(BigDecimal.valueOf(40));

        CalcTributacao calcular = new CalcTributacao(tributos);
        tributos.setValorIpi(calcular.calcularIpi().getValor());
        IResultadoCalculoIcmsSt result = calcular.calcularIcmsSt();

        BigDecimal baseCaculo = result.getBaseCalculoOperacaoPropria();
        BigDecimal baseCalculoTest = BigDecimal.valueOf(2000).setScale(2);

        BigDecimal valorIcmProprio = result.getValorIcmsProprio();
        BigDecimal valorIcmsProprioTest = BigDecimal.valueOf(360).setScale(2);

        BigDecimal baseCaculoST = result.getBaseCalculoIcmsSt();
        BigDecimal baseCalculoSTTest = BigDecimal.valueOf(3220).setScale(2);

        BigDecimal valorIcmST = result.getValorIcmsSt();
        BigDecimal valorIcmsSTTest = BigDecimal.valueOf(219.60).setScale(2);

        assertEquals(baseCalculoTest, baseCaculo);
        assertEquals(valorIcmsProprioTest, valorIcmProprio);
        assertEquals(baseCalculoSTTest, baseCaculoST);
        assertEquals(valorIcmsSTTest, valorIcmST);
    }
}
