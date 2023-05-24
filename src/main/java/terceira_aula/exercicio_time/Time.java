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
		Time t = new Time();
		for (Jogador j : jogadores) {
			j.cadastraJogador();
			jogadores.add(j);
			
		}

	}
	
	String listaJogadores() {
		String nomeTime = JOptionPane.showInputDialog("Nome do time");
		String ret = "Jogadores do %s \n".formatted(nomeTime);
		int count = 0;
		
		return ret;
	}
}
