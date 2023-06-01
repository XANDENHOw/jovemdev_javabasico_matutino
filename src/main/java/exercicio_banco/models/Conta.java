package exercicio_banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

	private int numero;
	private int agencia;
	private String nomeCorrentista;
	protected double saldo;

	public boolean depositar(double valor) {
		if(valor > 0) {			
		saldo = getSaldo() + valor;
		return true;
		}
		return false;
	}

	public boolean sacar(double valor) {
		if(saldo >= valor) {
			saldo = getSaldo() - valor;
			return true;
		}
		return false;
	}

	public boolean transferir(Conta contaDestino, double valor) {
		if(sacar(valor)) {
			if(contaDestino.depositar(valor)) {
				return true;
			}else {
				depositar(valor);
				return false;
			}
		}
		return true;
	}
}
