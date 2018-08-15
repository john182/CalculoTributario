/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.TributacaoException;
import com.chronos.calc.cst.Cst00;
import com.chronos.calc.dto.ITributavel;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author John Vanderson M L
 */
public class Cst00Test {

    public Cst00Test() {
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
    public void TestaCalculoCst00() throws TributacaoException {
        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(18));

        Cst00 cst = new Cst00();

        cst.calcular(tributos);

        BigDecimal valorIcm = cst.getValorIcms();
        BigDecimal percentual = cst.getPercentualIcms();

        assertEquals(BigDecimal.valueOf(18).setScale(2), percentual);
        assertEquals(BigDecimal.valueOf(180).setScale(2), valorIcm);

    }
}
