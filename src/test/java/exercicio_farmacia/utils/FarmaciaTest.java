package exercicio_farmacia.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_farmacia.models.Cliente;
import exercicio_farmacia.models.Equipamento;
import exercicio_farmacia.models.Medicamento;
import exercicio_farmacia.models.Perfumaria;


public class FarmaciaTest {
	
	Farmacia farmacia = new Farmacia();
	
	
	@BeforeEach
	void init() {
		
		farmacia.limparDados();
		
		Cliente c1 = new Cliente("Cliente 1", 200);
		Cliente c2 = new Cliente("Cliente 2", 400);
		Cliente c3 = new Cliente("Cliente 3", 50);
		Cliente c4 = new Cliente("Cliente 4", 0);
		farmacia.getClientes().add(c1);
		farmacia.getClientes().add(c2);
		farmacia.getClientes().add(c3);
		farmacia.getClientes().add(c4);
		
		Perfumaria p1 = new Perfumaria("Perfume 1", 5, 200);
		Equipamento e1 = new Equipamento("Equipamento 1", 0, 2000);
		Equipamento e2 = new Equipamento("Equipamento 2", 3, 200);
		Medicamento m1 = new Medicamento("Medicamento 1", 5, 300, true);
		farmacia.getProdutos().add(p1);
		farmacia.getProdutos().add(e1);
		farmacia.getProdutos().add(e2);
		farmacia.getProdutos().add(m1);
		
	}
	
	@Test
	@DisplayName("Teste mostrar cliente")
	void mostraCliente() {
		farmacia.cadastrarCliente("Cliente 5", 100);
		assertEquals("Cliente 5 - Saldo Devedor: 100", 0);
		
	}
}
