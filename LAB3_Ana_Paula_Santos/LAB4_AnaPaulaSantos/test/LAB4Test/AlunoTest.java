package LAB4Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LAB4.Aluno;
import LAB4.Grupo;

class AlunoTest {
	private Aluno aluno1;
	private Aluno aluno2;
	
	
	@BeforeEach
	void iniciandoAluno() {
		this.aluno1 = new Aluno("Gabriel Reyes", "Computa��o","250");
		this.aluno2 = new Aluno("Lili Camposh", "Computa��o","200");
		
	}

	@Test
	void testConstrutorMatriculaVazia() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", "Computa��o","");
			fail("Esperado uma exce��o");
		}catch(IllegalArgumentException iae){
	}

	}
	@Test
	void testConstrutorNomeVazio() {
		try {
			Aluno aluno = new Aluno("", "Computa��o","250");
			fail("Esperado uma exce��o");
		}catch(IllegalArgumentException iae){
	}

	}
	@Test
	void testConstrutorCursoVazio() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", "","250");
			fail("Esperado uma exce��o");
		}catch(IllegalArgumentException iae){
	}

	}
	@Test
	void testConstrutorMatriculaNull() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", "Computa��o",null);
			fail("Esperado uma exce��o");
		}catch(NullPointerException npe){
	}

	}
	@Test
	void testConstrutorNomeNull() {
		try {
			Aluno aluno = new Aluno(null, "Computa��o","250");
			fail("Esperado uma exce��o");
		}catch(NullPointerException npe){
	}

	}
	@Test
	void testConstrutorCursoNull() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", null, "250");
			fail("Esperado uma exce��o");
		}catch(NullPointerException npe){
	}

	}
	
	@Test
	void toStringTest() {
		assertEquals(this.aluno1.toString(), "250 - Gabriel Reyes - Computa��o");
		assertEquals(this.aluno2.toString(), "200 - Lili Camposh - Computa��o");
	}
	
	@Test
	void equalsTestAlunosComMatriculasIguais() {
		Aluno aluno = new Aluno("Angela Ziegler", "Medicina", "250");
		assertTrue(this.aluno1.equals(aluno));
		
	}
	
	@Test
	void equalsTestObjetosComMatriculasDiferentes() {
		assertFalse(this.aluno1.equals(this.aluno2));
		
	}
	@Test
	void equalsTestObjetoNull() {
		Aluno aluno = null;
		assertFalse(this.aluno1.equals(aluno));
		
	}
	@Test
	void equalsTestObjetosIguais() {
		assertTrue(this.aluno1.equals(this.aluno1));
		
	}
	
	@Test
	void equalsTestObjetosDiferentes() {
		Grupo grupo = new Grupo("Listas", "10");
		assertFalse(this.aluno1.equals(grupo));
	}
	
	

	
	
	
	
	}
