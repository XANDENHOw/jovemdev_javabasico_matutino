package exercicio_medicamento;

import java.util.ArrayList;
import java.util.List;

public class Util {

	private List<Medicamento> medicamento = new ArrayList<Medicamento>();
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();
	private List<Prescricao> prescricao = new ArrayList<Prescricao>();

	public Medicamento cadastraMedicamento(Medicamento m) {
		m.setId(medicamento.size() + 1);
		medicamento.add(m);
		return m;
	}

	public Pessoa cadastraPessoa(Pessoa p) {
		p.setId(pessoa.size() + 1);
		pessoa.add(p);
		return p;
	}

	public Prescricao criaPresc(Prescricao pres) {
		pres.setId(prescricao.size() + 1);
		prescricao.add(pres);
		return pres;
	}

	public List<Pessoa> listarPessoas() {
		return pessoa;
	}
}
