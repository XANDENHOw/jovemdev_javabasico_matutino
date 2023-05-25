package exercicio_livro;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {

	public static Autor escolheAutor(List<Autor> autores) {
		String menu = "";
		int pos = 1;
		for (Autor  autor : autores) {
			menu += pos + " - " + autor.getNome() + "\n";
			pos ++;
		}
		int op = Integer.parseInt(menu);
		return autores.get(op - 1);

	}

	public static Livro escolheLivro(List<Livro> livros) {
		String menu = "";
		int pos = 1;
		for (Livro  livro : livros) {
			menu += pos + " - " + livro.getTitulo() + "\n";
			pos ++;
		}
		int op = Integer.parseInt(menu);
		return livros.get(op - 1);
	}

	public static void cadastraAutor(List<Autor> autores) {
		Autor a = new Autor();
		a.cadastraAutor();
		autores.add(a);
	}

	public static void cadastraLivro(List<Livro> livros) {
		Livro l = new Livro();
		l.cadastraLivro();
		livros.add(l);

	}

	public static Livro listarTodosLivros(List<Livro> livros) {
		String menu = "Listar livros\n";
		int pos = 1;
		for (Livro livro : livros) {
			menu += pos + " - " + livro.getTitulo() + " - " +
					livro.getValor() + " - " +
					livro.getAutores() + "\n";
			pos++;
		}
		JOptionPane.showMessageDialog(null, menu);
		return livros.get(pos);// falta os dados dos autores

	}

	public static void buscaLivroAutor(List<Livro> livros) {

	}

	public static void buscaLivroPreco(List<Livro> livros) {

	}

	public static void buscaAutorCrianca(List<Livro> livros) {

	}

	public static void buscaAutorGenero(List<Livro> livros) {
		
	}
	
	public static int escolheOpcao() {

		String menu = "1 - Cadastrar autor\n"
				+ "2 - Cadastrar livro\n"
				+ "3 - Listar todos os livros\n"
				+ "4 - Pesquisar por autor\n"
				+ "5 - Pesquisar por preço\n"
				+ "6 - Pesquisar por autores crianças\n"
				+ "7 - Pesquisar por gênero dos autores\n"
				+ "8 - Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));

	}

}
