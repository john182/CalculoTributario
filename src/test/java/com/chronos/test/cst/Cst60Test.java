package com.chronos.test.cst;

import com.chronos.calc.cst.Cst60;
import com.chronos.calc.dto.ITributavel;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Cst60Test {

    @Test
    public void CalculoCst60() {
        ITributavel tributos = new ITributavel();

        tributos.setPercentualIcmsSt(BigDecimal.valueOf(18));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setValorProduto(BigDecimal.valueOf(1000));

        Cst60 cst = new Cst60();
        cst.calcular(tributos);

        BigDecimal baseCalcST = cst.getIcmsDto().getValorBcStRetido();
        BigDecimal valorIcmsST = cst.getIcmsDto().getValorIcmsStRetido();
        BigDecimal percentualIcmsST = cst.getIcmsDto().getPercentualBcStRetido();


        assertEquals(BigDecimal.valueOf(1000).setScale(2), baseCalcST);
        assertEquals(BigDecimal.valueOf(18), percentualIcmsST);
        assertEquals(BigDecimal.valueOf(180).setScale(2), valorIcmsST);
    }


}
