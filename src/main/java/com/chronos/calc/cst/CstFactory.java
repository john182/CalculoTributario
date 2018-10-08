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
package com.chronos.calc.cst;

import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.OrigemMercadoria;

/**
 *
 * @author Renan Esposte
 */
public class CstFactory {

    private CstFactory() {
    }

    public static CstBase getCst(Cst cst) {
        switch (cst) {
            case Cst00:
                return new Cst00();
            case Cst10:
                return new Cst10();
            case Cst20:
                return new Cst20();
            case Cst30:
                return new Cst30();
            case Cst40:
                return new Cst40();
            case Cst41:
                return new Cst41();
            case Cst50:
                return new Cst50();
            case Cst51:
                return new Cst51();
            case Cst60:
                return new Cst60();
            case Cst70:
                return new Cst70();
            case Cst90:
                return new Cst90();
            default:
                throw new IllegalArgumentException("Não foi possível construir o CST. Não implementado.");
        }
    }

    public static CstBase getCst(Cst cst, OrigemMercadoria origemMercadoria) {
        switch (cst) {
            case Cst00:
                return new Cst00(origemMercadoria);
            case Cst10:
                return new Cst10(origemMercadoria);
            case Cst20:
                return new Cst20(origemMercadoria);
            case Cst30:
                return new Cst30(origemMercadoria);
            case Cst40:
                return new Cst40(origemMercadoria);
            case Cst41:
                return new Cst41(origemMercadoria);
            case Cst50:
                return new Cst50(origemMercadoria);
            case Cst51:
                return new Cst51(origemMercadoria);
            case Cst60:
                return new Cst60(origemMercadoria);
            case Cst70:
                return new Cst70(origemMercadoria);
            case Cst90:
                return new Cst90(origemMercadoria);
            default:
                throw new IllegalArgumentException("Não foi possível construir o CST. Não implementado.");
        }

    }
}
