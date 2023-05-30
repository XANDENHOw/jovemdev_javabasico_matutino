package exercicio_medicamento.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		
		Pessoa p1 = new Pessoa ("Pessoa 1", "Gripe");
		p1.addCondSaude("Pressão alta");
		p1.addCondSaude("Diabetes");

		Pessoa p2 = new Pessoa ("Pessoa 2", "Dengue");
		
		Pessoa p3 = new Pessoa ("Pessoa 3", "Dor");
		
		consultorio.getPessoa().add(p1);
		consultorio.getPessoa().add(p2);
		consultorio.getPessoa().add(p3);
		
		Medicamento m1 = new Medicamento("Medicamento 1", EnumAdminitracao.ORAL);
		m1.addIndicacao("Dor");
		m1.addIndicacao("Febre");
		m1.addContraIndicacao("Diabetes");
		
		Medicamento m2 = new Medicamento("Medicamento 2", EnumAdminitracao.ORAL);
		m2.addIndicacao("Gripe");
		
		consultorio.getMedicamento().add(m1);
		consultorio.getMedicamento().add(m2);
		
	}
	
	
	@Test
	@DisplayName("Teste cadastrar medicamento")
	void addMedicamento() {
		Medicamento m = new Medicamento("teste 1", EnumAdminitracao.INJETAVEL);
		consultorio.cadastraMedicamento(m);
		assertEquals(3, consultorio.getMedicamento().size());
	}
	
	@Test
	@DisplayName("Teste cadastrar pessoa")
	void addPessoa() {
		Pessoa p = new Pessoa("teste 1", "");
		consultorio.cadastraPessoa(p);
		assertEquals(3, consultorio.getPessoa().size());
	}
	
	@Test
	@DisplayName("Teste prescrição ok")
	void prescricao() {
		Pessoa p = consultorio.getPessoa().get(1);
		Medicamento m = consultorio.getMedicamento().get(0);
		consultorio.prescreveMedicamento(p, m);
		assertEquals(1, p.getMedicamentos().size());
		assertEquals("Medicamento 1", p.getMedicamentos().get(0).getNome());
	}
}
