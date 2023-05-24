package segunda_aula.exercicio_carro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumCor {

	BRANCO(1, "Branco"),
	PRETO(2, "Preto"),
	PRATA(3, "Prata"),
	VERMELHO(4, "Vermelho");

	private int codigo;
	private String descricao;


	public static EnumCor findById(int codigo) {
		for (EnumCor cor : EnumCor.values()) {
			if(codigo == cor.codigo) {
				return cor;
			}
		}
		return null;
	}
}
