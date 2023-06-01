package exercicio_banco.utils;

import exercicio_banco.models.Conta;

public class Caixa {

	public void realizarOperacao(Conta conta, String operacao, double valor) {
		if (operacao.equalsIgnoreCase("deposito")) {
			conta.depositar(valor);
		} else if(operacao.equalsIgnoreCase("saque")) {
			conta.sacar(valor);
		} else if(operacao.equalsIgnoreCase("tranferir")) {
			conta.transferir(conta, valor);
		} else {
		}
	}
}
