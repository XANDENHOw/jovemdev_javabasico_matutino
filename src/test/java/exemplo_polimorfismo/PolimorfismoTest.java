package exemplo_polimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PolimorfismoTest {
	
	List<Forma> formas = new ArrayList<Forma>();
	
	
	@BeforeEach
	public void init() {
		formas.add(new Cilindro());
		formas.add(new Circulo());
		formas.add(new Quadrado());
		formas.add(new Triangulo());
	}
	
	@Test
	@DisplayName("Teste desenhar cilindro")
	public void desenharCilindro() {
		String s = formas.get(0).desenhar();
		assertEquals("Sou a forma Cilindro", s);
	}
	@Test
	@DisplayName("Teste desenhar círculo")
	public void desenharCirculo() {
		String s = formas.get(1).desenhar();
		assertEquals("Sou um círculo e tenho meu próprio desenho", s);
	}
	@Test
	@DisplayName("Teste desenhar quadrado")
	public void desenharQuadrado() {
		String s = formas.get(2).desenhar();
		assertEquals("Sou a forma Quadrado e tenho 4 lados", s);
	}
	@Test
	@DisplayName("Teste desenhar triângulo")
	public void desenharTriangulo() {
		String s = formas.get(3).desenhar();
		assertEquals("Sou a forma Triângulo e tenho 3 lados", s);
	}
	@Test
	@DisplayName("Teste calcular área círculo")
	public void calcAreaCirc() {
		String s = "";
		if(formas.get(1) instanceof Circulo) {
			Circulo c = (Circulo) formas.get(1);
			s = c.calculaArea();
		}
		assertEquals("Minha área pode ser calculada", s);
	}
}
