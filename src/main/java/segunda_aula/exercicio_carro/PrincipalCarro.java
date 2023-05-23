package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
				String resultado = "";
				List<Carro> carrosFiltradosAno = new ArrayList<Carro>();
				for (Carro carro : carros) {
					if (carro.getAno() >= anoInicial && carro.getAno() <= anoFinal) {
						carrosFiltradosAno.add(carro);
						resultado += carrosFiltradosAno.toString();
					}
					JOptionPane.showMessageDialog(null, resultado);
				}
			} else if (op == 3) {
				String marca = JOptionPane.showInputDialog("Informe a marca que seja buscar");
				String resultado = "";
				List<Carro> carrosFiltradosMarca = new ArrayList<Carro>();
				for (Carro carro : carros) {
					if (carro.getMarca().toUpperCase() == marca) {
						carrosFiltradosMarca.add(carro);
						resultado += carrosFiltradosMarca.toString();
					}
				}
				JOptionPane.showMessageDialog(null, resultado);
			} else if (op == 4) {
				
			}
		} while (op != 5);

	}

}
