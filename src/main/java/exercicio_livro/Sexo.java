package exercicio_livro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {
	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

	private int cod;
	private String desc;

	public static Sexo findById(int cod) {
		for (Sexo genero : Sexo.values()) {
			if (cod == genero.cod) {
				return genero;
			}
		}
		return null;
	}

	private Sexo(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
