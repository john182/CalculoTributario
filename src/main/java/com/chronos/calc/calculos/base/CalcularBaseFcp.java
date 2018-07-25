package com.chronos.calc.calculos.base;

import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.enuns.TipoDesconto;

public class CalcularBaseFcp extends CalcularBaseICMS {


    public CalcularBaseFcp(ITributavel tributos, TipoDesconto desconto) {
        super(tributos, desconto);
    }
}
