/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoIbpt;
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
public class CalculoIbptTest {

    public CalculoIbptTest() {
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
    public void CalculaIbpt() {

        ITributavel tributos = new ITributavel();

        tributos.setValorProduto(BigDecimal.valueOf(1000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualFederal(BigDecimal.valueOf(10));
        tributos.setPercentualFederalImportados(BigDecimal.valueOf(20));
        tributos.setPercentualEstadual(BigDecimal.valueOf(15));
        tributos.setPercentualMunicipal(BigDecimal.ZERO);

        CalcTributacao calcular = new CalcTributacao(tributos);

        IResultadoCalculoIbpt result = calcular.calculaIbpt(tributos);

        BigDecimal tributacaoEstadual = result.getTributacaoEstadual();
        BigDecimal tributacaoEstadualTest = BigDecimal.valueOf(150).setScale(2);

        BigDecimal tributacaoFederal = result.getTributacaoFederal();
        BigDecimal tributacaoFederalTest = BigDecimal.valueOf(100).setScale(2);

        BigDecimal tributacaoFederalImp = result.getTributacaoFederalImportados();
        BigDecimal tributacaoFederalImpTest = BigDecimal.valueOf(200).setScale(2);

        BigDecimal tributacaoMunicipal = result.getTributacaoMunicipal();
        BigDecimal tributacaoMunicipalTest = BigDecimal.ZERO.setScale(2);
        
        assertEquals(tributacaoEstadualTest, tributacaoEstadual);
        assertEquals(tributacaoFederalTest, tributacaoFederal);
        assertEquals(tributacaoFederalImpTest, tributacaoFederalImp);
        assertEquals(tributacaoMunicipalTest, tributacaoMunicipal);

    }
}
