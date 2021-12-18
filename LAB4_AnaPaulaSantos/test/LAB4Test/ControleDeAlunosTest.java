package LAB4Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LAB4.ControleDeAlunos;

class ControleDeAlunosTest {
	ControleDeAlunos controle = new ControleDeAlunos();

	@BeforeEach
	void iniciandoControleDeAlunos() {
		assertTrue(this.controle.cadastrarAluno("Gabriel Reyes","250","Computação"));
		assertTrue(this.controle.cadastrarAluno("Lili Camposh","200","Computação"));
		assertTrue(this.controle.cadastrarAluno("Angela Ziegler","202","Medicina"));
		assertTrue(this.controle.cadastrarAluno("Torbjorn Lindholm","201","Engenharia Mecânica"));
	}

	@Test
	void testCadastrarAlunoIgual() {
		assertFalse(this.controle.cadastrarAluno("Torbjorn Lindholm","201","Engenharia Mecânica"));

}
	@Test
	void novoGrupoSemTamanho() {
		assertTrue(this.controle.novoGrupo("Programação OO",""));
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
		assertTrue(this.controle.novoGrupo("Programação OO",""));
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Programação OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("202", "Programação OO"), "ALUNO ALOCADO!");
		
	}
	@Test
	void alocarAlunoJaAlocadoNoGrupo() {
		assertTrue(this.controle.novoGrupo("Programação OO",null));
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Programação OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("202", "Programação OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Programação OO"), "ALUNO ALOCADO!");
	}
	
	@Test
	void alocarAlunoNaoExistente() {
		assertTrue(this.controle.novoGrupo("Programação OO",null));
		assertEquals(this.controle.alocarAlunoNoGrupo("100", "Programação OO"), "Aluno não cadastrado.\nGrupo não cadastrado.");

	}
	
	@Test
	void alocarAlunoEmGrupoNaoExistente() {
		assertEquals(this.controle.alocarAlunoNoGrupo("200", "Anatomia"), "Aluno não cadastrado.\nGrupo não cadastrado.");

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
		assertEquals(this.controle.alunoPertenceAoGrupo("Listas", "201"), "ALUNO NÃO PERTENCE AO GRUPO");
		
	}
	
	@Test
	void alunoPertenceAoGrupoInexistente() {
		assertEquals(this.controle.alunoPertenceAoGrupo("Anatomia", "200"), "GRUPO NÃO CADASTRADO.");
		
	}
	
	@Test
	void alunoInexistentePertenceAoGrupo() {
		assertTrue(this.controle.novoGrupo("Programação OO",""));
		assertEquals(this.controle.alunoPertenceAoGrupo("100", "Programação OO"), "ALUNO NÃO CADASTRADO.");
	
	}
	
	@Test
	void imprimirGruposDeAlunoSemGrupo() {
		assertEquals(this.controle.quaisGruposDoAluno("202"), "Aluno não está em nenhum grupo!");
	}
	
	@Test
	void imprimirGruposDeAlunoComGrupos() {
		assertTrue(this.controle.novoGrupo("Programação OO",""));
		assertTrue(this.controle.novoGrupo("Listas","10"));
		assertEquals(this.controle.alocarAlunoNoGrupo("250", "listas"), "ALUNO ALOCADO!");
		assertEquals(this.controle.alocarAlunoNoGrupo("250", "programação OO"), "ALUNO ALOCADO!");
		assertEquals(this.controle.quaisGruposDoAluno("250"), "\nGrupos:\n- Programação OO\n- Listas\n");
	}
	
	
	@Test
	void exibirAlunoNãoCadastrado() {
		assertEquals(this.controle.exibirAluno("100"), "Aluno não cadastrado.");
	
	}
	
	@Test
	void exibirAlunoExistente() {
		assertEquals(this.controle.exibirAluno("250"), "250 - Gabriel Reyes - Computação");
	
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
		assertEquals(this.controle.imprimirAlunosResponderam(), "Alunos:\n1. 250 - Gabriel Reyes - Computação\n2. 200 - Lili Camposh - Computação\n3. 250 - Gabriel Reyes - Computação\n");
		
	}
	
	@Test
	void imprimirNenhumAlunoRespondeu() {
		assertEquals(this.controle.imprimirAlunosResponderam(), "Nenhum aluno respondeu no quadro.");
		
	}
	
	
	
	
	
	
	
	
}
