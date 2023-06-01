package exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	private String nome;
	private int estoque;
	private double valor;
	
	
	public boolean temEstoque(int quantidade) {
		if(estoque > quantidade) {
			return true;
		}
		return false;
	}

	
	public boolean venda(Venda v) {
		estoque = getEstoque() - v.getQuantidade();
		v.getCliente().adicionarDebito(v.getQuantidade()*getValor());
		return true;
	}
}
