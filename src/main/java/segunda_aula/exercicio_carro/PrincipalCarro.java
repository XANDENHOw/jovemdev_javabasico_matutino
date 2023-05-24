package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import segunda_aula.exercicio_carro.Carro.Cores;

public class PrincipalCarro {

	static List<Carro> carros = new ArrayList<Carro>();

	public static void main(String[] args) {
		String menu = "1 - Cadastrar\n" + "2 -  Filtrar por ano\n" + "3 - Filtrar por marca\n" + "4 - Filtrar por cor\n"
				+ "5 - Sair";
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (op == 1) {
				Carro c = new Carro();
				c.cadastra();
				carros.add(c);
			} else if (op == 2) {
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano inicial"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano final"));
				String resultadoAno = "";
				double porcentagem = 0;

				List<Carro> carrosFiltradosAno = new ArrayList<Carro>();
				for (Carro carro : carros) {
					if (carro.getAno() >= anoInicial && carro.getAno() <= anoFinal) {
						carrosFiltradosAno.add(carro);
						resultadoAno = carrosFiltradosAno.toString();
						porcentagem += (carrosFiltradosAno.size() / carros.size()) * 100;

					}
					JOptionPane.showMessageDialog(null, resultadoAno + "Os carros fabricados no período representam"
							+ porcentagem + "% dos carros.");
				}
			} else if (op == 3) {
				String marca = JOptionPane.showInputDialog("Informe a marca que seja buscar");
				String resultadoMarca = "";
				double porcentagem = 0;
				List<Carro> carrosFiltradosMarca = new ArrayList<Carro>();
				for (Carro carro : carros) {
					if (carro.getMarca().equalsIgnoreCase(marca)) {
						carrosFiltradosMarca.add(carro);
						resultadoMarca = carrosFiltradosMarca.toString();
						porcentagem += (carrosFiltradosMarca.size() / carros.size()) * 100;
					}
					JOptionPane.showMessageDialog(null, resultadoMarca + "Os carros da marca escolhida representam"
							+ porcentagem + "% dos carros.");
				}
			} else if (op == 4) {
					
					int corOpcao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número referente a cor que deseja filtar"));
					Cores corSelecionada = Cores.values()[corOpcao];
					String resultadoCor = "";
					List<Carro> carrosFiltradosCor = new ArrayList<Carro>();
					double porcentagem = 0;
					for (Carro carro : carros) {
						if (carro.cor == corSelecionada) {
							carrosFiltradosCor.add(carro);
							resultadoCor = carrosFiltradosCor.toString();
							porcentagem += (carrosFiltradosCor.size() / carros.size()) * 100;
						}
						JOptionPane.showMessageDialog(null,
								resultadoCor + "Os carros da cor escolhida representam" + porcentagem + "% dos carros.");
				}
			}
		} while (op != 5);

	}

}
