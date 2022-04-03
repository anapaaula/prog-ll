package lab5;

public class UpperCase implements AlgoritmoTransformacao{

	private String nome = "upperCase";
	
	
	
	/**
	 * Transforma toda a string para letras mai�sculas.
	 */
	@Override
	public String transforma(String string) {
		if (string == null) {
			throw new NullPointerException("Frase nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("Frase inv�lida");
		}
		String fraseUpperCase = string.toUpperCase();  
		return fraseUpperCase;
	}
	
	
	/**
	 * Retorna o nome da transforma��o.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

	

}
