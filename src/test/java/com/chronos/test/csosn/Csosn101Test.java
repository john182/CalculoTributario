/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.csosn;

import com.chronos.calc.csosn.Csosn101;
import com.chronos.calc.dto.ITributavel;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author John Vanderson M L
 */
public class Csosn101Test {

    public Csosn101Test() {
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
    public void TestaCalculoCsosn101() {
        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(10));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualCredito(BigDecimal.valueOf(1.47));
        Csosn101 csosn = new Csosn101();

        csosn.calcular(tributos);

        BigDecimal valorCredito = csosn.getValorCredito();
        BigDecimal percentual = csosn.getPercentualCredito();

        assertEquals(BigDecimal.valueOf(0.15).setScale(2), valorCredito);
        assertEquals(BigDecimal.valueOf(1.47).setScale(2), percentual);

    }
}
