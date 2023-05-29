package exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<Livro>();
		List<Autor> autores = new ArrayList<Autor>();
		int op = 0;
		do {
			op = Util.escolheOpcao();
			switch (op) {
			case 1:
				Util.cadastraAutor(autores);
				break;
			case 2:
				Util.cadastraLivro(livros, autores);
				break;
			case 3:
				Util.listarTodosLivros(livros, autores);
				break;
			case 4:
				Util.buscaLivroAutor(livros, autores);
				break;
			case 5:
				Util.buscaLivroPreco(livros);
				break;
			case 6:
				Util.buscaAutorCrianca(livros);
				break;
			case 7:
				Util.buscaAutorGenero(livros, autores);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Encerrando...");
				break;

			default:
				break;
			}

		} while (op != 8);

	}

}