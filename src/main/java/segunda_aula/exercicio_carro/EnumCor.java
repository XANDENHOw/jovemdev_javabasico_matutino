package segunda_aula.exercicio_carro;

public enum EnumCor {

	BRANCO(1, "Branco"),
	PRETO(2, "Preto"),
	PRATA(3, "Prata"),
	VERMELHO(4, "Vermelho");

	public int codigo;
	public String descricao;
	
	private EnumCor(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static EnumCor findById(int codigo) {
		for (EnumCor cor : EnumCor.values()) {
			if(codigo == cor.codigo) {
				return cor;
			}
		}
		return null;
	}
}
