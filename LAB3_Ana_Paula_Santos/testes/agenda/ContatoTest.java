package agenda;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;


class ContatoTest {
	
	/**
	 * Testa o caso base do construtor
	 */
	@Test
	public void testContato() {
		new Contato("Ana", "Paula", "(83)5555-5555");
	}
	
	/**
	 * Testa o construtor com nome nulo
	 */
	@Test
	public void testContatoNomeNull() {
		try {
		
			new Contato(null,"Gaudencio","(83)5555-5555");
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe){
			
		}
	}
	/**
	 * Testa o construtor com nome vazio ou branco
	 */
	@Test
	public void testContatoNomeBranco() {
		try{
			 new Contato("","Gaudencio","(83)5555-5555");
			 fail("Era esperado uma exceção");
			
		}catch(IllegalArgumentException iea){
			
		}
		
	}

	/**
	 * Testa o construtor com telefone nulo
	 */
	@Test
	public void testContatoTelefoneNull() {
		try{
			 new Contato("Matheus","Gaudencio",null);
			 fail("Era esperado uma exceção");
	
		}catch(NullPointerException npe){
			
		}
	}
	/**
	 * Testa o construtor com telefone vazio ou branco
	 */
	@Test
	public void testContatoTelefoneBranco() {
		try{
			new Contato("Matheus","Gaudencio","");
			fail("Era esperado uma exceção");
		
		}catch(IllegalArgumentException iea){
				
		}
			
		}
	
	/**
	 * Testa o construtor com sobrenome nulo
	 */
	@Test
	public void testContatoSobrenomeNull() {
		new Contato("Matheus",null,"(83)5555-5555");
		
	}
	
	/**
	 * Testa o construtor com sobrenome vazio ou branco
	 */
	@Test
	public void testContatoSobrenomeBranco() {
		new Contato("Matheus","","(83)5555-5555");
		
	}
	

			
	/**
	 * Testa o caso básico do método cadastrarTag
	 */
	@Test
	public void testCadastrarTag() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		ana.cadastrarTag("ufcg", 1);
		ana.cadastrarTag("ccc", 5);
		
		
	}
	
	/**
	 * Testa o cadastrarTag com uma posição acima do limite da array de tags
	 */
	@Test
	public void testCadastrarTagPosicaoInvalida1() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		try {
			ana.cadastrarTag("ccc", 6);
			fail("Era esperado uma exceção");
		}catch(IndexOutOfBoundsException nee){
			
		}
}   
	
	/**
	 * Testa o cadastrarTag com uma posição abaixo do limite da array de tags
	 */
	@Test
	public void testCadastrarTagPosicaoInvalida2() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		try {
			ana.cadastrarTag("ccc", 0);
			fail("Era esperado uma exceção");
		}catch(IndexOutOfBoundsException nee){
			
		}
	
	
}
	/**
	 * Testa o retorno do método toString(), se o contato não tiver cadastrado nenhuma tag.
	 */
	@Test
	public void testToString() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		assertEquals("Ana Paula\n(83)5555-5555", ana.toString());
	}
	
	/**
	 * Testa o retorno do método toString(), se o contato tiver cadastrado uma tag.
	 */
	@Test
	public void testToStringTags() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		ana.cadastrarTag("ufcg", 1);
		assertEquals("Ana Paula\n(83)5555-5555\nufcg ", ana.toString());
	}
	
	@Test
	public void testRemoveTag() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		ana.cadastrarTag("ufcg", 1);
		ana.removeTag(1);
		assertEquals("Ana Paula\n(83)5555-5555", ana.toString());
	}
	
	@Test
	public void testRemoveTagPosicaoInvalida1() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		ana.cadastrarTag("ufcg", 1);
		try {
			ana.removeTag(0);
			fail("Era esperado uma exceção");
		}catch(IndexOutOfBoundsException ioobe) {
			
		}
		
	}
	
	@Test
	public void testRemoveTagPosicaoInvalida2() {
		Contato ana = new Contato("Ana", "Paula", "(83)5555-5555");
		ana.cadastrarTag("ufcg", 1);
		try {
			ana.removeTag(6);
			fail("Era esperado uma exceção");
		}catch(IndexOutOfBoundsException ioobe) {
			
		}
	
}
}

