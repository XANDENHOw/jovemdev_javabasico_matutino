package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Universitaria extends Conta {

	public Universitaria(int numeroConta, int numeroAgencia, String nomeCorrentista, double saldo) {
		super(numeroConta, numeroAgencia, nomeCorrentista, saldo);
	}

	@Override
	public boolean depositar(double valor) {
		if ((getSaldo() + valor) <= 2000) {
			return super.depositar(valor);
		}
		return false;
	}
}