package exercicio_farmacia.utils;

import java.util.ArrayList;
import java.util.List;

import exercicio_farmacia.models.Cliente;
import exercicio_farmacia.models.Produto;
import exercicio_farmacia.models.Venda;
import lombok.Getter;

@Getter
public class Farmacia {

	private List<Venda> vendas = new ArrayList<Venda>();
	
	public void vender(Cliente cliente, Produto produto, int quantidade, String medico) {
		Venda v = new Venda(cliente, produto, quantidade, medico);
		if(produto.venda(v)) {
			vendas.add(v);
		}
	}
	
	public List<Venda> vendasPorCliente(Cliente c){
		return vendas.stream().filter(v -> v.isCliente(c)).toList();
	}
}
