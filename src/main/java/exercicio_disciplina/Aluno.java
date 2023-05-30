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
public class Aluno {
	
	@NonNull
	private String nome;
	private List<Disciplina> disciplinaAluno = new ArrayList<Disciplina>();
	
	
	public boolean temDisc(Disciplina d) {
		boolean temDisc = true;
		for (Disciplina disciplina : disciplinaAluno) {
			if(!disciplinaAluno.contains(disciplina));
			temDisc = false;
		}
		return temDisc;
	}
	
	public void adicionaNota(Disciplina d, double nota1, double nota2, double nota3 ) {
		for (Disciplina disciplina : disciplinaAluno) {
			if(disciplina.equals(d)) {
				disciplina.adicionaNotas(nota1, nota2, nota3);
			}
		}
	}
	
	public List<Double> getNotas(Disciplina d) {
		List<Double> notasDisciplina = new ArrayList<>();
		for (Disciplina disciplina : disciplinaAluno) {
			if(disciplina.equals(d)) {
				notasDisciplina = disciplina.getNotas();
			}
		}
		return notasDisciplina;
	}
	
	public String getMedia() {
		String media = "";
		for (Disciplina disciplina : disciplinaAluno) {
			media += disciplina.getNome() + " - " + disciplina.calculaMedia();
		}
		return media;
	}
	
	@Override
	public String toString() {
		return "Aluno: " + nome;
	}
}
