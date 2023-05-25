package exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Autor {
	private String nome;
	private String sexo;
	private int idade;

	void cadastraAutor() {
		nome = JOptionPane.showInputDialog("Informe o nome e sobrenome do autor(a)");
		sexo = JOptionPane.showInputDialog("Informe gênero do autor(a) (Masculino/Feminino)");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade"));
		if(!valida()) {
			cadastraAutor();
		}
		

	}

	boolean valida() {
		if (nome.trim().equals(" " + " ")) {
			JOptionPane.showMessageDialog(null, "Nome e sobrenome devem ser preenchidos");
			return false;
		}
		if (!(sexo.equalsIgnoreCase("masculino")) || !(sexo.equalsIgnoreCase("feminino"))) {
			JOptionPane.showMessageDialog(null, "Preencha o gênero com as opções entre '( )'");
			return false;
		}
		if (idade <= 0) {
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

	boolean isMasculino() {
		if(sexo.equalsIgnoreCase("masculino")) {
			return true;			
		} else {
			return false;
		}
	}
}
