package lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import lab5.ConverteInterrogacoesParaPontos;

class ConverteInterrogacoesParaPontosTest {

	private ConverteInterrogacoesParaPontos controle;

	@BeforeEach
	void inicializador() {
		this.controle = new ConverteInterrogacoesParaPontos();
		
	}

	@Test
	void transformaFrase() {
		assertEquals(this.controle.transforma("Oie, tudo bem?"), "Oie, tudo bem.");
	}
	
	@Test
	void transformaFrase2() {
		assertEquals(this.controle.transforma("O?L?A? T?U?D?O? B?E?M?"), "O.L.A. T.U.D.O. B.E.M.");
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
			assertEquals(this.controle.getNome(), "InterrogaPraPontos");
			
		}
	
	

}
