package exercicio_farmacia.utils;

import java.util.List;

import exercicio_farmacia.models.Cliente;
import exercicio_farmacia.models.Medicamento;
import exercicio_farmacia.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Farmacia {
	
	private List<Cliente> clientes;
    private List<Produto> produtos;
    
    public void cadastrarCliente(String nome, double saldo) {
        Cliente cliente = new Cliente(nome, saldo);
        clientes.add(cliente);
    }
    public void cadastrarProduto(String nome, int estoque, double valor, boolean reterReceita) {
        Produto produto;
        if (reterReceita) {
            produto = new Medicamento();
        } else {
            produto = new Produto(nome, estoque, valor);
        }
        produtos.add(produto);
    }
    
    public void realizarVenda(Produto produto, Cliente cliente, int quantidade, String nomeMedico) {
        if (produto instanceof Medicamento && ((Medicamento) produto).isReterReceita()) {
        	
        }

        if (produto.getEstoque() >= quantidade) {
            double valorCompra = produto.getValor() * quantidade;
            cliente.adicionarDebito(valorCompra);
            produto.baixarEstoque(quantidade);
        }
    }
    public void realizarPagamento(Cliente cliente, double valor) {
        if (valor > cliente.getSaldo()) {
        } else {
            cliente.realizarPagamento(valor);
        }
    }
    public String consultarEstoque() {
    	String result = "Produto inexistente";
        for (Produto produto : produtos) {
            result += produto.getNome() + " - Estoque: " + produto.getEstoque();
            return result;
        }
        return result;
    }
    
    public String consultarClientes() {
    	String result = "Cliente inexistente";
    	for (Cliente cliente : clientes) {
          result += cliente.getNome() + " - Saldo Devedor: " + cliente.getSaldo();
          return result;
        }
    	return result;
    }
}
