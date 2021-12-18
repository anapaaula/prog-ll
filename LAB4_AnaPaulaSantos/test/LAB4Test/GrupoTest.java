package LAB4Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LAB4.Aluno;
import LAB4.Grupo;

class GrupoTest {
	
	private Grupo grupo1;
	private Grupo grupo2;

	@BeforeEach
	void iniciandoGrupo() {
		this.grupo1 = new Grupo("Lista");
		this.grupo2 = new Grupo("Progração OO", "1");
    }
	
	@Test
	void grupoComNomeNull() {
		try {
			Grupo grupo = new Grupo(null, "10");
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void grupoComTamanhoNull() {
		try {
			Grupo grupo = new Grupo("Lista", null);
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void grupoComNomeVazio() {
		try {
			Grupo grupo = new Grupo("", "10");
			fail("Era esperado uma exceção");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void grupoComTamanhoVazio() {
		try {
			Grupo grupo = new Grupo("Lista", "");
			fail("Era esperado uma exceção");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void grupoComNomeVazioConstrutor2() {
		try {
			Grupo grupo = new Grupo("");
			fail("Era esperado uma exceção");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	void grupoComNomeNullConstrutor2() {
		try {
			Grupo grupo = new Grupo(null);
			fail("Era esperado uma exceção");
		}catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void alocandoAlunoNoGrupoSemLimiteDeTamanho() {
		assertTrue(this.grupo1.alocarAlunoNoGrupo(new Aluno("Gabriel Reyes", "Computação", "250")));
	}
	
	@Test
	void alocandoAlunoNoGrupoComLimiteDeTamanho() {
		assertTrue(this.grupo2.alocarAlunoNoGrupo(new Aluno("Gabriel Reyes", "Computação", "250")));
		assertFalse(this.grupo2.alocarAlunoNoGrupo(new Aluno("Lili Camposh", "Computação", "200")));
	}
	
	@Test
	void AlunoPertenceAoGrupo() {
		Aluno aluno = new Aluno("Gabriel Reyes", "Computação", "250");
		assertTrue(this.grupo1.alocarAlunoNoGrupo(aluno));
		assertTrue(this.grupo1.alunoPertenceAoGrupo(aluno));
		
		
	}
	@Test
	void AlunoNaoPertenceAoGrupo() {
		Aluno aluno = new Aluno("Gabriel Reyes", "Computação", "250");
		assertFalse(this.grupo1.alunoPertenceAoGrupo(aluno));
		
	}
	@Test
	void toStringTest() {
		assertEquals(this.grupo1.toString(), "Lista");
		
	}
	
	
	@Test
	void equalsTestGruposComNomesIguais() {
		Grupo grupo = new Grupo("LISTA", "250");
		assertTrue(this.grupo1.equals(grupo));
		
	}
	
	@Test
	void equalsTestObjetosComNomesDiferentes() {
		assertFalse(this.grupo1.equals(this.grupo2));
		
	}
	@Test
	void equalsTestObjetoNull() {
		Grupo grupo = null;
		assertFalse(this.grupo1.equals(grupo));
		
	}
	@Test
	void equalsTestObjetosIguais() {
		assertTrue(this.grupo1.equals(this.grupo1));
		
	}
	
	@Test
	void equalsTestObjetosDiferentes() {
		Aluno aluno = new Aluno("Matheus", "ccc", "123");
		assertFalse(this.grupo1.equals(aluno));
	}
	
}