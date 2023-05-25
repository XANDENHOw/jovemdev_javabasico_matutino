package exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Livro {
	private String titulo;
	private double valor;
	private List<Autor> autores = new ArrayList<Autor>();

	void cadastraLivro() {
		titulo = JOptionPane.showInputDialog("Título do livro".toLowerCase());
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do livro"));
		String op = "";
		int numAutores= 0;
		do {
			Autor a = new Autor();
			a.cadastraAutor();
			autores.add(a);
			do{
				numAutores ++;
			} while (numAutores <= 4);
			op = JOptionPane.showInputDialog("Deseja cadastrar mais autores? (S/N)");
		} while (op.equalsIgnoreCase("S"));
	}
	
	boolean validaLivro(int numAutores) {
		if(titulo.trim().equalsIgnoreCase(" ")) {
			JOptionPane.showMessageDialog(null, "O livro precisa de um título");
			return false;
		}
		if(valor <= 0) {
			JOptionPane.showMessageDialog(null, "O valor do livro não pode ser menor que 0");
			return false;
		}
		if(numAutores < 1 || numAutores > 4) {
			JOptionPane.showMessageDialog(null, "O livro deve ter pelo menos 1 autor e no máximo 4");
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Título: " + titulo + "\n" 
				+ "Preço: " + valor + "\n"
				+ "Autor(es)" + autores;

	}
	
	boolean temAutor(List<Autor> autores) {
		Autor a = autores.get(0);
		for (Autor autor : autores) {
			if(autor.getNome().equalsIgnoreCase(a.getNome())) {
				a = autor;
				return true;				
			} 
		}
		return false;
	}
	boolean temCrianca() {
		Autor crianca = autores.get(0);
		if(crianca.getIdade() <= 12) {
			return true;			
		} else {
			return false;
		}
	}




}
