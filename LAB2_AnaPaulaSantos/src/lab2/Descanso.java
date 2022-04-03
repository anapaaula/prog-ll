package lab2;
/**
 * Representa��o da rotina de descanso de um estudante.
 * Para que um aluno possa se considerar descansado, � preciso 
 * que o mesmo tenha registrado 26 horas, ou mais, de descanso por semana. 
 * 
 * @author Ana Paula
 */
public class Descanso {
	 private int horas;
	    private int semanas;
	    private int horasDescanso;
	    
/**
 * Define as horas totais de descanso do aluno, durante as semanas 
 * que ser�o apresentadas.
 * 
 * @param horas as horas de descanso do aluno
 */

	    public void defineHorasDescanso(int horas) {
	        this.horas = horas;
	    }
/**
 * Define as semanas que o aluno cadastrou para verificar a sua rotina de descanso.
 * 
 * @param semanas as semanas de descanso do aluno
 */
	    public void defineNumeroSemanas(int semanas) {
	         this.semanas = semanas;
	    }
/**
 * Define se um aluno est� cansado ou n�o atrav�s da equa��o 
 * de divis�o das horas pelas semanas.  
 * 
 * @return uma string informando se o aluno est� cansado ou descansado.
 */
	    public String getStatusGeral() {
	        if (semanas != 0 && horas != 0){
	            horasDescanso = horas / semanas;
	        }
	        if (horasDescanso >= 26){
	            return "descansado";
	        }
	        else{
	            return "cansado";
	        }
	    }
}
