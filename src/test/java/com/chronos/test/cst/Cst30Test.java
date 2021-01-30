/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.test.cst;

import com.chronos.calc.cst.Cst30;
import com.chronos.calc.dto.ITributavel;
import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author John Vanderson M L
 */
public class Cst30Test {

    public Cst30Test() {
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
    public void CalculoCST30() {
        ITributavel tributos = new ITributavel();

        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualMva(BigDecimal.valueOf(50));
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));

        Cst30 cst = new Cst30();

        cst.calcular(tributos);

        BigDecimal percentualMva = cst.getPercentualMva();
        BigDecimal percentualReducaoST = cst.getPercentualReducaoSt();
        BigDecimal baseCalcST = cst.getValorBcIcmsSt();
        BigDecimal valorIcmsST = cst.getValorIcmsSt();
        BigDecimal percentualIcmsST = cst.getPercentualIcmsSt();

        assertEquals(BigDecimal.valueOf(50).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);

        assertEquals(BigDecimal.valueOf(135).setScale(2), baseCalcST);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);

        assertEquals(BigDecimal.valueOf(24.30).setScale(2), valorIcmsST);
    }

    @Test
    public void CalculoCST30ComIcmsDesonerado() {
        ITributavel tributos = new ITributavel();

        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualMva(BigDecimal.valueOf(50));
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));
        tributos.setPercentualIcms(BigDecimal.valueOf(0.2));

        Cst30 cst = new Cst30();

        cst.calcular(tributos);

        BigDecimal percentualMva = cst.getPercentualMva();
        BigDecimal percentualReducaoST = cst.getPercentualReducaoSt();
        BigDecimal baseCalcST = cst.getValorBcIcmsSt();
        BigDecimal valorIcmsST = cst.getValorIcmsSt();
        BigDecimal percentualIcmsST = cst.getPercentualIcmsSt();
        BigDecimal valorIcmsDesoneado = cst.getValorIcmsDesoneado();
        BigDecimal valorIcmsDesoneadoEsperado = BigDecimal.valueOf(25).setScale(2, RoundingMode.HALF_UP);

        assertEquals(BigDecimal.valueOf(50).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);

        assertEquals(BigDecimal.valueOf(135).setScale(2), baseCalcST);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);

        assertEquals(BigDecimal.valueOf(24.30).setScale(2), valorIcmsST);

        assertEquals(valorIcmsDesoneadoEsperado, valorIcmsDesoneado);
    }

    @Test
    public void CalculoCST30ComIcmsDesoneradoComReducao() {
        ITributavel tributos = new ITributavel();

        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setValorProduto(BigDecimal.valueOf(100));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualMva(BigDecimal.valueOf(50));
        tributos.setPercentualReducaoSt(BigDecimal.valueOf(10));
        tributos.setPercentualIcms(BigDecimal.valueOf(0.2));
        tributos.setPercentualReducao(BigDecimal.valueOf(0.5));

        Cst30 cst = new Cst30();

        cst.calcular(tributos);

        BigDecimal percentualMva = cst.getPercentualMva();
        BigDecimal percentualReducaoST = cst.getPercentualReducaoSt();
        BigDecimal baseCalcST = cst.getValorBcIcmsSt();
        BigDecimal valorIcmsST = cst.getValorIcmsSt();
        BigDecimal percentualIcmsST = cst.getPercentualIcmsSt();
        BigDecimal valorIcmsDesoneado = cst.getValorIcmsDesoneado().setScale(2, RoundingMode.HALF_UP);
        BigDecimal valorIcmsDesoneadoEsperado = BigDecimal.valueOf(12.5).setScale(2, RoundingMode.HALF_UP);

        assertEquals(BigDecimal.valueOf(50).setScale(2), percentualMva);
        assertEquals(BigDecimal.valueOf(10).setScale(2), percentualReducaoST);

        assertEquals(BigDecimal.valueOf(135).setScale(2), baseCalcST);
        assertEquals(BigDecimal.valueOf(18).setScale(2), percentualIcmsST);

        assertEquals(BigDecimal.valueOf(24.30).setScale(2), valorIcmsST);

        assertEquals(valorIcmsDesoneadoEsperado, valorIcmsDesoneado);
    }
}
