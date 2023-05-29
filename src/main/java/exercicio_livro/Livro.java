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

	void cadastraLivro(List<Autor> listaAutores) {
		titulo = JOptionPane.showInputDialog("Título do livro".toLowerCase());
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do livro"));
		String op = "";
		int numAutores = 1;
		do {
			Util.escolheAutor(listaAutores);
			numAutores++;
			op = JOptionPane.showInputDialog("Deseja cadastrar mais autores? (S/N)");
		} while (op.equalsIgnoreCase("S") && numAutores < 4);
		if(!validaLivro(numAutores)) {
			cadastraLivro(listaAutores);
		}
	}

	boolean validaLivro(int numAutores) {
		if (titulo.trim().equalsIgnoreCase(" ")) {
			JOptionPane.showMessageDialog(null, "O livro precisa de um título");
			return false;
		}
		if (valor <= 0) {
			JOptionPane.showMessageDialog(null, "O valor do livro não pode ser menor que 0");
			return false;
		}
		if (numAutores < 1 || numAutores > 4) {
			JOptionPane.showMessageDialog(null, "O livro deve ter pelo menos 1 autor e no máximo 4");
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Título: " + titulo + "\n"
				+ "Preço: " + valor + "\n"
				+ "Autor(es)" + autores 
				+ "\n";

	}

	public String getAutor() {
		String autoresLivro = "";
		for (Autor autor : autores) {
			autoresLivro += autor.toString();
		}
		return autoresLivro;
	}

	boolean temAutor(List<Autor> autores) {
		Autor a = autores.get(0);
		for (Autor autor : autores) {
			if (autor.getNome().equalsIgnoreCase(a.getNome())) {
				a = autor;
				return true;
			}
		}
		return false;
	}

	boolean temCrianca() {
		for (Autor crianca : autores) {
			if (crianca.isCrianca()) {
				return true;
			}
		}

		return false;
	}

	boolean isFaixaPreco(double precoMin, double precoMax) {
		return valor >= precoMin && valor <= precoMax;
	}

}
