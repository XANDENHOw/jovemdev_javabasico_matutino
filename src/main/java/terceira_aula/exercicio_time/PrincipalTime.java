package terceira_aula.exercicio_time;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrincipalTime {


	public static void main(String[] args) {

		List<Time> times = new ArrayList<Time>();
		int op = 0;
		do {
			op = Util.escolheOpcao();
			switch (op) {
			case 1:
				Util.cadastraTime(times);
				break;
			case 2:
				Util.listaJogadoresTime(times);
				break;

			case 3:
				Util.artilheiroCampeonato(times);
				break;

			case 4:
				Util.timeMaisGols(times);
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
