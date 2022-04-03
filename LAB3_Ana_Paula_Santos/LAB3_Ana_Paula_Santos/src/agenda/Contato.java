package agenda;

public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	private String[] tags = new String[5];
	
	/**
	 * Construtor que recebe o nome, sobrenome e telefone do contato e registra no objeto.
	 * 
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato 
	 * @param telefone telefone do contato
	 */
	 public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null || telefone == null) {
			throw new NullPointerException("nome ou telefone nulo");
		}
		if (nome.isBlank() || telefone.isBlank()) {
			throw new IllegalArgumentException("telefone ou nome vazio");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		
	}
	/**
	 * @return retorna o nome
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * @return retorna o sobrenome
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	/**
	 * @return retorna o telefone
	 */
	public String getTelefone() {
		return this.telefone;
	}	
	/**
	 * Registras as tags na array de tags.
	 * 
	 * @param tag string com a tag
	 * @param posicaoTag posicao da tag na array
	 */
	public void cadastrarTag(String tag, int posicaoTag) {
		if (posicaoTag > 5 || posicaoTag < 1) {
			throw new IndexOutOfBoundsException("Posição de tag inválida");
		}
		this.tags[posicaoTag - 1] = tag;
	}
	/**
	 * @return retorna a array de tags.
	 */
	public String[] getTags() {
		return this.tags;}	
		
	/**
	 * Retorna os atributos do contato
	 * 
	 * @return Retorna o nome, sobrenome, telefone e tags 
	 */
	public String toString() {
		String tags = "";
		String detalhesDoContato;
		
		for (int i = 0; i < getTags().length; i++) {
			if (getTags()[i] != null) {
					tags += getTags()[i] + " ";	
				}
			}
		if (tags.equals("")) {
			detalhesDoContato = String.format("%s %s\n%s",getNome(),getSobrenome(),getTelefone());
			
		}else {
			detalhesDoContato = String.format("%s %s\n%s\n%s",getNome(),getSobrenome(),getTelefone(), tags);
		}
		return detalhesDoContato;
	}
	
	/**
	 * Remove a tag da array de tags.
	 * 
	 * @param posicaoTag posicao da tag.
	 */
	public void removeTag(int posicaoTag) {
		if (posicaoTag < 1 || posicaoTag > 5) {
			throw new IndexOutOfBoundsException("Posição de tag inválida");
		}
		this.tags[posicaoTag - 1] = null;
		
	}

}
