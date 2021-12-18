package agenda;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	Agenda agenda;

	/**
	 * Preparando a agenda, e testando o construtor.
	 */
	@BeforeEach
	void testAgenda() {
		this.agenda = new Agenda();
	}
	
	/**
	 * Testa o método getContato recebendo uma posição que não tem
	 * contato.
	 */
	@Test
	void testGetContatosPosicaoInvalida() {
		try{
			 agenda.getContato(1);
			 fail("Era esperado uma exceção");
	
		}catch(NoSuchElementException nsee){
			
		}
	}
	
	/**
	 * Testa o método getContato recebendo uma posição que 
	 * possui contato
	 * 
	 */
	@Test
	void testGetContatosPosicaoValida() {
		agenda.cadastraContato(1,"Matheus", "Gaudencio", "(83) 5555-5555");
		assertEquals("Matheus Gaudencio\n(83) 5555-5555", agenda.getContato(1));
	}


	/**
	 * Teste cadastraContato com o caso base.
	 */
	@Test
	void testCadastraContato() {
		agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertTrue(agenda.confirmacaoDeCadastro());

	}
	
	
	/**
	 * Teste do cadastraContato verifica que não é possivel cadastrar dois contatos iguais na agenda.
	 */
	@Test
	void testCadastraContatosIguais() {
		agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertFalse(agenda.confirmacaoDeCadastro());

	}
	
	/**
	 * Teste do caso base do adicionaFavoritos, com a posição limite.
	 */
	@Test
	void testAdicionaFavoritos() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionaFavoritos(1, 1);
	
	}
	@Test
	void testAdicionaFavoritosIguais() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionaFavoritos(1, 1);
		agenda.adicionaFavoritos(1, 2);
		assertFalse(agenda.confirmacaoDeCadastro());
	
	}
	
	
	@Test
	void testAdicionaFavoritosPosicaoInvalida1() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		try{
			agenda.adicionaFavoritos(1, 0);
			 fail("Era esperado uma exceção");
	
		}catch(IndexOutOfBoundsException ioob){
			
		}
	}
	
	@Test
	void testAdicionaFavoritosPosicaoInvalida2() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		try{
			agenda.adicionaFavoritos(1, 11);
			 fail("Era esperado uma exceção");
	
		}catch(IndexOutOfBoundsException ioob){
			
		}
	}

	@Test
	void testEqualsTrue() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertTrue(agenda.equals("Matheus", "Gaudencio"));
		
	}
	
	@Test
	void testEqualsFalse() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertFalse(agenda.equals("Ana", "Paula"));
		
	}

	@Test
	void testEqualsFavoritosFalse() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionaFavoritos(1, 2);
		assertFalse(agenda.equalsFavoritos("Ana", "Paula"));
		
	}
	
	@Test
	void testEqualsFavoritosTrue() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionaFavoritos(1, 2);
		assertTrue(agenda.equalsFavoritos("Matheus", "Gaudencio"));
	}

	@Test
	void testVerificaFavoritoTrue() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionaFavoritos(1, 2);
		assertTrue(agenda.verifica(1));
		
	}
	
	@Test
	void testVerificaFavoritoFalse() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertFalse(agenda.verifica(1));
		
	}

	@Test
	void testAdicionarTagUmContato() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionarTag("1", "ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 5555-5555\nufcg ", agenda.getContato(1));
		
	}
	
	@Test
	void testAdicionarTagMaisContatos() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.cadastraContato(3, "Ana", "Paula", "(83) 5555-5555");
		agenda.cadastraContato(4, "Lia", "", "(83) 5555-5555");
		agenda.adicionarTag("1 3 4", "ufcg", 1);
		assertEquals("Lia \n(83) 5555-5555\nufcg ", agenda.getContato(4));
		assertEquals("Ana Paula\n(83) 5555-5555\nufcg ", agenda.getContato(3));
		assertEquals("Matheus Gaudencio\n(83) 5555-5555\nufcg ", agenda.getContato(1));
		
	}

	@Test
	void testConfirmacaoDeCadastroTrue() {
		agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertTrue(agenda.confirmacaoDeCadastro());
	}
	
	@Test
	void testConfirmacaoDeCadastroFalse() {
		agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 5555-5555");
		assertFalse(agenda.confirmacaoDeCadastro());
	}
	
	@Test
	void removeTagPosicaoInvalida1() {
		agenda.cadastraContato(2, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionarTag("2", "ufcg", 1);
		
		try {
			agenda.removeTag(2, 0);
			fail("Era esperado uma exceção");
		}catch(IndexOutOfBoundsException ioobe){
			
		}
		
	}
	
	@Test
	void removeTagPosicaoInvalida2() {
		agenda.cadastraContato(2, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionarTag("2", "ufcg", 1);
		
		try {
			agenda.removeTag(2, 6);
			fail("Era esperado uma exceção");
		}catch(IndexOutOfBoundsException ioobe){
			
		}
		
	}
	
	@Test
	void removeTag() {
		agenda.cadastraContato(2, "Matheus", "Gaudencio", "(83) 5555-5555");
		agenda.adicionarTag("2", "ufcg", 1);
		agenda.removeTag(2, 1);
		
	}

}
