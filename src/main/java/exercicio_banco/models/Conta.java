package exercicio_banco.models;

import lombok.Getter;

@Getter
public class Conta {
	
	private int numero;
	private int agencia;
	private String nomeCorrentista;
	private double saldo;
	
	
	public double depositar(double saldo, double valor) {
		double result = saldo + valor;
		return result;
	}
	
	public double sacar(double saldo, double valor) {
		double result = saldo;
		if(saldo >= valor) {
			result =  saldo - valor;
			return result;
		}
		return result;
	}
	
	public double transferir(int numeroContaSaque, int numeroContaDeposito, double valor) {
		return 0;
	}
}
