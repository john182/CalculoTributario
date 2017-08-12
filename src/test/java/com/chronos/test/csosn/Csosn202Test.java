/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.csosn;

import com.chronos.calc.csosn.Csosn202;
import com.chronos.calc.dto.ITributavel;
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
public class Csosn202Test {

    public Csosn202Test() {
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
    public void TestaCsosn202() {
        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setPercentualIpi(BigDecimal.valueOf(15));
        tributos.setPercentualMva(BigDecimal.valueOf(40));

        Csosn202 csosn = new Csosn202();

        csosn.calcular(tributos);

       
        BigDecimal percentualMva = csosn.getPercentualMva();
        BigDecimal percentualIcmsST = csosn.getPercentualIcmsSt();
        BigDecimal percentualReducaoST = csosn.getPercentualReducaoSt();
        BigDecimal valorIcmsST = csosn.getValorIcmsSt();
        BigDecimal valorBaseCalcST = csosn.getValorBcIcmsSt();
       

       

        assertEquals(BigDecimal.valueOf(40).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);
        assertEquals(BigDecimal.ZERO.setScale(2), percentualReducaoST);
        assertEquals(BigDecimal.valueOf(219.60).setScale(2), valorIcmsST);
        assertEquals(BigDecimal.valueOf(3220).setScale(2), valorBaseCalcST);
    }
}
