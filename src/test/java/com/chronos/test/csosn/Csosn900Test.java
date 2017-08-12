/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.csosn;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.csosn.Csosn900;
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
public class Csosn900Test {

    private ITributavel tributos;
    private CalcTributacao calcular;
    private Csosn900 csosn;

    public Csosn900Test() {
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
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setValorProduto(BigDecimal.valueOf(2000));
        tributos.setPercentualCredito(BigDecimal.valueOf(17));
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setPercentualIpi(BigDecimal.valueOf(15));
        tributos.setPercentualMva(BigDecimal.valueOf(40));
        calcular = new CalcTributacao(tributos);
        csosn = new Csosn900();
    }

    @After
    public void tearDown() {
        tributos = new ITributavel();
        calcular = new CalcTributacao(tributos);
        csosn = new Csosn900();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TestaCsosn900() {

        csosn.calcular(tributos);

        BigDecimal percentualCredito = csosn.getPercentualCredito();
        BigDecimal percentualMva = csosn.getPercentualMva();
        BigDecimal percentualIcmsST = csosn.getPercentualIcmsSt();
        BigDecimal percentualReducaoST = csosn.getPercentualReducaoSt();
        BigDecimal valorIcmsST = csosn.getValorIcmsSt();
        BigDecimal valorBaseCalcST = csosn.getValorBcIcmsSt();
        BigDecimal valorCredito = csosn.getValorCredito();
        BigDecimal valorIcms = csosn.getValorIcms();
        BigDecimal valorBcIcms = csosn.getValorBcIcms();

        assertEquals(BigDecimal.valueOf(391).setScale(2), valorCredito);
        assertEquals(BigDecimal.valueOf(17).setScale(2), percentualCredito);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);
        assertEquals(BigDecimal.valueOf(40).setScale(2), percentualMva);
        assertEquals(BigDecimal.ZERO.setScale(2), percentualReducaoST);
        assertEquals(BigDecimal.valueOf(3220).setScale(2), valorBaseCalcST);
        assertEquals(BigDecimal.valueOf(219.60).setScale(2), valorIcmsST);
        assertEquals(BigDecimal.valueOf(414).setScale(2), valorIcms);
        assertEquals(BigDecimal.valueOf(2300).setScale(2), valorBcIcms);

    }

    @Test
    public void TestaCsosn900ComReducaoSt() {
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));

        csosn.calcular(tributos);

        BigDecimal percentualCredito = csosn.getPercentualCredito();
        BigDecimal percentualMva = csosn.getPercentualMva();
        BigDecimal percentualIcmsST = csosn.getPercentualIcmsSt();
        BigDecimal percentualReducaoST = csosn.getPercentualReducaoSt();
        BigDecimal valorIcmsST = csosn.getValorIcmsSt();
        BigDecimal valorBaseCalcST = csosn.getValorBcIcmsSt();
        BigDecimal valorCredito = csosn.getValorCredito();
        BigDecimal valorIcms = csosn.getValorIcms();
        BigDecimal valorBcIcms = csosn.getValorBcIcms();

        assertEquals(BigDecimal.valueOf(391).setScale(2), valorCredito);
        assertEquals(BigDecimal.valueOf(17).setScale(2), percentualCredito);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);
        assertEquals(BigDecimal.valueOf(40).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);
        assertEquals(BigDecimal.valueOf(2898).setScale(2), valorBaseCalcST);
        assertEquals(BigDecimal.valueOf(161.64).setScale(2), valorIcmsST);
        assertEquals(BigDecimal.valueOf(414).setScale(2), valorIcms);
        assertEquals(BigDecimal.valueOf(2300).setScale(2), valorBcIcms);
    }
}
