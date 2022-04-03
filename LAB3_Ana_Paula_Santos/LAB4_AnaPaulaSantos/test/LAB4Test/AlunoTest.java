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
		this.aluno1 = new Aluno("Gabriel Reyes", "Computação","250");
		this.aluno2 = new Aluno("Lili Camposh", "Computação","200");
		
	}

	@Test
	void testConstrutorMatriculaVazia() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", "Computação","");
			fail("Esperado uma exceção");
		}catch(IllegalArgumentException iae){
	}

	}
	@Test
	void testConstrutorNomeVazio() {
		try {
			Aluno aluno = new Aluno("", "Computação","250");
			fail("Esperado uma exceção");
		}catch(IllegalArgumentException iae){
	}

	}
	@Test
	void testConstrutorCursoVazio() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", "","250");
			fail("Esperado uma exceção");
		}catch(IllegalArgumentException iae){
	}

	}
	@Test
	void testConstrutorMatriculaNull() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", "Computação",null);
			fail("Esperado uma exceção");
		}catch(NullPointerException npe){
	}

	}
	@Test
	void testConstrutorNomeNull() {
		try {
			Aluno aluno = new Aluno(null, "Computação","250");
			fail("Esperado uma exceção");
		}catch(NullPointerException npe){
	}

	}
	@Test
	void testConstrutorCursoNull() {
		try {
			Aluno aluno = new Aluno("Gabriel Reyes", null, "250");
			fail("Esperado uma exceção");
		}catch(NullPointerException npe){
	}

	}
	
	@Test
	void toStringTest() {
		assertEquals(this.aluno1.toString(), "250 - Gabriel Reyes - Computação");
		assertEquals(this.aluno2.toString(), "200 - Lili Camposh - Computação");
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
