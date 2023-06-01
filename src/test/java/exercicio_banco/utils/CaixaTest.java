package exercicio_banco.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_banco.models.Conta;
import exercicio_banco.models.Especial;
import exercicio_banco.models.Universitaria;

public class CaixaTest {

	private Caixa caixa = new Caixa();

    @BeforeEach
    void init() {
    	caixa.limpaDados();
    	caixa.addConta(new Universitaria(122, 43, "Universitario 1", 10));
    	caixa.addConta(new Conta(132, 44, "Maria", 2500.0));
    	caixa.addConta(new Especial(123, 41, "João", 2000.0, 50));    	
    }
    
    @Test
    @DisplayName("Teste transferencia corrente para universitária ok")
    void transf1() {
		Conta corr = caixa.getContas().get(1);
		Universitaria uni = (Universitaria) caixa.getContas().get(0);
		caixa.transfere(corr, uni, 10);
		assertEquals(2490, corr.getSaldo());
		assertEquals(20, uni.getSaldo());
	}
    @Test
    @DisplayName("Teste transferencia corrente para universitária impossível")
    void transf2() {
    	Conta corr = caixa.getContas().get(1);
    	Universitaria uni = (Universitaria) caixa.getContas().get(0);
    	caixa.deposito(uni, 1990);
    	assertEquals(2000, uni.getSaldo());
    	caixa.transfere(corr, uni, 10);
    	assertEquals(2500, corr.getSaldo());
    	assertEquals(2000, uni.getSaldo());
    }
    
    
}
