/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.cst.Cst20;
import com.chronos.calc.dto.ITributavel;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author John Vanderson M L
 */
public class Cst20Test {

    public Cst20Test() {
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
    public void CalculoCST20() {
        ITributavel tributos = new ITributavel();
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualReducao(BigDecimal.valueOf(10));

        Cst20 cst = new Cst20();

        cst.calcular(tributos);

        BigDecimal percentualReducao = cst.getPercentualReducao();
        BigDecimal baseCalcIcms = cst.getValorBcIcms();
        BigDecimal percentualIcms = cst.getPercentualIcms();
        BigDecimal valorIcms = cst.getValorIcms();

        assertEquals(BigDecimal.valueOf(10.00).setScale(2), percentualReducao);
        assertEquals(BigDecimal.valueOf(90.00).setScale(2), baseCalcIcms);

        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcms);
        assertEquals(BigDecimal.valueOf(16.20).setScale(2), valorIcms);

    }
}
