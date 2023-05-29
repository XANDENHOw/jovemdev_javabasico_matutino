package exercicio_medicamento;

import java.util.List;

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
	Pessoa p;
	@NonNull
	List<Medicamento> med;
	
}
