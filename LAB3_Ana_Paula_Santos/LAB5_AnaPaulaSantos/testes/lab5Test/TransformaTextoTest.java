package lab5Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Clean;
import lab5.ConsoleLogger;
import lab5.TransformaTexto;

class TransformaTextoTest {
	
	private TransformaTexto controle;
	
	@BeforeEach
	void inicializador() {
		this.controle = new TransformaTexto();
	}
	@Test
	void transformaTextoConstrutorComParametro() {
		this.controle = new TransformaTexto(new ConsoleLogger()); 	
	}
	@Test
	void transformaTextoConstrutorComParametroNulo() {
		try {
			this.controle = new TransformaTexto(null);
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
				
	}
}
	@Test
	void cadastraTransformacao() {
		this.controle.cadastraTransformacao("Clean", new Clean());	
	}
	
	@Test
	void cadastraTransformacaoComChaveNula() {
		try {
			this.controle.cadastraTransformacao(null, new Clean());
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
		
	}

}
	@Test
	void cadastraTransformacaoComObjetoNulo() {
		try {
			this.controle.cadastraTransformacao("clean", null);
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
		
	}

}
	@Test
	void cadastraTransformacaoComChaveEmBranco() {
		try {
			this.controle.cadastraTransformacao("", new Clean());
			fail("Era esperado uma exceção");
		}catch(IllegalArgumentException iae) {
		
	}
	
}
	@Test
	void transforma() {
		assertEquals(this.controle.transforma("clean", "Olá, como vai?"), "olá como vai");

}
	@Test
	void transformacaoInexistente() {
		try {
			this.controle.transforma("LowerCase", "Olá, como vai?");
			fail("Era esperado uma exceção");
		}catch( IllegalArgumentException iae) {
		}
	
}
	@Test
	void contaTransformacao() {
		this.controle.transforma("clean", "Olá, como vai?");
		assertEquals(this.controle.contaTransformacao(), 1);
	}
	
	@Test
	void historico() {
		this.controle.transforma("clean", "Olá, como vai?");
		assertEquals(this.controle.historico(0), "Olá, como vai? - clean -> olá como vai");
	}
	
	@Test
	void listarOriginais() {
		this.controle.transforma("clean", "Olá, como vai?");
		this.controle.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		assertEquals(this.controle.listarOriginais(), "Olá, como vai?\noi, como vc vai?\n");
	}
	
	@Test
	void listarTransfomacoes() {
		assertEquals(this.controle.listarTransformacoes(), "CaMeLcAsEfY\nCleanSpaces\nInterrogaPraPontos\nTrocarTodosOsAsParaE\nclean\nupperCase\n");
	}
	
	@Test
	void loggerComDoisParametros() {
		this.controle.logger("transforma", "clean");
	}
	@Test
	void loggerComUmParametro() {
		this.controle.logger("transforma");
	}
	

	

}
