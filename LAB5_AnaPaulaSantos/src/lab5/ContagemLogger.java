package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ContagemLogger  implements Logger{
	private List<String> metodos = new ArrayList<>();
	

	
	/**
	 * recebe o nome do m�todo e o primeiro parametro que foi invocado na BibliTeX. 
	 * 
	 */
	@Override
	public void logger(String metodo, String parametro) {
		this.metodos.add(metodo);
	}


	/**
	 * recebe o nome do metodo que foi invocado na BibliTeX.
	 * 
	 */
	@Override
	public void logger(String metodo) {
		this.metodos.add(metodo);
			
	}
		
	/**
	 * Conta quantas vezes cada m�todo do TransformaTexto foi executado at� o momento.
	 * 
	 * @return
	 */
	public String contagemLogger() {
		List<String> listaContagem = new ArrayList<>();
		Map<String, Integer> frequencias = new TreeMap<>();
            for (String c : metodos) {
                frequencias.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }

            frequencias.forEach((metodos, frequencia) -> listaContagem.add(metodos + " - " + frequencia));
        String listaContagemString = "\n";
        
            for (String string : listaContagem) {
                listaContagemString += string + "\n";
            }

	
		return listaContagemString;
	}
	
	/**
	 * Imprime quantas vezes cada m�todo foi invocado.
	 */
	public String toString() {
		return contagemLogger();
		
	}

}
