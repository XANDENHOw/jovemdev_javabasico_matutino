package primeira_aula;


public class Imc {

	 String nome;
	 String sexo;
	 Double peso;
	 Double altura;



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
