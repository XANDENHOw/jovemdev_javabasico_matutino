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
public class Pessoa {

	private Integer id;
	@NonNull
	private String nome;
	@NonNull
	private String sintoma;
	private List<String> alergias = new ArrayList<>();
	
	
	public void adicionaAlergia(String alergia) {
		alergias.add(alergia);
	}
}
