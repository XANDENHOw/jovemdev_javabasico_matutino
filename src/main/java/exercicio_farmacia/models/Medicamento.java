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

	@Override
	public boolean venda(Venda v) {
		if(precisaReceita && v.getMedico() == null) {
			return false;
		} else {
			if(getEstoque() >= v.getQuantidade()) {	
				return super.venda(v);
			}			
		}
		return false;
	}
}
