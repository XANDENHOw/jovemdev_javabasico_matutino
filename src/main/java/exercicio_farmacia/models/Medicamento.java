package exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento extends Produto{

	private boolean precisaReceita;
	
	public boolean isReterReceita() {
        return precisaReceita;
    }
	public void venda() {
		if(getEstoque() > 0) {
			
		}
	}
}
