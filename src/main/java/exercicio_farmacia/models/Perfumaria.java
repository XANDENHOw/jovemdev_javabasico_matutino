package exercicio_farmacia.models;

public class Perfumaria extends Produto{
	
	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean venda(Venda v) {
		if(getEstoque() >= v.getQuantidade() && v.getCliente().getSaldo() < 300) {
			return super.venda(v);			
		}
		return false;
	}

}
