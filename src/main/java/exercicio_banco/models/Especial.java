package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Especial extends Conta {

	private double limite;

	public Especial(int numeroConta, int numeroAgencia, String nomeCorrentista, double saldo, double limite) {
		super(numeroConta, numeroAgencia, nomeCorrentista, saldo);
		this.limite = limite;
	}

	@Override
	public boolean sacar(double valor) {
		if (((getLimite() + getSaldo()) - valor) >= 0) {
			saldo = (getSaldo() + getLimite()) - valor;
			return true;
		}
		return false;
	}
}
