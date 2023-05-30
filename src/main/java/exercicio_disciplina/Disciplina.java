package exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Disciplina {
	@NonNull
	private String nome;
	@NonNull
	private Integer cargaHoraria;
	@NonNull
	private Professor professor;
	private List<Double> notas = new ArrayList<>();
	
	
	public void adicionaNotas(double n1, double n2, double n3) {
		notas.add(n1);
		notas.add(n2);
		notas.add(n3);
	}
	
	public double calculaMedia() {
		double media = 0;
		for (Double nota : notas) {
			media += nota;
		}
		return media / 3;
	}
	
	public boolean temProfGrad() {
		boolean temProf = false;
		if(professor.getEspec().equals(EnumEspecializacao.GRADUACAO)) {
			temProf = true;
		}
		return temProf;
	}
	
	@Override
	public String toString() {
		return "Disciplina: " + nome + "\n Carga Horária: " + cargaHoraria + "\n";
	}
}
