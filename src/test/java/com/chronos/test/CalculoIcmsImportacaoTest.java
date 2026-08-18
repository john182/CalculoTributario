package com.chronos.test;

import com.chronos.calc.CalcTributacao;
import com.chronos.calc.dto.ITributavel;
import com.chronos.calc.resultados.IResultadoCalculoIcms;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Base de cálculo do ICMS na importação direta (Lei Kandir art. 13, §1º-I): Valor Aduaneiro (CIF)
 * + II + IPI + PIS-Importação + COFINS-Importação + despesas aduaneiras, com "cálculo por dentro"
 * (divisão por 1 - alíquota). A legislação não menciona "valor do produto" — a base de importação
 * usa exclusivamente os dados da própria Declaração de Importação ({@code valorAduaneiro}), nunca
 * {@code valorProduto} (que é só o valor comercial digitado pelo chamador, sem relação garantida
 * com o CIF).
 *
 * @author John Vanderson M L
 */
public class CalculoIcmsImportacaoTest {

    private ITributavel tributos;
    private CalcTributacao calcular;

    @Before
    public void setUp() {
        tributos = new ITributavel();
        calcular = new CalcTributacao(tributos);
    }

    /**
     * Exemplo prático: Valor Aduaneiro R$ 10.000,00; II 10% = R$ 1.000,00; IPI 10% sobre
     * (Aduaneiro + II) = R$ 1.100,00; PIS-Importação 2,1% = R$ 210,00; COFINS-Importação 9,65% =
     * R$ 965,00; despesas aduaneiras R$ 500,00; alíquota ICMS 18%.
     * Soma = 10.000 + 1.000 + 1.100 + 210 + 965 + 500 = R$ 13.775,00
     * Base ICMS = 13.775,00 / (1 - 0,18) = R$ 16.798,78
     * Valor ICMS = 16.798,78 * 18% = R$ 3.023,78
     */
    @Test
    public void dadoOperacaoDeImportacaoDireta_quandoCalcularIcms_entaoDeveAplicarCalculoPorDentroComTodosOsComponentes() {
        tributos.setValorAduaneiro(BigDecimal.valueOf(10000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setValorImpostoImportacao(BigDecimal.valueOf(1000));
        tributos.setValorDespesasAduaneiras(BigDecimal.valueOf(500));
        tributos.setValorIpi(BigDecimal.valueOf(1100));
        tributos.setValorPis(BigDecimal.valueOf(210));
        tributos.setValorCofins(BigDecimal.valueOf(965));

        IResultadoCalculoIcms resultado = calcular.calcularIcms();

        assertEquals(new BigDecimal("16798.78"), resultado.getBaseCalculo());
        assertEquals(new BigDecimal("3023.78"), resultado.getValor());
    }

    /**
     * A base do IPI é Valor Aduaneiro + II — não depende de valorProduto.
     */
    @Test
    public void dadoOperacaoDeImportacaoDireta_quandoCalcularIpi_entaoBaseDeveSerValorAduaneiroMaisIi() {
        tributos.setValorAduaneiro(BigDecimal.valueOf(10000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIpi(BigDecimal.TEN);
        tributos.setValorImpostoImportacao(BigDecimal.valueOf(1000));

        BigDecimal baseIpi = calcular.calcularIpi().getBaseCalculo();

        assertEquals(new BigDecimal("11000.00"), baseIpi);
    }

    /**
     * valorProduto não deve influenciar em nada o cálculo de importação — mesmo com um valor bem
     * diferente do Valor Aduaneiro, a base do IPI/ICMS ignora valorProduto por completo.
     */
    @Test
    public void dadoValorProdutoDiferenteDoValorAduaneiro_quandoCalcularIpi_entaoValorProdutoDeveSerIgnorado() {
        tributos.setValorProduto(new BigDecimal("99999.99"));
        tributos.setValorAduaneiro(BigDecimal.valueOf(10000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIpi(BigDecimal.TEN);
        tributos.setValorImpostoImportacao(BigDecimal.valueOf(1000));

        BigDecimal baseIpi = calcular.calcularIpi().getBaseCalculo();

        assertEquals(new BigDecimal("11000.00"), baseIpi);
    }

    /**
     * Reconciliação com nota fiscal real de importação (item 1 do espelho): Valor Aduaneiro
     * R$ 1.098,83, II R$ 118,67, IPI R$ 79,14 (6,5% sobre Aduaneiro + II), PIS R$ 23,08, COFINS
     * R$ 106,04, despesa aduaneira (Tx. Siscomex) R$ 135,08, ICMS 19%.
     * Soma = 1.098,83 + 118,67 + 79,14 + 23,08 + 106,04 + 135,08 = R$ 1.560,84
     * Base ICMS = 1.560,84 / (1 - 0,19) = R$ 1.926,96
     * Valor ICMS = 1.926,96 * 19% = R$ 366,12
     */
    @Test
    public void dadoItemDeNotaFiscalRealDeImportacao_quandoCalcularIcms_entaoDeveReproduzirBaseEValorDoEspelho() {
        tributos.setValorAduaneiro(new BigDecimal("1098.83"));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(19));
        tributos.setValorImpostoImportacao(new BigDecimal("118.67"));
        tributos.setValorIpi(new BigDecimal("79.14"));
        tributos.setValorPis(new BigDecimal("23.08"));
        tributos.setValorCofins(new BigDecimal("106.04"));
        tributos.setValorDespesasAduaneiras(new BigDecimal("135.08"));

        IResultadoCalculoIcms resultado = calcular.calcularIcms();

        assertEquals(new BigDecimal("1926.96"), resultado.getBaseCalculo());
        assertEquals(new BigDecimal("366.12"), resultado.getValor());
    }

    /**
     * Mesma reconciliação acima, mas de ponta a ponta: IPI/PIS/COFINS são calculados pelo motor
     * (não informados prontos), confirmando que o arredondamento HALF_UP de cada componente
     * reproduz o mesmo resultado do espelho.
     */
    @Test
    public void dadoItemDeNotaFiscalRealDeImportacao_quandoCalcularTudoDePontaAPonta_entaoDeveReproduzirBaseEValorDoEspelho() {
        tributos.setValorAduaneiro(new BigDecimal("1098.83"));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(19));
        tributos.setValorImpostoImportacao(new BigDecimal("118.67"));
        tributos.setPercentualIpi(BigDecimal.valueOf(6.5));
        tributos.setPercentualPis(BigDecimal.valueOf(2.1));
        tributos.setPercentualCofins(BigDecimal.valueOf(9.65));
        tributos.setValorDespesasAduaneiras(new BigDecimal("135.08"));

        tributos.setValorIpi(calcular.calcularIpi().getValor());
        tributos.setValorPis(calcular.calcularPis().getValor());
        tributos.setValorCofins(calcular.calcularCofins().getValor());

        IResultadoCalculoIcms resultado = calcular.calcularIcms();

        assertEquals(new BigDecimal("79.14"), tributos.getValorIpi());
        assertEquals(new BigDecimal("23.08"), tributos.getValorPis());
        assertEquals(new BigDecimal("106.04"), tributos.getValorCofins());
        assertEquals(new BigDecimal("1926.96"), resultado.getBaseCalculo());
        assertEquals(new BigDecimal("366.12"), resultado.getValor());
    }

    /**
     * Reconciliação com teste real reportado: 149 unidades a R$ 8,63 (valorProduto = R$ 1.285,87,
     * bem diferente do Valor Aduaneiro — não deve entrar na conta), Valor Aduaneiro R$ 1.098,83,
     * II R$ 118,67, IPI 6,5% sobre (Aduaneiro + II) = R$ 79,14 (arredondado, não truncado — mesma
     * convenção usada em todo o resto da lib), PIS/COFINS zerados (alíquota 0% na configuração),
     * sem despesas aduaneiras, ICMS 19%.
     * Soma = 1.098,83 + 118,67 + 79,14 + 0 + 0 + 0 = R$ 1.296,64
     * Base ICMS = 1.296,64 / (1 - 0,19) = R$ 1.600,79
     * Valor ICMS = 1.600,79 * 19% = R$ 304,15
     */
    @Test
    public void dadoValorProdutoDivergenteDoValorAduaneiroEPisCofinsZerados_quandoCalcularIcms_entaoBaseDeveUsarSomenteValorAduaneiro() {
        tributos.setValorProduto(new BigDecimal("8.63"));
        tributos.setQuantidadeProduto(BigDecimal.valueOf(149));
        tributos.setValorAduaneiro(new BigDecimal("1098.83"));
        tributos.setPercentualIcms(BigDecimal.valueOf(19));
        tributos.setValorImpostoImportacao(new BigDecimal("118.67"));
        tributos.setPercentualIpi(BigDecimal.valueOf(6.5));
        tributos.setValorPis(BigDecimal.ZERO);
        tributos.setValorCofins(BigDecimal.ZERO);

        BigDecimal valorIpi = calcular.calcularIpi().getValor();
        tributos.setValorIpi(valorIpi);

        IResultadoCalculoIcms resultado = calcular.calcularIcms();

        assertEquals(new BigDecimal("79.14"), valorIpi);
        assertEquals(new BigDecimal("1600.79"), resultado.getBaseCalculo());
        assertEquals(new BigDecimal("304.15"), resultado.getValor());
    }

    @Test
    public void dadoOperacaoSemImpostoDeImportacao_quandoCalcularIcms_entaoNaoDeveAplicarCalculoPorDentro() {
        tributos.setValorProduto(BigDecimal.valueOf(10000));
        tributos.setQuantidadeProduto(BigDecimal.ONE);
        tributos.setPercentualIcms(BigDecimal.valueOf(18));
        tributos.setPercentualPis(BigDecimal.valueOf(2.1));
        tributos.setPercentualCofins(BigDecimal.valueOf(9.65));

        IResultadoCalculoIcms resultado = calcular.calcularIcms();

        assertEquals(new BigDecimal("10000.00"), resultado.getBaseCalculo());
        assertFalse(tributos.isOperacaoImportacao());
    }

    @Test
    public void dadoValorImpostoImportacaoMaiorQueZero_quandoVerificarOperacaoImportacao_entaoDeveSerVerdadeiro() {
        tributos.setValorImpostoImportacao(BigDecimal.valueOf(0.01));

        assertTrue(tributos.isOperacaoImportacao());
    }

    @Test
    public void dadoValorImpostoImportacaoNulo_quandoVerificarOperacaoImportacao_entaoDeveSerFalso() {
        assertFalse(tributos.isOperacaoImportacao());
    }
}
