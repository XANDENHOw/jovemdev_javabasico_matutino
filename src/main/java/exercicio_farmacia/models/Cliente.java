package exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private String nome;
	private double saldo;

	
	public void adicionarDebito(double valor) {
        saldo += valor;
    }
	public void realizarPagamento(double valor) {
        saldo -= valor;
    }
	
}
