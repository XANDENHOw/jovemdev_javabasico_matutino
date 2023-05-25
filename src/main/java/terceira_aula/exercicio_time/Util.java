package terceira_aula.exercicio_time;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {

	static int escolheOpcao() {

		String menu = "1 - Cadastrar time\n" + "2 - Listar elenco\n" + "3 - Mostrar artilheiro\n"
				+ "4 - Mostrar time com mais gols\n" + "5 - Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));

	}

	public static void cadastraTime(List<Time> times) {
		Time t = new Time();
		t.cadastraTime();
		times.add(t);
	}

	public static Time escolheTime(List<Time> times) {
		String menu = "Escolha um time\n";
		int pos = 1;
		for (Time time : times) {
			menu += pos + " - " + time.getNomeTime() + "\n";
			pos++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return times.get(op - 1);
	}

	public static String listaJogadoresTime(List<Time> times) {
		Time t = escolheTime(times);
		return t.listaJogadores();
	}

	public static String artilheiroCampeonato(List<Time> times) {
		Jogador artilheiro = new Jogador();
		for (Time time : times) {
			if (time.getArtilheiro().getNumGols() > artilheiro.getNumGols()) {
				artilheiro = time.getArtilheiro();
			}
		}
		return artilheiro.toString();
	}

	public static String timeMaisGols(List<Time> times) {
		Time t = new Time();
		for (Time time : times) {
			if (time.getGols() > t.getGols()) {
				t = time;
			}
		}
		return t.getNomeTime();
	}

}
