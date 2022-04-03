package LAB4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Grupo {
	private String nome;
	private int tamanho;
	private Set<Aluno> alunos;
	
	
	/**
	 * Cria o objeto grupo, registrando o nome do grupo, 
	 * o tamanho(caso seja informado) e um conjunto de alunos.
	 * 
	 * @param nome do aluno
	 * @param tamanho do grupo
	 */
	public Grupo(String nome, String tamanho) {
		if(nome == null || tamanho == null) {
			throw new NullPointerException("Nome ou tamanho nulo.");
		}
		if (nome.isBlank() || tamanho.isBlank()) {
			throw new IllegalArgumentException("Nome ou Tamanho vazio.");
		}
		this.nome = nome;
		this.alunos = new HashSet<>();
		this.tamanho = Integer.parseInt(tamanho) - 1;
			
	}
	public Grupo(String nome) {
		if(nome == null) {
			throw new NullPointerException("Nome nulo.");
		}if(nome.isBlank()) {
			throw new IllegalArgumentException("Tamanho vazio.");
			
		}
	
		this.nome = nome;
		this.alunos = new HashSet<>();
		this.tamanho = -2;
		
	}
	
	/**
	 * Aloca um aluno no grupo, de acordo com a verificação de vaga no grupo.
	 * 
	 * @param aluno objeto do tipo Aluno
	 * @return true se o aluno foi cadastrado, se não false
	 */
	public boolean alocarAlunoNoGrupo(Aluno aluno){
		if(tamanho != -2) {
			if (!verificaGrupoCheio()) {
				alunos.add(aluno);
				return true;
				}
				return false;
			}
		
		else {
			alunos.add(aluno);
			return true;
		}
		
	}
	
	/**
	 * Verifica se o grupo está cheio.
	 * 
	 * @return false se o grupo estiver vazio, e true se estiver cheio.
	 */
	public boolean verificaGrupoCheio() {
		if (this.tamanho >= 0) {
			this.tamanho += -1;
			return false;
		}else {
			return true;
			}
	  
	}
		
	/**
	 * Verifica se o objeto Aluno está no conjunto de alunos do grupo.
	 * 
	 * @param aluno Objeto do Tipo Aluno
	 * @return true se o aluno pertence ao grupo, e false se não
	 */
	public boolean alunoPertenceAoGrupo(Aluno aluno) {
		return this.alunos.contains(aluno);
		
	}
	
	
	/**
	 * @return string com o nome do grupo
	 */
	public String toString() {
		return nome;
	}
	
    /**
     * codigo que identifica unicamente o objeto.
     */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
    /**
     * verifica se um objeto grupo é igual a outro objeto grupo.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nome.toLowerCase(), other.nome.toLowerCase());
	}
	
	
}
