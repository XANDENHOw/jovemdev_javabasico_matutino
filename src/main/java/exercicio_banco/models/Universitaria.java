package exercicio_banco.models;

public class Universitaria extends Conta {

	@Override
	public double depositar(double valor) {
		if ((getSaldo() + valor) <= 2000) {
			return super.depositar(valor);
		}
		return 0;
	}

	@Override
	public double transferir(Conta contaDestino, double valor) {
		if(Universitaria.class.equals(contaDestino)) {
			if (saldo >= valor && saldo + valor <= 2000.0) {
				saldo += valor;
				depositar(valor);
				return saldo;
			}			
		}
		if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            return saldo;
	}
		return 0;
}
}