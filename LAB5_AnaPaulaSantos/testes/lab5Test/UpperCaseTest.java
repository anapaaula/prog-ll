package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.UpperCase;

class UpperCaseTest {

	private UpperCase controle;

	@BeforeEach
	void inicializador() {
		this.controle = new UpperCase();
		
	}

	@Test
	void transformaFrase() {
		assertEquals(this.controle.transforma("Olá, tudo bem?"), "OLÁ, TUDO BEM?");
	}
	
	@Test
	void transformaFrase2() {
		assertEquals(this.controle.transforma("PalAvrAs"), "PALAVRAS");
	}
	
	@Test
	void transformaStringNula() {
		try {
			String stringNula = null; 
			this.controle.transforma(stringNula);
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
			
		}
	}
		
		@Test
		void transformaStringEmBranco() {
			try {
				String stringEmBranco = " "; 
				this.controle.transforma(stringEmBranco);
				fail("Era esperado uma exceção");
			}catch(IllegalArgumentException iae) {
				
			}
		
	}
		
		@Test
		void getNome() {
			assertEquals(this.controle.getNome(), "upperCase");
			
		}
	
	
}
