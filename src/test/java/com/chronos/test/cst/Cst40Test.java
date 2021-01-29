package com.chronos.test.cst;

import com.chronos.calc.cst.Cst40;
import com.chronos.calc.dto.ITributavel;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class Cst40Test {

    @Test
    public void TestaCalculoCst40SemReducao() {

        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(31000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(0.2));

        Cst40 cst = new Cst40();

        cst.calcular(tributos);

        BigDecimal valorIcmsDesoneado = cst.getValorIcmsDesoneado();

        BigDecimal valorEsperado = BigDecimal.valueOf(7750).setScale(2, RoundingMode.HALF_UP);

        assertEquals(valorEsperado, valorIcmsDesoneado);

    }

    @Test
    public void TestaCalculoCst40ComReducao() {

        ITributavel tributos = new ITributavel();
        tributos.setValorProduto(BigDecimal.valueOf(31000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(0.2));
        tributos.setPercentualReducao(BigDecimal.valueOf(0.5));

        Cst40 cst = new Cst40();

        cst.calcular(tributos);

        BigDecimal valorIcmsDesoneado = cst.getValorIcmsDesoneado().setScale(2, RoundingMode.HALF_UP);

        BigDecimal valorEsperado = BigDecimal.valueOf(3875).setScale(2, RoundingMode.HALF_UP);

        assertEquals(valorEsperado, valorIcmsDesoneado);

    }
}
