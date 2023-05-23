package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

public class Carro {

	String marca;
	int ano;
	Cores cor;

	enum Cores {
		BRANCO("branco"), PRETO("preto"), VERMELHO("vermelho"), AZUL("azul");

		private String cor;

		Cores(String cor) {
			this.cor = cor;
		}

		public String getCor() {
			return cor;
		}
	}

	void cadastra() {

		marca = JOptionPane.showInputDialog("Marca");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano"));
		String menu = "Selecone o número referente a cor desejada:\n" + "1 - Branco\n" + "2 -  Preto\n"
				+ "3 - Vermelho\n" + "4 - Azul\n" + "0 - Cancelar";
		int op = 0;

		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (op == 1) {
				cor = Cores.BRANCO;
			} else if (op == 2) {
				cor = Cores.PRETO;
			} else if (op == 3) {
				cor = Cores.VERMELHO;
			} else if (op == 4) {
				cor = Cores.AZUL;
			}
			break;
		} while (op != 0);

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	public String toString() {
		return marca + " - " + ano + " - " + cor;
	}

}
