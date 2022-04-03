package lab5;

public class CleanSpaces implements AlgoritmoTransformacao{

	private String nome = "CleanSpaces";

	/**
	 * Transforma a string tirando todos os espa�os em branco.
	 */
	@Override
	public String transforma(String string) {
		if (string == null) {
			throw new NullPointerException("Frase nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("Frase inv�lida");
		}
		String[] listaString = string.split(" ");
		String stringTransformada = "";
		for(int i = 0; i < listaString.length; i++) {
			stringTransformada += listaString[i];
		}
			
		return stringTransformada;
	}
	
	/**
	 * Retorna o nome da transforma��o.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

	

}
