package primeira_aula;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int numPessoa = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de pessoa que deseja calcular"));
		for (int i = 0; i < numPessoa; i++) {
			
		Pessoa pessoa1 = new Pessoa();
		String nome;
		String sexo;
		Double peso;
		Double altura;
		pessoa1.criaPessoa(nome, sexo, peso, altura);
		
		System.out.println(pessoa1.nome + " " + pessoa1.calculaIMC(pessoa1.peso, pessoa1.altura) + " "
				+ pessoa1.avaliaIMC(pessoa1.calculaIMC(pessoa1.peso, pessoa1.altura), pessoa1.sexo));
		}

	}

}
