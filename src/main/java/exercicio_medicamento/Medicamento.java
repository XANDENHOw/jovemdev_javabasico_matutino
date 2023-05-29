package exercicio_medicamento;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Medicamento {
	
	private Integer id;
	@NonNull
	private String nome;
	@NonNull
	private EnumAdminitracao tipo;
	@NonNull
	private String contraIndicacao;
	@NonNull
	private String indicacao;

}
