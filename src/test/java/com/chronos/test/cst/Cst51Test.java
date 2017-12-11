/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.cst.Cst51;
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
public class Cst51Test {

    public Cst51Test() {
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
    public void CalculoCST51() {

        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualDiferimento(BigDecimal.valueOf(33.33));

        Cst51 cst = new Cst51();

        cst.calcular(tributos);
        BigDecimal valoBCIcms = cst.getValorBcIcms();
        BigDecimal valorIcm = cst.getValorIcms();
        BigDecimal percentual = cst.getPercentualIcms();
        BigDecimal valorIcmsOperacao = cst.getValorIcmsOperacao();
        BigDecimal percentualDiferimento = cst.getPercentualDiferimento();
        BigDecimal valorIcmsDeferido = cst.getValorIcmsDiferido();

        assertEquals(BigDecimal.valueOf(1000).setScale(2), valoBCIcms);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentual);
        assertEquals(BigDecimal.valueOf(180).setScale(2), valorIcmsOperacao);
        assertEquals(BigDecimal.valueOf(33.33).setScale(2), percentualDiferimento);
        assertEquals(BigDecimal.valueOf(60).setScale(2), valorIcmsDeferido);
        assertEquals(BigDecimal.valueOf(120).setScale(2), valorIcm);
    }
}
