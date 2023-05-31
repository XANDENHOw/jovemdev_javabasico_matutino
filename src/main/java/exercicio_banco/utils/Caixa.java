package exercicio_banco.utils;

import exercicio_banco.models.Conta;

public class Caixa {

	private Conta conta;
	private String operacao;
	
	public String depositar(Conta conta, String operacao, double saldo, double valor) {
		double result = saldo + valor;
		String resultado = "Seu novo saldo é de:" + result;
		return resultado;
	}
	
	public String sacar(double saldo, double valor) {
		if(saldo >= valor) {
			double result =  saldo - valor;
			String resultado = "Saque realizado com sucesso.\n Seu novo saldo é de: " + result;
			return resultado;
		}
		return "Seu saldo é insuficiente para realizar essa transação";
	}
	
	public String transferir(int numeroContaSaque, int numeroContaDeposito, double valor) {
		Conta saque = new Conta();
		Conta deposito = new Conta();
		double saldoSaque = saque.getSaldo();
		double saldoDeposito = deposito.getSaldo();
		if(saldoSaque >= valor) {
			double saldoPosSaque = saldoSaque - valor;
			String novoSaldoSaque = "Seu novo saldo é de: " + saldoPosSaque;
			
		}
		
		String result = "";
		return result;
	}
	
}
