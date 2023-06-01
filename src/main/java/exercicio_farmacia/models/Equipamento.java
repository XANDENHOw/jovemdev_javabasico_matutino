package exercicio_farmacia.models;

public class Equipamento extends Produto{

	public Equipamento(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean podeVender(int quantidade, double valor) {
		if(getEstoque() == 0) {			
			return super.podeVender(quantidade, valor);
		}
		return super.podeVender(quantidade, valor);		
	}
	
	@Override
	public Equipamento cadastraProduto() {
		return (Equipamento) super.cadastraProduto();
	}
}
