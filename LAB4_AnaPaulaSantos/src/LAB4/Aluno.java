package LAB4;

import java.util.Objects;

public class Aluno {
	private String nome;
	private String curso;
	private String matricula;
	
	
	
	/**
	 * Cria o objeto aluno, registando os atributos nome, curso e matricula.
	 * 
	 * @param nome do aluno
	 * @param curso do aluno
	 * @param matriculado aluno
	 */
	public Aluno(String nome, String curso, String matricula) {
		if(nome == null || curso == null || matricula == null) {
			throw new NullPointerException("Matrícula, nome ou curso nulo.");
		}
		if (nome.isBlank() || curso.isBlank() || matricula.isBlank()) {
			throw new IllegalArgumentException("Matrícula, nome ou curso vazio.");
		}
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
		
	}
	
    /**
     * @return Uma string com a matricula, nome e curso do aluno.
     */
	public String toString() {
		return this.matricula + " - " + this.nome + " - "+ this.curso;
	}
	
	
	/**
	 * @return um codigo que identifica o objeto unicamente 
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	
	/**
	 * verifica se um objeto aluno é igual a outro objeto aluno.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}


	

}
