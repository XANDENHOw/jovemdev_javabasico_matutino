import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_medicamento.EnumAdminitracao;
import exercicio_medicamento.Medicamento;
import exercicio_medicamento.Pessoa;
import exercicio_medicamento.Prescricao;
import exercicio_medicamento.Util;



public class UtilTest {
	
	private Util ut = new Util();

	
	@BeforeEach
	void iniciar() {
		ut.clearData();
		Pessoa p1 = new Pessoa("Maria", "Dor Muscular");
		Pessoa p2 = new Pessoa("João", "Pedra nos rins");
		Medicamento m1 = new Medicamento("Torsilax", EnumAdminitracao.ORAL); 
		Medicamento m2 = new Medicamento("Neosadina", EnumAdminitracao.ORAL);
		Prescricao pr1 = new Prescricao(p2, m1);
		Prescricao pr2 = new Prescricao(p1, m2);
		ut.cadastraPessoa(p1);
		ut.cadastraPessoa(p2);
		ut.cadastraMedicamento(m1);
		ut.cadastraMedicamento(m2);
		ut.criaPresc(pr1);
		ut.criaPresc(pr2);
	}
	
	
	@Test
	@DisplayName("Listar todas as pessoas")
	void listaPessoas() {
		List<Pessoa> cads = ut.listarPessoas();
		assertEquals(2, cads.size());
		assertEquals("João", cads.get(1).getNome());
		ut.cadastraPessoa(new Pessoa("Pedro", "Fratura óssea"));
		cads = ut.listarPessoas();
		assertEquals(3, cads.size());
	assertEquals("Pedro", cads.get(2).getNome());
	}
	@Test
	@DisplayName("Listar todas os medicamentos")
	void listaMedicamentos() {
		List<Medicamento> cads = ut.listarMedicamentos();
		assertEquals(2, cads.size());
		assertEquals("Neosadina", cads.get(1).getNome());
		ut.cadastraMedicamento(new Medicamento("Hipoglos", EnumAdminitracao.TOPICO));
		cads = ut.listarMedicamentos();
		assertEquals(3, cads.size());
		assertEquals("Hipoglos", cads.get(2).getNome());
	}
	@Test
	@DisplayName("Listar todas as prescrições")
	void listaPrescricoes() {
		List<Prescricao> cads = ut.listarPrescricoes();
		assertEquals(2, cads.size());
		assertEquals("Maria", cads.get(1).getP().getNome());
	}
	
	@Test
	@DisplayName("Teste findByPessoaId")
	void findByPessoaId(final Integer id) {
		Pessoa result = ut.findByPessoaId(1);
		assertNotNull(result);
		assertEquals(1, result.getId());
	}
	@Test
	@DisplayName("Teste findByMedicamentoId")
	void findByMedicamentoId(final Integer id) {
		Medicamento result = ut.findByMedicamentoId(1);
		assertNotNull(result);
		assertEquals(1, result.getId());
	}
	@Test
	@DisplayName("Deletar pessoas")
	void deletaPessoa(final Integer id) {
		ut.deletePessoa(id);
		ut.listarPessoas();
	}
	
	@Test
	@DisplayName("Deletar medicamentos")
	void deletaMedicamento(final Integer id) {
		ut.deleteMedicamento(id);
		ut.listarMedicamentos();
	}
}
