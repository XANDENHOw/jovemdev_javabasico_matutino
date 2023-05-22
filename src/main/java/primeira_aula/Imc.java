package primeira_aula;

import javax.swing.JOptionPane;

public class Imc {


	
	static String nome = JOptionPane.showInputDialog("Informe o nome");
	static String sexo = JOptionPane.showInputDialog("Informe o sexo");
	static String pesoDigitado = JOptionPane.showInputDialog("Informe o peso");
	static Double peso = Double.parseDouble(pesoDigitado);
	static String alturaDigitada = JOptionPane.showInputDialog("Informe a altura");
	static Double altura = Double.parseDouble(alturaDigitada);
	
	public static void main() {
		System.out.println(nome + " " + calculaIMC(peso,altura) + " "
				+ avaliaIMC(calculaIMC(peso, altura), sexo));


	}

	public static Double calculaIMC(Double peso, Double altura) {

		Double IMC = peso / (altura * altura);
		return IMC;
		
	}
	
	public static String avaliaIMC(Double IMC, String sexo) {
		if (sexo == "masculino") {
			if (IMC < 20.7) {
				return "Abaixo do peso";
			} else if (IMC >= 20.7 && IMC <= 26.4) {
				return "Peso ideal";
			} else if (IMC >= 26.5 && IMC <= 27.8) {
				return "Pouco acima do peso";
			} else if (IMC >= 27.9 && IMC <= 31.1) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}

		} else {
			if (IMC < 19.1) {
				return "Abaixo do peso";
			} else if (IMC >= 19.1 && IMC <= 25.8) {
				return "Peso ideal";
			} else if (IMC >= 25.9 && IMC <= 27.3) {
				return "Pouco acima do peso";
			} else if (IMC >= 26.4 && IMC <= 32.3) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		}
	}

}
