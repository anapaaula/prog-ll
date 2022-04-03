package lab5;

public class CaMeLcAsEfY implements AlgoritmoTransformacao{
	private String nome = "CaMeLcAsEfY";
	
	
	/**
	 * Transfoma a string trocando as letras em posições pares para maiúsculas.
	 */
	@Override
	public String transforma(String string) {
		if (string == null) {
			throw new NullPointerException("Frase nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("Frase inválida");
		}
		String[] listaString = string.split("");
		String stringTransformada = "";
		for(int i = 0; i < listaString.length; i++) {
			if (i % 2 == 0) {
				stringTransformada += listaString[i].toUpperCase();
			}else {
				stringTransformada += listaString[i];
			}
		}
		
		return stringTransformada;

}	
	
	/**
	 * Retorna o nome da transformação.
	 */
	@Override
	public String getNome() {
		return nome;
		
	}
	

}
