/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.cst.Cst70;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.ModalidadeDeterminacaoBcIcms;
import com.chronos.calc.enuns.ModalidadeDeterminacaoBcIcmsSt;
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
public class Cst70Test {

    public Cst70Test() {
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
    public void CalculoCst70() {

        ITributavel tributos = new ITributavel();

        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualMva(BigDecimal.valueOf(100));
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));
        tributos.setPercentualReducao(BigDecimal.valueOf(10));

        Cst70 cst = new Cst70();

        cst.calcular(tributos);

        BigDecimal baseCalcIcms = cst.getValorBcIcms();
        BigDecimal percentualIcms = cst.getPercentualIcms();
        BigDecimal valorIcms = cst.getValorIcms();
        BigDecimal percentualMva = cst.getPercentualMva();
        BigDecimal percentualReducaoST = cst.getPercentualReducaoSt();
        BigDecimal percentualReducao = cst.getPercentualReducao();
        BigDecimal baseCalcST = cst.getValorBcIcmsSt();
        BigDecimal valorIcmsST = cst.getValorIcmsSt();
        BigDecimal percentualIcmsST = cst.getPercentualIcmsSt();

        assertEquals(cst.getModalidadeDeterminacaoBcIcms(), ModalidadeDeterminacaoBcIcms.ValorOperacao);

        assertEquals(BigDecimal.valueOf(10.00).setScale(2), percentualReducao);
        assertEquals(BigDecimal.valueOf(90.00).setScale(2), baseCalcIcms);
        assertEquals(BigDecimal.valueOf(18.00).setScale(2), percentualIcms);
        assertEquals(BigDecimal.valueOf(16.20).setScale(2), valorIcms);
        
        assertEquals(cst.getModalidadeDeterminacaoBcIcmsSt(), ModalidadeDeterminacaoBcIcmsSt.MargemValorAgregado);

        assertEquals(BigDecimal.valueOf(100).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);

        assertEquals(BigDecimal.valueOf(162).setScale(2), baseCalcST);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);

        assertEquals(BigDecimal.valueOf(12.96).setScale(2), valorIcmsST);
    }
}
