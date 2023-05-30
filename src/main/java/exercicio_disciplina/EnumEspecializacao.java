package exercicio_disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumEspecializacao {
	
	GRADUACAO(1, "Graduação"),
	ESPECIALIZACAO(1, "Especialização"),
	POSGRADUACAO(1, "Pós Graduação");
	
	private int codigo;
	private String descricao;
}
