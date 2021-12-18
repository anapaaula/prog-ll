package lab5;

public class ConsoleLogger implements Logger {
	
	
	/**
	 * recebe o nome do método e o primeiro parametro que foi invocado na BibliTeX. 
	 * E imprime o nome do método e do parametro.
	 */
	public void logger(String metodo, String parametro) {
		String acao = "[" + metodo + "]" + " " + parametro;
		System.out.println(acao);
	}
	
	/**
	 * recebe o nome do metodo que foi invocado na BibliTeX.
	 * E imprime o nome do método.
	 */
	public void logger(String metodo) {
		String acao = "[" + metodo + "]";
		System.out.println(acao);
		
	}
	
	
	


}
