package lab5;

public class Clean implements AlgoritmoTransformacao{
	
	private String nome = "clean";
	

	/**
	 * Transforma a string tirando todos os sinais de pontua��o e upperCase.
	 */
	@Override
	public String transforma(String string) {
		if (string == null) {
			throw new NullPointerException("Frase nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("Frase inv�lida");
		}
		String stringTransformada = string.replaceAll("\\p{Punct}", "").toLowerCase();
		return stringTransformada; 
	}
	
	/**
	 * Retorna o nome da transforma��o.
	 */
	@Override
	public String getNome() {
		return nome;
		
	}


}
