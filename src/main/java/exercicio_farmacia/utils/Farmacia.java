package exercicio_farmacia.utils;

import java.util.List;

import exercicio_farmacia.models.Cliente;
import exercicio_farmacia.models.Medicamento;
import exercicio_farmacia.models.Produto;
import lombok.Getter;

@Getter
public class Farmacia {

	private List<Cliente> clientes;
	private List<Produto> produtos;

	public void cadastrarCliente(String nome, double saldo) {
		Cliente cliente = new Cliente(nome, saldo);
		clientes.add(cliente);
	}

	public void cadastrarProduto(String nome, int estoque, double valor) {
        Produto produto = new Produto();
        if(produto instanceof Produto) {        	
        produto = new Produto(nome, estoque, valor);
        produtos.add(produto);
        } 
        if(produto instanceof Medicamento) {
        	produto = new Medicamento(nome, estoque, valor, true);
        	produtos.add(produto);
        }
    }

	public void realizarVenda(Produto produto, Cliente cliente, int quantidade, double valor) {
		if (produto.podeVender(quantidade, valor)) {
			double valorCompra = produto.getValor() * quantidade;
			cliente.adicionarDebito(valorCompra);
			produto.baixarEstoque(quantidade);
		}
	}

	public void realizarPagamento(Cliente cliente, double valor) {
		if (valor <= cliente.getSaldo()) {
			cliente.realizarPagamento(valor);
		}
	}

	public String consultarEstoque() {
		String result = "Produto em falta";
		for (Produto produto : produtos) {
			result += produto.getNome() + " - Estoque: " + produto.getEstoque();
			return result;
		}
		return result;
	}

	public String consultarClientes() {
		String result = "Cliente inexistente";
		for (Cliente cliente : clientes) {
			result += cliente.getNome() + " - Saldo Devedor: " + cliente.getSaldo() + "\n";
			return result;
		}
		return result;
	}

	public void limparDados() {
		clientes.clear();
		produtos.clear();
	}
}
