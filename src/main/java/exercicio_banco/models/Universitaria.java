package exercicio_banco.models;

public class Universitaria extends Conta{
	
	@Override
	public String depositar(double saldo, double valor) {
		if((saldo + valor) <= 2000) {
			return super.depositar(saldo, valor);			
		}
		return "O saldo ultrapassou o valor máximo permitido, a operação não pode ser concluida.";
	}

}
