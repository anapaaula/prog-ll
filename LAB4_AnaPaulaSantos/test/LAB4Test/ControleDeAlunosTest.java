package LAB4Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LAB4.ControleDeAlunos;

class ControleDeAlunosTest {
	ControleDeAlunos controle = new ControleDeAlunos();

	@BeforeEach
	void iniciandoControleDeAlunos() {
		assertTrue(this.controle.cadastrarAluno("Gabriel Reyes","250","Computa��o"));
		assertTrue(this.controle.cadastrarAluno("Lili Camposh","200","Computa��o"));
		assertTrue(this.controle.cadastrarAluno("Angela Ziegler","202","Medicina"));
		assertTrue(this.controle.cadastrarAluno("Torbjorn Lindholm","201","Engenharia Mec�nica"));
	}

	@Test
	void testCadastrarAlunoIgual() {
		assertFalse(this.controle.cadastrarAluno("Torbjorn Lindholm","201","Engenharia Mec�nica"));

}
	@Test
	void novoGrupoSemTamanho() {
		assertTrue(this.controle.novoGrupo("Programa��o OO",""));
	}
	
	@Test
	void novoGrupoComTamanho() {
		assertTrue(this.controle.novoGrupo("Listas","10"));
		
	}
	@Test
	void novoGrupoExistente() {
		assertTrue(this.controle.novoGrupo("Listas","10"));
		assertFalse(this.controle.novoGrupo("Listas",""));
		
	}
	@Test
	void alocarAlunoNoGrupo() {
		assertTrue(this.controle.novoGrupo("Programa��o OO",""));
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Programa��o OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("202", "Programa��o OO"), "ALUNO ALOCADO!");
		
	}
	@Test
	void alocarAlunoJaAlocadoNoGrupo() {
		assertTrue(this.controle.novoGrupo("Programa��o OO",null));
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Programa��o OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("202", "Programa��o OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Programa��o OO"), "ALUNO ALOCADO!");
	}
	
	@Test
	void alocarAlunoNaoExistente() {
		assertTrue(this.controle.novoGrupo("Programa��o OO",null));
		assertEquals(this.controle.alocarAlunoNoGrupo("100", "Programa��o OO"), "Aluno n�o cadastrado.\nGrupo n�o cadastrado.");

	}
	
	@Test
	void alocarAlunoEmGrupoNaoExistente() {
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Anatomia"), "Aluno n�o cadastrado.\nGrupo n�o cadastrado.");

	}
	
	@Test
	void alocarAlunoComRestricaoDeTamanho() {
		assertTrue(this.controle.novoGrupo("Listas","1"));
		assertEquals(this.controle.alocarAlunoNoGrupo("250", "Listas"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("202", "Listas"), "GRUPO CHEIO!");
	}
	
	@Test
	void alunoPertenceAoGrupo() {
		assertTrue(this.controle.novoGrupo("listas",""));
		assertEquals(this.controle.alocarAlunoNoGrupo("250", "Listas"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alunoPertenceAoGrupo("listas", "250"), "ALUNO PERTENCE AO GRUPO");
		assertEquals(this.controle.alunoPertenceAoGrupo("Listas", "201"), "ALUNO N�O PERTENCE AO GRUPO");
		
	}
	
	@Test
	void alunoPertenceAoGrupoInexistente() {
		assertEquals(this.controle.alunoPertenceAoGrupo("Anatomia", "200"), "GRUPO N�O CADASTRADO.");
		
	}
	
	@Test
	void alunoInexistentePertenceAoGrupo() {
		assertTrue(this.controle.novoGrupo("Programa��o OO",""));
		assertEquals(this.controle.alunoPertenceAoGrupo("100", "Programa��o OO"), "ALUNO N�O CADASTRADO.");
	
	}
	
	@Test
	void imprimirGruposDeAlunoSemGrupo() {
		assertEquals(this.controle.quaisGruposDoAluno("202"), "Aluno n�o est� em nenhum grupo!");
	}
	
	@Test
	void imprimirGruposDeAlunoComGrupos() {
		assertTrue(this.controle.novoGrupo("Programa��o OO",""));
		assertTrue(this.controle.novoGrupo("Listas","10"));
		assertEquals(this.controle.alocarAlunoNoGrupo("250", "listas"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("250", "programa��o OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.quaisGruposDoAluno("250"), "\nGrupos:\n- Programa��o OO\n- Listas\n");
	}
	
	
	@Test
	void exibirAlunoN�oCadastrado() {
		assertEquals(this.controle.exibirAluno("100"), "Aluno n�o cadastrado.");
	
	}
	
	@Test
	void exibirAlunoExistente() {
		assertEquals(this.controle.exibirAluno("250"), "250 - Gabriel Reyes - Computa��o");
	
	}
	
	@Test
	void registrarAlunoInexistenteRespondeu() {
		assertFalse(this.controle.registrarAlunoRespondeu("100"));
	}
	
	@Test
	void registrarAlunoExistenteRespondeu() {
		assertTrue(this.controle.registrarAlunoRespondeu("250"));
	}
	
	@Test
	void imprimirAlunosResponderam() {
		assertTrue(this.controle.registrarAlunoRespondeu("250"));
		assertTrue(this.controle.registrarAlunoRespondeu("200"));
		assertTrue(this.controle.registrarAlunoRespondeu("250"));
		assertEquals(this.controle.imprimirAlunosResponderam(), "Alunos:\n1. 250 - Gabriel Reyes - Computa��o\n2. 200 - Lili Camposh - Computa��o\n3. 250 - Gabriel Reyes - Computa��o\n");
		
	}
	
	@Test
	void imprimirNenhumAlunoRespondeu() {
		assertEquals(this.controle.imprimirAlunosResponderam(), "Nenhum aluno respondeu no quadro.");
		
	}
	
	
	
	
	
	
	
	
}
