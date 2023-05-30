package exercicio_medicamento;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> contraIndicacoes = new ArrayList<>();
	private List<String> indicacoes = new ArrayList<>();
	
	public void adicionaIndicacao(String indicacao) {
		indicacoes.add(indicacao);
	}
	public void adicionaContraIndicacao(String contraIndicacao) {
		contraIndicacoes.add(contraIndicacao);
	}

}
