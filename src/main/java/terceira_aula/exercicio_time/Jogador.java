package terceira_aula.exercicio_time;


import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Jogador {
	private String nome;
	private int numCamisa;
	@Setter
	private int numGols;

	public void cadastraJogador() {
		nome = JOptionPane.showInputDialog("Informe o nome do jogador");
		numCamisa = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da camisa"));
		numGols = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de gols marcados"));
	}
	
	 
	@Override
	public String toString() {
		return "Nome: " + nome + " \n" + "Camisa: " + numCamisa + "\n" + "Gols marcados: " + numGols + "\n\n";
	}

}
