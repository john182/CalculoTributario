/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chronos.calc.enuns;

/**
 *
 * @author John Vanderson M L
 */
public enum Cst {
    
    Cst00(00, "00 - Tributada integralmente"),
    Cst10(10, "10 - Tributada e com cobrança do ICMS por substituição tributária"),
    Cst20(20, "20 - Com redução de Base de Cálculo"),
    Cst30(30, "30 - Isenta ou não tributada e com cobrança do ICMS por substituição tributária"),
    Cst40(40, "40 - Isenta"),
    Cst41(41, "41 - Não tributada"),
    Cst50(50, "50 - Com suspensão"),
    Cst51(51, "51 - Com diferimento"),
    Cst60(60, "60 - ICMS cobrado anteriormente por substituição tributária"),
    Cst70(70, "70 - Com redução da Base de Cálculo e cobrança do ICMS por substituição tributária"),
    Cst90(90, "90 - Outros");

    private String descricao;
    private Integer codigo;

    Cst(Integer codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}
