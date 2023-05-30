package exercicio_disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Professor {
	private String nome;
	private EnumEspecializacao espec;

}
