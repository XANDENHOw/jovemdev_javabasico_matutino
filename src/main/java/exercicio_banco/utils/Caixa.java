package exercicio_banco.utils;

import java.util.ArrayList;
import java.util.List;

import exercicio_banco.models.Conta;
import lombok.Getter;
@Getter
public class Caixa {

	List<Conta> contas = new ArrayList<Conta>();
	
	public void addConta(Conta c) {
		contas.add(c);
	}
	public boolean deposito(Conta conta, double valor) {
		return conta.depositar(valor);
	}
	public boolean saque(Conta conta, double valor) {
		return conta.sacar(valor);
	}
	public boolean transfere(Conta origem, Conta destino, double valor) {
		return origem.transferir(destino, valor);
	}
	
	public void limpaDados() {
		contas.clear();
	}
}
