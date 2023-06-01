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
	public boolean baixarEstoque(int quantidade) {
		if(temEstoque(getEstoque())) {
			estoque -= quantidade;
			return true;
		}
		return false;
	}
	
	public boolean podeVender(int quantidade, double valor) {
		if(temEstoque(getEstoque())) {	
			baixarEstoque(quantidade);
		}
		return false;
	}
	
	public Produto cadastraProduto() {
		Produto produto = new Produto(nome, estoque, valor);        	
		return produto;
	}
	
	public void venda() {
		
	}
}
