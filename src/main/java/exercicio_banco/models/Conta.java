package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Conta {

	protected int numero;
	protected int agencia;
	protected String nomeCorrentista;
	protected double saldo;

	public String depositar(double valor) {
		saldo += valor;
		String resultado = "Seu novo saldo é de: " + saldo;
		return resultado;
	}

	public double sacar(double valor) {
		double result = saldo;
		if (saldo >= valor) {
			result = saldo - valor;
			return result;
		}
		return result;
	}

	public double transferir(Conta contaDestino, double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			contaDestino.depositar(valor);
			return saldo;
		}
		return 0;
	}
}
