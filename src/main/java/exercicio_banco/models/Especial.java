package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Especial extends Conta{
	
	private double limite = getSaldo() + 500;

	@Override
	public double sacar(double limite, double valor) {
		double result = limite;
		if((limite - valor) >= 0) {
			result = limite - valor;
			return result;
		}
		return result;
	}
}
