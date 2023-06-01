package exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	protected String nome;
	protected int estoque;
	protected double valor;
	
	public void baixarEstoque(int quantidade) {
        estoque -= quantidade;
    }
	
}
