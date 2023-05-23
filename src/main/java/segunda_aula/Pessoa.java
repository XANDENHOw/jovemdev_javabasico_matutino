package segunda_aula;

import javax.swing.JOptionPane;

public class Pessoa {

	String nome;
	String sexo;
	double peso;
	double altura;
	
	
	double calculaImc() {
		return peso / (altura * altura);
	}
	
	void cadastra() {
		nome = JOptionPane.showInputDialog("Nome");
		sexo = JOptionPane.showInputDialog("Sexo");
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
	}
	
	public String toString() {
		double imc = calculaImc();
		String avaliacao = "";
		if (sexo.equalsIgnoreCase("masculino")) {
			if (imc < 20.7) {
				avaliacao = "Abaixo do peso";
			} else if (imc >= 20.7 && imc <= 26.4) {
				avaliacao = "Peso ideal";
			} else if (imc >= 26.5 && imc <= 27.8) {
				avaliacao = "Pouco acima do peso";
			} else if (imc >= 27.9 && imc <= 31.1) {
				avaliacao = "Acima do peso";
			} else {
				avaliacao = "Obesidade";
			}

		} else {

			if (imc < 19.1) {
				avaliacao = "Abaixo do peso";
			} else if (imc >= 19.1 && imc <= 25.8) {
				avaliacao = "Peso ideal";
			} else if (imc >= 25.9 && imc <= 27.3) {
				avaliacao = "Pouco acima do peso";
			} else if (imc >= 26.4 && imc <= 32.3) {
				avaliacao = "Acima do peso";
			} else {
				avaliacao = "Obesidade";
			}

		}
		return nome + " - " + calculaImc() + " - " + avaliacao;
	}
}
