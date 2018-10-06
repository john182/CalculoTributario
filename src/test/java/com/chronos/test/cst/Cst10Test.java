/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.TributacaoException;
import com.chronos.calc.cst.Cst10;
import com.chronos.calc.dto.ITributavel;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author John Vanderson M L
 */
public class Cst10Test {

    public Cst10Test() {
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
    public void CalculoCST10() throws TributacaoException {
        ITributavel tributos = new ITributavel();
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualMva(BigDecimal.valueOf(50));
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));

        Cst10 cst = new Cst10();

        cst.calcular(tributos);

        BigDecimal baseCalcIcms = cst.getValorBcIcms();
        BigDecimal percentualIcms = cst.getPercentualIcms();
        BigDecimal percentualMva = cst.getPercentualMva();
        BigDecimal percentualReducaoST = cst.getPercentualReducaoSt();
        BigDecimal baseCalcST = cst.getValorBcIcmsSt();
        BigDecimal valorIcmsST = cst.getValorIcmsSt();
        BigDecimal percentualIcmsST = cst.getPercentualIcmsSt();

        assertEquals(BigDecimal.valueOf(100.00).setScale(2), baseCalcIcms);
        assertEquals(BigDecimal.valueOf(18.00).setScale(2), percentualIcms);

        assertEquals(BigDecimal.valueOf(50).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);

        assertEquals(BigDecimal.valueOf(135).setScale(2), baseCalcST);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);

        assertEquals(BigDecimal.valueOf(6.30).setScale(2), valorIcmsST);

    }
}
