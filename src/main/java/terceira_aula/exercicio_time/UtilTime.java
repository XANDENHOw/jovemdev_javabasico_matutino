package terceira_aula.exercicio_time;

import javax.swing.JOptionPane;

public class UtilTime {
	
	static int escolheOpcao() {

		String menu = "1 - Cadastrar time\n"
				+ "2 - Listar elenco\n"
				+ "3 - Mostrar artilheiro\n"
				+ "4 - Mostrar time com mais gols\n"
				+ "5 - Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));

	}
	

	static Jogador obterArtilheiro() {
		Jogador artilheiro = null;
		int maiorGols = 0;
		for (Jogador jogador : jogadores) {
			if (jogador.getNumGols() > maiorGols) {
				artilheiro = jogador;
				maiorGols = jogador.getNumGols();
			}
		}
		return artilheiro;
	}

}
