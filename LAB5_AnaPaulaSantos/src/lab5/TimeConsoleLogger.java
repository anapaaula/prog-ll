package lab5;

public class TimeConsoleLogger implements Logger {
	
	private long tempoInicial;
	
	
	/**
	 * Inicializa o TimeConsoleLogger e registra o momento em que a classe foi iniciada.
	 */
	public TimeConsoleLogger() {
		this.tempoInicial = System.currentTimeMillis();
		
	}
	
	
	
	/**
	 * recebe o nome do metodo e o primeiro parametro que foi invocado na BibliTeX.
	 * Imprime o momento em que cada método foi executado em relação ao momento que o objeto 
	 * TimeConsoleLogger foi criado em ms.
	 */
	@Override
	public void logger(String metodo, String parametro) {
		long tempoVariavel = System.currentTimeMillis();
		String acao = "[" + metodo +  " - " + (tempoVariavel - this.tempoInicial) + "ms]" + " " + parametro;
		System.out.println(acao);
	}
	

	/**
	 * recebe o nome do metodo que foi invocado na BibliTeX.
	 * Imprime o momento em que cada método foi executado em relação ao momento que o objeto 
	 * TimeConsoleLogger foi criado em ms.
	 */
	@Override
	public void logger(String metodo) {
		long tempoVariavel = System.currentTimeMillis();
		String acao = "[" + metodo + " - " + (tempoVariavel - this.tempoInicial) + "ms]";
		System.out.println(acao);
		
	}
	

}
