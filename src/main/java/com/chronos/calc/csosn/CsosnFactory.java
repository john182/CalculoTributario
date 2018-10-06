/*
 * The MIT License
 *
 * Copyright 2017 Chronosinfo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.chronos.calc.csosn;

import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author Renan Esposte
 */
public class CsosnFactory {

    public static CsosnBase createCsosn(Csosn csosn) {

        switch (csosn) {
            case Csosn101:
                return new Csosn101();
            case Csosn102:
                return new Csosn102();
            case Csosn103:
                return new Csosn103();
            case Csosn201:
                return new Csosn201();
            case Csosn202:
                return new Csosn202();
            case Csosn203:
                return new Csosn203();
            case Csosn300:
                return new Csosn300();
            case Csosn400:
                return new Csosn400();
            case Csosn500:
                return new Csosn500();
            case Csosn900:
                return new Csosn900();
            default:
                throw new IllegalArgumentException("Não foi possível construir o CSOSN. Não implementado.");
        }

    }

    public static CsosnBase createCsosn(Csosn csosn, OrigemMercadoria origemMercadoria) {

        switch (csosn) {
            case Csosn101:
                return new Csosn101(origemMercadoria);
            case Csosn102:
                return new Csosn102(origemMercadoria);
            case Csosn103:
                return new Csosn103(origemMercadoria);
            case Csosn201:
                return new Csosn201(origemMercadoria);
            case Csosn202:
                return new Csosn202(origemMercadoria);
            case Csosn203:
                return new Csosn203(origemMercadoria);
            case Csosn300:
                return new Csosn300(origemMercadoria);
            case Csosn400:
                return new Csosn400(origemMercadoria);
            case Csosn500:
                return new Csosn500(origemMercadoria);
            case Csosn900:
                return new Csosn900(origemMercadoria);
            default:
                throw new IllegalArgumentException("Não foi possível construir o CSOSN. Não implementado.");
        }

    }

}
