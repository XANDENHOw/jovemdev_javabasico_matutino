package terceira_aula.exercicio_time;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

	private String nomeTime;
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	void cadastraTime() {
		nomeTime = JOptionPane.showInputDialog("Informe o nome do time");
		String op = "";
		do {
			Jogador j = new Jogador();
			j.cadastraJogador();
			jogadores.add(j);
			op = JOptionPane.showInputDialog("Deseja cadastrar mais jogadores? (S/N)");
		} while (op.equalsIgnoreCase("S"));

	}

	public Jogador getArtilheiro() {
		Jogador artilheiro = jogadores.get(0);
		for (Jogador jogador : jogadores) {
			if (jogador.getNumGols() > artilheiro.getNumGols()) {
				artilheiro = jogador;
			}
		}
		return artilheiro;
	}

	public String listaJogadores() {
		String ret = "Jogadores do %s \n".formatted(nomeTime);
		for (Jogador jogador : jogadores) {
			ret += jogador;
		}
		return ret;
	}

	public int getGols() {
		int gols = 0;
		for (Jogador jogador : jogadores) {
			gols += jogador.getNumGols();
		}
		return gols;
	}

	public String toString() {
		return "\nTime: " + getNomeTime() + "\n" + listaJogadores();
	}
}
