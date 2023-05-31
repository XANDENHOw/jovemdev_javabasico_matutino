package exercicio_banco.models;

public class Universitaria extends Conta{
	
	@Override
	public double depositar(double saldo, double valor) {
		if((saldo + valor) <= 2000) {
			return super.depositar(saldo, valor);			
		}
		return saldo;
	}

}
