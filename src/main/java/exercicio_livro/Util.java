package exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Util {

	public static void escolheAutor(List<Autor> autores) {
		String menu = "";
		int pos = 1;
		for (Autor autor : autores) {
			menu += pos + " - " + autor.toString() + "\n";
			pos++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		JOptionPane.showMessageDialog(null, op);
	}

	public static Livro escolheLivro(List<Livro> livros) {
		String menu = "";
		int pos = 1;
		for (Livro livro : livros) {
			menu += pos + " - " + livro.getTitulo() + "\n";
			pos++;
		}
		int op = Integer.parseInt(menu);
		return livros.get(op - 1);
	}

	public static void cadastraAutor(List<Autor> listaAutores) {
		Autor a = new Autor();
		a.cadastraAutor();
		listaAutores.add(a);
	}

	public static void cadastraLivro(List<Livro> livros, List<Autor> autoresLivro) {
		Livro l = new Livro();
		l.cadastraLivro(autoresLivro);
		livros.add(l);
	}

	public static void listarTodosLivros(List<Livro> livros) {
		String menu = "Lista de livros\n";
		int pos = 1;
		for (Livro livro : livros) {

			menu += pos + " - " + livro.toString() + "\n";
			pos++;

		}
		JOptionPane.showMessageDialog(null, menu);

	}

	public static void buscaLivroAutor(List<Livro> livros, List<Autor> listaAutores) {
		String menu = "Lista de livros\n";
		int pos = 1;
		escolheAutor(listaAutores);
		for (Livro livro : livros) {
			if (livro.temAutor(listaAutores)) {
				menu += pos + " - " + livro.toString() + "\n";
				pos++;
			}
			JOptionPane.showMessageDialog(null, menu);

		}
	}

	public static void buscaLivroPreco(List<Livro> livros) {
		double precoMax = Double.parseDouble(JOptionPane.showInputDialog("Preço máximo"));
		double precoMin = Double.parseDouble(JOptionPane.showInputDialog("Preço mínimo"));
		String ret = "Livros com preço entre %s e %s\n".formatted(precoMax, precoMin);
		for (Livro livro : livros) {
			if (livro.isFaixaPreco(precoMin, precoMax)) {
				ret += livro.toString();
			}
		}
		JOptionPane.showMessageDialog(null, ret);
	}

	public static void buscaAutorCrianca(List<Livro> livros) {
		List<Livro> livrosCriancas = new ArrayList<Livro>();
		for (Livro livro : livros) {
			livro.temCrianca();
			livrosCriancas.add(livro);
		}
		JOptionPane.showMessageDialog(null, livrosCriancas);
	}

	public static void buscaAutorGenero(List<Livro> livros, List<Autor> autores) {
		Sexo genero = escolheSexo();
		String ret = "Livros com autores do sexo %s: \n".formatted(genero.getDesc());
		for (Autor a : autores) {
			if (a.isGenero(genero)) {
				ret += a.toString();
			}
		}
		JOptionPane.showMessageDialog(null, ret);

	}

	public static Autor listarAutores(List<Autor> listaAutores, List<Livro> livros) {
		String menu = "Escolha um autor\n";
		int pos = 1;
		for (Autor autor : listaAutores) {
			menu += pos + " - " + autor.getNome() + "\n";
			pos++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return listaAutores.get(op - 1);
	}
	
	public static Sexo escolheSexo() {
		String menu = "Cores disponíveis\n";
		for (Sexo genero : Sexo.values()) {
			menu += genero.getCod() + " - " + genero.getDesc() + "\n";
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return Sexo.findById(op);
	}

	public static int escolheOpcao() {

		String menu = "1 - Cadastrar autor\n" + "2 - Cadastrar livro\n" + "3 - Listar todos os livros\n"
				+ "4 - Pesquisar por autor\n" + "5 - Pesquisar por preço\n" + "6 - Pesquisar por autores crianças\n"
				+ "7 - Pesquisar por gênero dos autores\n" + "8 - Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));

	}

}
