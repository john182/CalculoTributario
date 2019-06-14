/* 
 * The MIT License
 *
 * Copyright 2017 Chronusinfo.
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
package com.chronos.calc.dto;

import com.chronos.calc.enuns.Csosn;
import com.chronos.calc.enuns.Cst;
import com.chronos.calc.enuns.CstIpi;
import com.chronos.calc.enuns.CstPisCofins;

/**
 *
 * @author John Vanderson M L
 */
public class TributosProduto extends ITributavel {

    private boolean servico;
    private Cst cst;
    private Csosn csosn;
    private CstIpi cstIpi;
    private CstPisCofins cstPisCofins;

    public TributosProduto() {
        this.servico = false;
    }

    public Cst getCst() {
        return cst;
    }

    public void setCst(Cst cst) {
        this.cst = cst;
    }

    public Csosn getCsosn() {
        return csosn;
    }

    public void setCsosn(Csosn csosn) {
        this.csosn = csosn;
    }

    public CstIpi getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(CstIpi cstIpi) {
        this.cstIpi = cstIpi;
    }

    public CstPisCofins getCstPisCofins() {
        return cstPisCofins;
    }

    public void setCstPisCofins(CstPisCofins cstPisCofins) {
        this.cstPisCofins = cstPisCofins;
    }

    public boolean isServico() {
        return servico;
    }

    public void setServico(boolean servico) {
        this.servico = servico;
    }

}
