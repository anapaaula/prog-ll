package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.CaMeLcAsEfY;

class CaMeLcAsEfYTest {
	
	private CaMeLcAsEfY controle;
	
	@BeforeEach
	void inicializador() {
		this.controle = new CaMeLcAsEfY();
		
	}

	@Test
	void transformaFrase() {
		assertEquals(this.controle.transforma("camelcasefy"), "CaMeLcAsEfY");
	}
	
	@Test
	void transformaFrase2() {
		assertEquals(this.controle.transforma("Oie como voc� est�?"), "OiE CoMo vOc� EsT�?");
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
			assertEquals(this.controle.getNome(), "CaMeLcAsEfY");
			
		}
	
	

}
