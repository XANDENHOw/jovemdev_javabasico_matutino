package exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter

public class Autor {
	private String nome;
	private Sexo sexo;
	private int idade;

	void cadastraAutor() {
		nome = JOptionPane.showInputDialog("Informe o nome e sobrenome do autor(a)").trim();
		sexo = Util.escolheSexo();
		idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade"));
		if(!valida()) {
			cadastraAutor();
		}
	}

	boolean valida() {

		while(!(nome.contains(" "))) {
			JOptionPane.showMessageDialog(null, "Nome e sobrenome devem ser preenchidos");
			return false;
		}

		while (idade <= 0) {
			JOptionPane.showMessageDialog(null, "A idade não pode ser inferior a 0");
			return false;
		}
		return true;
	}

	boolean isCrianca() {
		if (idade <= 12) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isGenero(Sexo enumSexo) {
		return enumSexo == sexo;

	}
	
	@Override
	public String toString() {
		return "Nome do autor: " + nome + "\n"
				+ "Sexo: " + sexo.getDesc() + "\n"
				+ "idade: " + idade + "anos\n";
	}

	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}
}
