package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import lab5.CleanSpaces;

class CleanSpacesTest {
	
	private CleanSpaces controle;

	@BeforeEach
	void inicializador() {
		this.controle = new CleanSpaces();
		
	}

	@Test
	void transformaFrase() {
		assertEquals(this.controle.transforma("Oie. . .tudo bem?"), "Oie...tudobem?");
	}
	
	@Test
	void transformaFrase2() {
		assertEquals(this.controle.transforma("Oie como voc� est�?"), "Oiecomovoc�est�?");
	}
	
	@Test
	void transformaStringNula() {
		try {
			String stringNula = null; 
			this.controle.transforma(stringNula);
			fail("Era esperado uma exce��o");
		}catch(NullPointerException npe) {
			
		}
	}
		
		@Test
		void transformaStringEmBranco() {
			try {
				String stringEmBranco = " "; 
				this.controle.transforma(stringEmBranco);
				fail("Era esperado uma exce��o");
			}catch(IllegalArgumentException iae) {
				
			}
		
	}
		
		@Test
		void getNome() {
			assertEquals(this.controle.getNome(), "CleanSpaces");
			
		}
	
	
}
