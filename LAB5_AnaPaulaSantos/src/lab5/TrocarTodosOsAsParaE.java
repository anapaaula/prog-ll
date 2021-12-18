package lab5;

public class TrocarTodosOsAsParaE implements AlgoritmoTransformacao{
	
	private String nome = "TrocarTodosOsAsParaE";

	
	/**
	 * Transforma a string trocando todos os As para Es. Sem considerar letras com acentos.
	 */
	@Override
	public String transforma(String string) {
		
		if (string == null) {
			throw new NullPointerException("Frase nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("Frase inválida");
		}
		String stringTransformada = string.replaceAll("A", "E");
		String stringTransformada2 = stringTransformada.replaceAll("a", "e");
		return stringTransformada2;
	}
	
	/**
	 * Retorna o nome da transformação.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
