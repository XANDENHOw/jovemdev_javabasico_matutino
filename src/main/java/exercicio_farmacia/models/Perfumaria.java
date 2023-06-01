package exercicio_farmacia.models;

public class Perfumaria extends Produto{
	
	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean podeVender(int quantidade, double valor) {
		Cliente cliente = new Cliente();
		if(cliente.getSaldo() <= 300) {
		return super.podeVender(quantidade, valor);	
		}
		return false;
	}
	
	@Override
	public Perfumaria cadastraProduto() {
		return (Perfumaria) super.cadastraProduto();
	}

}
