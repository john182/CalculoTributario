package com.chronos.test;

import com.chronos.calc.TributaNFe;
import com.chronos.calc.TributacaoException;
import com.chronos.calc.dto.Imposto;
import com.chronos.calc.dto.TributosProduto;
import com.chronos.calc.enuns.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TributaNFeTest {


    private TributaNFe tributaNFe;
    private TributosProduto produto;


    @Before
    public void before() {

        produto = new TributosProduto();

        produto.setQuantidadeProduto(BigDecimal.ONE);
        produto.setValorProduto(BigDecimal.valueOf(1000));

        produto.setPercentualIcms(BigDecimal.valueOf(17));
        produto.setCst(Cst.Cst00);


        produto.setPercentualIpi(BigDecimal.valueOf(17));
        produto.setCstIpi(CstIpi.Cst00);

        produto.setCstPisCofins(CstPisCofins.Cst01);
        produto.setPercentualPis(BigDecimal.valueOf(1.65));
        produto.setPercentualCofins(BigDecimal.valueOf(3.00));

    }

    @Test
    public void devemos_garantir_que_seja_gerado_valores_de_icms_ipi_pis_cofins() throws TributacaoException {
        tributaNFe = new TributaNFe(produto);

        Imposto imposto = tributaNFe.tributarNfe(Crt.RegimeNormal, TipoOperacao.OperacaoInterna, TipoPessoa.Fisica);

        BigDecimal valorIpi = BigDecimal.valueOf(170).setScale(2);
        BigDecimal valorIcms = BigDecimal.valueOf(198.90).setScale(2);

        BigDecimal valorCofins = BigDecimal.valueOf(30).setScale(2);
        BigDecimal valorPis = BigDecimal.valueOf(16.50).setScale(2);

        assertEquals(valorIpi, imposto.getIpi().getValorIpi());
        assertEquals(valorIcms, imposto.getIcms().getValorIcms());
        assertEquals(valorCofins, imposto.getCofins().getValor());
        assertEquals(valorPis, imposto.getPis().getValor());

    }

    @Test
    public void devemos_garantir_que_seja_gerado_valores_de_icms_ipi_pis_cofins_com_desconto() throws TributacaoException {

        produto.setQuantidadeProduto(BigDecimal.valueOf(2));
        produto.setDesconto(BigDecimal.valueOf(1000));

        tributaNFe = new TributaNFe(produto);

        Imposto imposto = tributaNFe.tributarNfe(Crt.RegimeNormal, TipoOperacao.OperacaoInterna, TipoPessoa.Fisica);

        BigDecimal valorIpi = BigDecimal.valueOf(170).setScale(2);
        BigDecimal valorIcms = BigDecimal.valueOf(198.90).setScale(2);

        BigDecimal valorCofins = BigDecimal.valueOf(30).setScale(2);
        BigDecimal valorPis = BigDecimal.valueOf(16.50).setScale(2);

        assertEquals(valorIpi, imposto.getIpi().getValorIpi());
        assertEquals(valorIcms, imposto.getIcms().getValorIcms());
        assertEquals(valorCofins, imposto.getCofins().getValor());
        assertEquals(valorPis, imposto.getPis().getValor());

    }

    @Test
    public void devmos_garantir_gerar_valores_para_o_sismples_nascional() throws TributacaoException {

        produto.setPercentualCredito(BigDecimal.valueOf(1.47));

        produto.setCsosn(Csosn.Csosn101);
        produto.setCstPisCofins(CstPisCofins.Cst07);
        produto.setCstIpi(CstIpi.Cst02);

        tributaNFe = new TributaNFe(produto);

        Imposto imposto = tributaNFe.tributarNfe(Crt.SimplesNacional, TipoOperacao.OperacaoInterna, TipoPessoa.Fisica);


        BigDecimal valorCreditoIcms = BigDecimal.valueOf(14.7).setScale(2);

        assertEquals(valorCreditoIcms, imposto.getIcms().getValorCredito());
        assertNull(imposto.getCofins());
        assertNull(imposto.getPis());
        assertNull(imposto.getIpi());
    }


}
