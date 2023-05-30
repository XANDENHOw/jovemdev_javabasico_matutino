package exercicio_medicamento.utils;

import java.util.ArrayList;
import java.util.List;

import exercicio_medicamento.models.Medicamento;
import exercicio_medicamento.models.Pessoa;
import lombok.Getter;

@Getter
public class Consultorio {

	private List<Medicamento> medicamento = new ArrayList<Medicamento>();
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();

	 void cadastraMedicamento(Medicamento m) {
		medicamento.add(m);
	}
	
	 boolean temMedicamento(Medicamento m) {
		return medicamento.contains(m);
	}
	 boolean temPessoa(Pessoa p) {
		return pessoa.contains(p);
	}

	 void cadastraPessoa(Pessoa p) {
		pessoa.add(p);
	}

	 void prescreveMedicamento(Pessoa p, Medicamento m) {
		if(temPessoa(p) && temMedicamento(m))
		p.addMedicamento(m);
	}
	
	public void clearData() {
		medicamento.clear();
		pessoa.clear();
	}
}
