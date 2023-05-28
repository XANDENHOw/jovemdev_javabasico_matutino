package exercicio_livro;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino");
	
	private int codigo;
	private String descricao;


	public static Sexo findById(int codigo) {
		for (Sexo genero : Sexo.values()) {
			if(codigo == genero.codigo) {
				return genero;
			}
		}
		return null;
	}
}