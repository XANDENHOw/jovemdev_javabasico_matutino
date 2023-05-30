package exercicio_medicamento;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Prescricao {

	private Integer id;
	@NonNull
	private Pessoa p;
	@NonNull
	private Medicamento med;

}
