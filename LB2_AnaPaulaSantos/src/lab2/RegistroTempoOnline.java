package lab2;

/**
 * Registro e informações sobre a quantidade de horas que um aluno tem 
 * dedicado a uma disciplina remota. Para cada disciplina é criado 
 * um objeto para o controle do tempo online usado.
 * 
 * @author Ana Paula
 */

public class RegistroTempoOnline {
	
    public int tempoOnlineEsperado;
    private int tempo;
    public String nomeDisciplina;

    
    
/**
 * Construtor que recebe apenas o nome da disciplina, e por padão define 
 * que o tempo online esperado para aquela disciplina é de 120 horas.
 * 
 * @param nomeDisciplina nome da disciplina que o aluno deseja cadastrar  
 */
    RegistroTempoOnline(String nomeDisciplina) {
        this.tempoOnlineEsperado = 120;
        this.nomeDisciplina = nomeDisciplina;
    }

/**
 * Construtor que recebe o nome da disciplina e o tempo online esperado 
 * pela disciplina. 
 *  
 * @param tempoOnlineEsperado tempo online esperado pela disciplina
 */
    RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.nomeDisciplina = nomeDisciplina;
    }
/**
 * Adiciona o tempo gasto com a disciplina cadastrada.
 * 
 * @param tempo o tempo gasto online com a disciplina
 */
    public void adicionaTempoOnline(int tempo) {
        this.tempo += tempo;
    }
/**
 * Verifica se o tempo gasto com a disciplina atingiu a meta do tempo esperado 
 * para a mesma.
 * @return um boolean true se já atingiu o tempo, caso não return false
 */
    boolean atingiuMetaTempoOnline() {
        return tempo >= tempoOnlineEsperado;
    }
    
 /**
  *@return string com o nome, o tempo gasto e o tempo esperado da disciplina.  
  */
    public String toString() {
        return nomeDisciplina + " " + tempo + "/" + tempoOnlineEsperado;
    }

}
