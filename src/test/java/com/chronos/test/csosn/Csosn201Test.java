/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.csosn;

import com.chronos.calc.csosn.Csosn201;
import com.chronos.calc.dto.ITributavel;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author John Vanderson M L
 */
public class Csosn201Test {

    public Csosn201Test() {
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
    public void TestaCsosn201() {
        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualCredito(BigDecimal.valueOf(5));
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setPercentualIpi(BigDecimal.valueOf(15));
        tributos.setPercentualMva(BigDecimal.valueOf(40));

        Csosn201 csosn = new Csosn201();

        csosn.calcular(tributos);

        BigDecimal percentualCredito = csosn.getPercentualCredito();
        BigDecimal percentualMva = csosn.getPercentualMva();
        BigDecimal percentualIcmsST = csosn.getPercentualIcmsSt();
        BigDecimal percentualReducaoST = csosn.getPercentualReducaoSt();
        BigDecimal valorIcmsST = csosn.getValorIcmsSt();
        BigDecimal valorBaseCalcST = csosn.getValorBcIcmsSt();
        BigDecimal valorCredito = csosn.getValorCredito();

        assertEquals(BigDecimal.valueOf(100).setScale(2), valorCredito);
        assertEquals(BigDecimal.valueOf(5).setScale(2), percentualCredito);

        assertEquals(BigDecimal.valueOf(40).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);
        assertEquals(BigDecimal.ZERO.setScale(2), percentualReducaoST);
        assertEquals(BigDecimal.valueOf(219.60).setScale(2), valorIcmsST);
        assertEquals(BigDecimal.valueOf(3220).setScale(2), valorBaseCalcST);
    }
}
