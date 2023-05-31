package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Especial extends Conta{
	
	private double limite;

	@Override
	public String sacar(double limite, double valor) {
		String resultado = "";
		if((limite - valor) > 0) {
			double result = limite - valor;
			resultado = "Saque realizado com sucesso.\n Seu novo saldo é de: " + result;
			return resultado;
		}
		String falha = "O limite foi ultrapassado, operação não concluida.";
		return falha;
	}
}
