package lab5;

public class ConverteInterrogacoesParaPontos implements AlgoritmoTransformacao{
	private String nome = "InterrogaPraPontos";
	
	
	/**
	 * Transforma a string trocando todas as interrogações para pontos.
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
			if (listaString[i].equals("?")) {
				stringTransformada += ".";
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
		return this.nome;
	}

	

	

}
