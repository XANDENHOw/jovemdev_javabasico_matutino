package segunda_aula.exercicio_carro;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {

	static EnumCor escolheCor() {
		String menu = "Cores disponíveis\n";
		for (EnumCor cor : EnumCor.values()) {
			menu += cor.codigo + " - " + cor.descricao + "\n";
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return EnumCor.findById(op);
	}

	static String listaPorFabricacao(List<Carro> carros) {
		int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Ano inicial"));
		int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Ano final"));
		String ret = "Carros fabricados entre %s e %s (%s)\n".formatted(anoInicial, anoFinal);
		int count = 0;
		for (Carro c : carros) {
			if (c.isPeriodoFabricacao(anoInicial, anoFinal)) {
				ret += c.toString();
				count++;
			}
		}
		ret += "Representa " + percentualCarros(carros, count) + " % dos carros";
		return ret;
	}

	static String listaPorMarca(List<Carro> carros) {
		String marca = JOptionPane.showInputDialog("Marca");
		String ret = "Carros da marca %s (%s)\n".formatted(marca);
		int count = 0;
		for (Carro c : carros) {
			if (c.isMarca(marca)) {
				ret += c.toString();
				count++;
			}
		}

		ret += "Representa " + percentualCarros(carros, count) + " % dos carros";
		return ret;
	}

	static String listaPorCor(List<Carro> carros) {
		EnumCor cor = escolheCor();
		String ret = "Carros da cor %s (%s)\n".formatted(cor.descricao);
		int count = 0;
		for (Carro c : carros) {
			if (c.isCor(cor)) {
				ret += c.toString();
				count++;
			}
		}

		ret += "Representa " + percentualCarros(carros, count) + " % dos carros";
		return ret;
	}

	static double percentualCarros(List<Carro> carros, int qtd) {
		return (double) (qtd / (double) carros.size()) * 100;
	}

	static int escolheOpcao() {

		String menu = "1 - Cadastrar\n"
				+ "2 -  Filtrar por ano\n"
				+ "3 - Filtrar por marca\n"
				+ "4 - Filtrar por cor\n"
				+ "5 - Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));

	}
}
