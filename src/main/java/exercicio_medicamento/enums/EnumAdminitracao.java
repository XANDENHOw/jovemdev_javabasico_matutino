package exercicio_medicamento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumAdminitracao {
	
	INJETAVEL(1, "Injetável"),
	TOPICO(2, "Tópico"),
	ORAL(3, "Oral"),
	SUPOSITORIO(4, "Supositório");
	
	private int codigo;
	private String descricao;

}
