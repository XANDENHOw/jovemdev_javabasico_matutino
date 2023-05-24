package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrincipalCarro {

	static List<Carro> carros = new ArrayList<Carro>();

	public static void main(String[] args) {
		int op = 0;
		do {
			op = Util.escolheOpcao();
			switch (op) {
			case 1:
				Carro c = new Carro();
				c.cadastra();
				carros.add(c);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, Util.listaPorFabricacao(carros));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.listaPorMarca(carros));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, Util.listaPorCor(carros));
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "By");
				break;

			default:
				break;
			}

		} while (op != 5);

	}

}
