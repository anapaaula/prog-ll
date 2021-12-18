package LAB4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * O controle de alunos � um sistema que gerencia os alunos de programa��o II, que permite 
 * cadastrar e consultar alunos, cadastrar os alunos em grupos e registrar os alunos que 
 * responderam as quest�es no quadro. 
 * 
 * @author Ana Paula
 *
 */
public class ControleDeAlunos {
	
	private Map<String, Aluno> alunosMap;
	private Map<String, Grupo> gruposMap;
	private ArrayList<Aluno> alunosQueResponderam;
	
	/**
	 * Inicia o controle de alunos criando dois maps com keys de string,
	 * e com os objetos Aluno e Grupo, respectivamente. E tamb�m cria uma ArrayList de aluno.
	 *  
	 */
	public ControleDeAlunos() {
		this.alunosMap = new HashMap<>();
		this.gruposMap = new HashMap<>();
		this.alunosQueResponderam = new ArrayList<Aluno>();
	}
	
	
    /**
     * Cadastra o aluno no sistema, de acordo com a verifica��o da matricula passada. 
     * Caso a matricula j� exista o aluno n�o � cadastrado.
     * 
     * @param nome nome do aluno
     * @param matricula matricula do aluno
     * @param curso curso do aluno
     * @return false se o aluno n�o foi cadastrado e true se o aluno foi cadastrado.
     */
	public boolean cadastrarAluno(String nome, String matricula, String curso) {
		if (!this.alunosMap.containsKey(matricula)) {
			this.alunosMap.put(matricula, new Aluno(nome,curso, matricula));
			return true;
		}
		return false;
	}
	
	/**
	 * Exibi o aluno de acordo com sua matricula. 
	 * 
	 * @param matricula matricula do aluno
	 * @return Se o aluno n�o existir retorna "Aluno n�o cadastrado", ou retorna uma string com o nome, curso e matricula do aluno
	 */
	public String exibirAluno(String matricula) {
		if (this.alunosMap.get(matricula) == null) {
			return "Aluno n�o cadastrado.";
		}
		return this.alunosMap.get(matricula).toString();
	}
	
	/**
	 * Cria um grupo de acordo com o nome e o tamanho passado. Caso o tamanho n�o seja passado o grupo 
	 * � criado sem restri��o de tamanho.
	 * 
	 * @param grupo nome do grupo
	 * @param tamanho tamanho do grupo
	 * @return true se o grupo foi criado e false se n�o
	 */
	public boolean novoGrupo(String grupo, String tamanho) {
		if (!this.gruposMap.containsKey(grupo.toLowerCase())) {
			if (tamanho == null || tamanho.isBlank()) {
				this.gruposMap.put(grupo.toLowerCase(), new Grupo(grupo));
			return true;
		}else {
			this.gruposMap.put(grupo.toLowerCase(), new Grupo(grupo, tamanho));
			return true;
		}
	}
		return false;
	}
	
	/**
	 * Aloca o aluno no grupo.
	 * � retornado uma mensagem informando que o aluno n�o � cadastrado ou Grupo n�o � cadastrado, caso o aluno ou o grupo n�o existam.
	 * � retornado aluno alocado, se o grupo existe, o aluno existe, e o grupo possui vaga. 
	 * � retornado grupo cheio, se o grupo e o aluno existem, mas n�o possui vaga no grupo.
	 * 
	 * @param matricula matricula do aluno que ser� cadastrado 
	 * @param grupo nome do grupo
	 * @return "ALUNO ALOCADO!", "GRUPO CHEIO!" e "Aluno n�o cadastrado.\nGrupo n�o cadastrado."
	 */
	public String alocarAlunoNoGrupo(String matricula, String grupo) {
		if (this.gruposMap.containsKey(grupo.toLowerCase()) && this.alunosMap.containsKey(matricula))
			if (this.gruposMap.get(grupo.toLowerCase()).alocarAlunoNoGrupo(this.alunosMap.get(matricula))) {
				  return "ALUNO ALOCADO!";
			}else {
				return "GRUPO CHEIO!";
				
		}else {
			return "Aluno n�o cadastrado.\nGrupo n�o cadastrado.";
		}
		
	}
	
	
	/**
	 * Verifica se o aluno est� no grupo.
	 * � retornado uma mensagem informando que o aluno n�o est� cadastrado, se o aluno n�o existir no sistema.
	 * � retornado aluno pertence ao grupo, se o aluno estiver no grupo. 
	 * � retornado que o aluno n�o pertence ao grupo, se o mesmo n�o estiver no grupo.
	 * � retornado grupo n�o cadastrado caso o grupo n�o exista.
	 * 
	 * @param grupo nome do grupo
	 * @param aluno matricula do aluno
	 * @return "ALUNO N�O CADASTRADO.", "ALUNO PERTENCE AO GRUPO", "ALUNO N�O PERTENCE AO GRUPO" e "GRUPO N�O CADASTRADO."
	 */
    public String alunoPertenceAoGrupo(String grupo, String aluno) {
    	if (!this.alunosMap.containsKey(aluno)) {
    		return "ALUNO N�O CADASTRADO.";
    		}
    	if (this.gruposMap.containsKey(grupo.toLowerCase())) {
    		if(this.gruposMap.get(grupo.toLowerCase()).alunoPertenceAoGrupo(this.alunosMap.get(aluno))) {
    			return "ALUNO PERTENCE AO GRUPO";
    		}else {
    			return "ALUNO N�O PERTENCE AO GRUPO";
    		}
    	} else {
    			return "GRUPO N�O CADASTRADO."; 
    		}
    	}
    
    
	/**
	 * Registra se o aluno respondeu uma quest�o no quadro.
	 * 
	 * @param matricula matricula do aluno
	 * @return true se o aluno existe e foi cadastrado, se n�o retorna false
	 */
    public boolean registrarAlunoRespondeu(String matricula) {
    	if (this.alunosMap.containsKey(matricula)) {
    		this.alunosQueResponderam.add(this.alunosMap.get(matricula));
    		return true;
    	}
    	return false;		
    }
    
    
    /**
     * Imprime um lista de alunos que responderam quest�es no quadro, seguindo a a ordem de cadastro.
     * 
     * @return "Nenhum aluno respondeu no quadro." ou uma lista de alunos
     */
    public String imprimirAlunosResponderam() {
    	String listaAlunos = "";
    	int contador = 1;
        for (int i = 0; i < this.alunosQueResponderam.size(); i++) {
            listaAlunos += String.format("%d. %s\n", contador, this.alunosQueResponderam.get(i).toString());
            contador += 1;
        }
        if(listaAlunos.isBlank()) {
        	return "Nenhum aluno respondeu no quadro.";
        }
        return "Alunos:\n" + listaAlunos;
 
    }
    /**
     * Verifica em quais grupos o aluno est� cadastrado, e retorna uma string com os nomes dos 
     * grupos que o aluno estiver cadastrado.
     * 
     * @param matricula matricula do aluno
     * @return "Aluno n�o est� em nenhum grupo!" ou uma lista de grupos.
     */
    public String quaisGruposDoAluno(String matricula) {
    	String gruposDoAluno = "";
    	    for (Grupo grupo : this.gruposMap.values()) {
    	        if(grupo.alunoPertenceAoGrupo(this.alunosMap.get(matricula))) {
    	        	gruposDoAluno += String.format("- %s\n", grupo);
    	        }
    	}
    	if (gruposDoAluno.isBlank()) {
    		return "Aluno n�o est� em nenhum grupo!";
    	}
    	return "\nGrupos:\n" + gruposDoAluno;

    	 }
}
