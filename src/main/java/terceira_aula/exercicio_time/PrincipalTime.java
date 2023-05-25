package terceira_aula.exercicio_time;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class PrincipalTime {
	
	static List<Time> times = new ArrayList<Time>();	
	static List<Jogador> jogadores = new ArrayList<Jogador>();	
	
	public static void main(String[] args) {
		
		int op = 0;
		do {
			op = UtilTime.escolheOpcao();
			switch (op) {
			case 1:
				Time t = new Time();
				t.cadastraTime();
				times.add(t);
				break;
			case 2:
				
				break;

			case 3:
				JOptionPane.showMessageDialog(null, Time.obterArtilheiro());

				break;

			case 4:

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
