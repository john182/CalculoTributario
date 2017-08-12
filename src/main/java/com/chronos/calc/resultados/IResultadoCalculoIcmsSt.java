/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.resultados;

import java.math.BigDecimal;

/**
 *
 * @author John Vanderson M L
 */
public interface IResultadoCalculoIcmsSt {

    BigDecimal getBaseCalculoOperacaoPropria();

    BigDecimal getValorIcmsProprio();

    BigDecimal getBaseCalculoIcmsSt();

    BigDecimal getValorIcmsSt();
}
