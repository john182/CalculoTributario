/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.cst.Cst90;
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
public class Cst90Test {
    
    public Cst90Test() {
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
    public void CalculoCst90ICMSProprio() {
        ITributavel tributos = new ITributavel();
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualReducao(BigDecimal.valueOf(10));
        
        Cst90 cst = new Cst90();
        cst.calcular(tributos);
        
        BigDecimal percentualIcms = cst.getPercentualIcms();        
        BigDecimal valorIcms = cst.getValorIcms();
        BigDecimal valorBcIcms = cst.getValorBcIcms();
        
        assertEquals(BigDecimal.valueOf(90).setScale(2), valorBcIcms);        
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcms);
        assertEquals(BigDecimal.valueOf(16.20).setScale(2), valorIcms);
    }
    
    @Test
    public void CalculoCst90ICMSST() {
        ITributavel tributos = new ITributavel();
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setPercentualReducao(BigDecimal.valueOf(10));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualMva(BigDecimal.valueOf(100));
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));
        
        
        
        
        Cst90 cst = new Cst90();
        cst.calcular(tributos);
        
      
        BigDecimal percentualMva = cst.getPercentualMva();
        BigDecimal percentualIcmsST = cst.getPercentualIcmsSt();
        BigDecimal percentualReducaoST = cst.getPercentualReducaoSt();
        BigDecimal valorIcmsST = cst.getValorIcmsSt();
        BigDecimal valorBaseCalcST = cst.getValorBcIcmsSt();
   
        
        assertEquals(BigDecimal.valueOf(100).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(162).setScale(2), valorBaseCalcST);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);
        assertEquals(BigDecimal.valueOf(12.96).setScale(2), valorIcmsST);
        
        
        
    }
}
