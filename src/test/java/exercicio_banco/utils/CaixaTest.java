package exercicio_banco.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import exercicio_banco.models.Conta;
import exercicio_banco.models.Universitaria;

public class CaixaTest {

	List<Conta> contas = new ArrayList<Conta>();

    @BeforeEach
    void init() {
    	contas.add(new Universitaria());
    	
    }
}
