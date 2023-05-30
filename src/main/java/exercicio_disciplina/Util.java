package exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;



public class Util {
	
	public static List<Aluno> alunos = new ArrayList<Aluno>();
	public static List<Professor> professores = new ArrayList<Professor>();
	public static List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public static void cadastraAluno(String nome) {
		Aluno a = new Aluno(nome);
		alunos.add(a);
	}

	public static void cadastraProfessor(String nome, EnumEspecializacao espec) {
		Professor prof = new Professor(nome, espec);
		professores.add(prof);
	}

	public static void cadastraDisciplina(String nome, int cargaHoraria, Professor p) {
		if(validaProfessor(p)) {
			Disciplina d = new Disciplina(nome, cargaHoraria, p);
			disciplinas.add(d);
		}
	}
	
	static boolean validaProfessor(Professor p) {
		boolean temProf = true;
		if(!professores.contains(p)) {
			temProf = false;
		}
		return temProf;
	}
	static boolean validaAluno(Aluno a) {
		boolean temAluno = true;
		if(!alunos.contains(a)) {
			temAluno = false;
		}
		return temAluno;
	}
	
	public static void addDisciplina(Aluno aluno, Disciplina disciplina) {
		if(validaAluno(aluno)) {
			for (Aluno a : alunos) {
				if(a.equals(aluno)) {
					a.getDisciplinaAluno().add(disciplina);
				}
			}
		}
	}
	
	public static void addNotasDisc(Aluno aluno, Disciplina disciplina, double n1, double n2, double n3) {
		if(validaAluno(aluno)) {
			for (Aluno a : alunos) {
				if(a.equals(aluno)) {
					a.adicionaNota(disciplina, n1, n2, n3);
				}
			}
		}
		
	}
	
	public static String calculaMedia(Aluno aluno) {
		
		String media = "";
		if(validaAluno(aluno)) {
			media = aluno.getMedia();
		}
		return media;
	}
	
	public static List<Disciplina> listaDiscProfGraduacao(){
		List<Disciplina> profGraduacao = new ArrayList<>();
		for (Disciplina d : profGraduacao) {
			if(d.temProfGrad()) {
				profGraduacao.add(d);
			}
		}
		return profGraduacao;
	}
	
	public void clearData() {
		alunos.clear();
		professores.clear();
		disciplinas.clear();
	}
	
	
}
