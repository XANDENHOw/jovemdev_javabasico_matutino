package exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento extends Produto {

	private boolean precisaReceita;

	public Medicamento(String nome, int estoque, double valor, boolean precisaReceita) {
		super(nome, estoque, valor);
		this.precisaReceita = precisaReceita;
	}

	public boolean isReterReceita() {
		return precisaReceita;
	}

	@Override
	public boolean podeVender(int quantidade, double valor) {
		if (!isReterReceita()) {
			return super.podeVender(quantidade, valor);
		}		
			return false;
	}

	public Medicamento cadastraProduto(String nome, int estoque, double valor, boolean receita) {
		if (isPrecisaReceita()) {
			Medicamento medicamento = new Medicamento(nome, estoque, valor, true);
			return medicamento;
		}
		Medicamento medicamento = new Medicamento(nome, estoque, valor, false);
		return medicamento;
	}
}
