package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Especial extends Conta {

	private double limite;

	@Override
	public double sacar(double valor) {
		if (((limite + getSaldo()) - valor) >= 0) {
			double result = limite - valor;
			return result;
		}
		return 0;
	}

	@Override
	public double transferir(Conta contaDestino, double valor) {
		if (saldo + limite >= valor) {
			saldo -= valor;
			contaDestino.depositar(valor);
			return super.transferir(contaDestino, valor);
		}
		return 0;
	}
}
