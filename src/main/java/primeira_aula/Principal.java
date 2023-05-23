package primeira_aula;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nome = JOptionPane.showInputDialog("Informe o nome");
		pessoa1.sexo = JOptionPane.showInputDialog("Informe o sexo");
		pessoa1.peso = Double.parseDouble(JOptionPane.showInputDialog("informe o peso"));
		pessoa1.altura = Double.parseDouble(JOptionPane.showInputDialog("informe a altura"));
		
		
		System.out.println(pessoa1.nome + " " + Pessoa.calculaIMC(pessoa1.peso, pessoa1.altura) + " " + Pessoa.avaliaIMC(Pessoa.calculaIMC(pessoa1.peso, pessoa1.altura), pessoa1.sexo));

	}

}
