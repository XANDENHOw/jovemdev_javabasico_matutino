package exercicio_medicamento.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_medicamento.enums.EnumAdminitracao;
import exercicio_medicamento.models.Medicamento;
import exercicio_medicamento.models.Pessoa;

public class ConsultorioTest {

	Consultorio consultorio = new Consultorio();

	@BeforeEach
	void init() {
		
		consultorio.clearData();

		consultorio.getMedicamentos().clear();
		consultorio.getPessoas().clear();

		Pessoa p1 = new Pessoa("Pessoa 1", "Gripe");
		p1.addCondSaude("Pressão alta");
		p1.addCondSaude("Diabetes");

		Pessoa p2 = new Pessoa("Pessoa 2", "Dengue");

		Pessoa p3 = new Pessoa("Pessoa 3", "Dor");

		consultorio.getPessoas().add(p1);
		consultorio.getPessoas().add(p2);
		consultorio.getPessoas().add(p3);

		Medicamento m1 = new Medicamento("Medicamento 1", EnumAdminitracao.ORAL);
		m1.addIndicacao("Dor");
		m1.addIndicacao("Febre");
		m1.addContraIndicacao("Diabetes");

		Medicamento m2 = new Medicamento("Medicamento 2", EnumAdminitracao.ORAL);
		m2.addIndicacao("Gripe");

		consultorio.getMedicamentos().add(m1);
		consultorio.getMedicamentos().add(m2);

	}

	@Test
	@DisplayName("Teste cadastrar medicamento")
	void addMedicamento() {
		Medicamento m = new Medicamento("teste 1", EnumAdminitracao.INJETAVEL);
		consultorio.cadastraMedicamento(m);
		assertEquals(3, consultorio.getMedicamentos().size());
	}

	@Test
	@DisplayName("Teste cadastrar pessoa")
	void addPessoa() {
		Pessoa p = new Pessoa("Teste", "");
		consultorio.cadastraPessoa(p);
		assertEquals(4, consultorio.getPessoas().size());
	}

	@Test
	@DisplayName("Teste prescrição ok")
	void prescricao() {
		Pessoa p = consultorio.getPessoas().get(1);
		Medicamento m = consultorio.getMedicamentos().get(0);
		consultorio.prescreveMedicamento(p, m);
		assertEquals(0, p.getMedicamentos().size());
	}

	@Test
	@DisplayName("Teste prescrição não ok")
	void prescricaoFalha() {
		Pessoa p = consultorio.getPessoas().get(0);
		Medicamento m = consultorio.getMedicamentos().get(0);
		consultorio.prescreveMedicamento(p, m);
		assertEquals(0, p.getMedicamentos().size());
	}

	@Test
	@DisplayName("Teste prescreve medicamento falho")
	public void testPrescreveMedicamentoErrado() {
		Medicamento medicamento = new Medicamento("Paracetamol", EnumAdminitracao.ORAL);
		Pessoa pessoa = new Pessoa("João", "Febre");
		consultorio.cadastraPessoa(pessoa);
		consultorio.prescreveMedicamento(pessoa, medicamento);
		Assertions.assertFalse(pessoa.getMedicamentos().contains(medicamento));
	}

	@Test
	@DisplayName("Teste cadastrar pessoa falho")
	void naoAddPessoa() {
		Medicamento medicamento = new Medicamento("Paracetamol", EnumAdminitracao.ORAL);
		Pessoa pessoa = new Pessoa("João", "Febre");
		consultorio.cadastraMedicamento(medicamento);
		consultorio.prescreveMedicamento(pessoa, medicamento);
		Assertions.assertFalse(pessoa.getMedicamentos().contains(medicamento));
	}
}
