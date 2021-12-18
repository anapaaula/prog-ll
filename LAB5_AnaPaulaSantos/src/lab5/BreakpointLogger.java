package lab5;

public class BreakpointLogger implements Logger{
	
	private String metodo;
	
	
	/**
	 * Inicializa o BreakpointLogger com o metodo que será impresso sempre que for invocado.
	 * 
	 * @param metodo
	 */
	public BreakpointLogger(String metodo) {
		this.metodo = metodo;
		
	}
	
	/**
	 * Recebe o nome do metodo invocado.
	 */
	@Override
	public void logger(String metodo, String parametro) {
		if(this.metodo.equals(metodo)) {invocacaoDoMetodo();}
		
	}
	
	/**
	 * Recebe o nome do metodo invocado.
	 */
	@Override
	public void logger(String metodo) {
		if(this.metodo.equals(metodo)) {invocacaoDoMetodo();}
		
	}
	
	/**
	 * Imprime o método.
	 */
	public void invocacaoDoMetodo() {
		System.out.println("[INVOCADO - " + this.metodo + "]");
		
	}
	

}
