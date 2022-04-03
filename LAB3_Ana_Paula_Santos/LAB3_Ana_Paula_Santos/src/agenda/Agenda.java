package agenda;

import java.util.NoSuchElementException;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Ana Paula
 * @author nazareno
 * 
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS= 10;
	
	private Contato[] contatos;
	private String[] favoritos;
	private int confirmacaoDeCadastro;

	/**
	 * Cria uma agenda e uma array de favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		favoritos = new String[TAMANHO_FAVORITOS];
		
	
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * 
	 * @return A array de contatos.
	 */
	public Contato[] getContatos() { 
		return this.contatos.clone();
	}
	
	/**
	 * Acessa a lista de favoritos.
	 * 
	 * @return O array de contatos favoritos.
	 */
	public String[] getContatosFavoritos() { 
		return this.favoritos.clone();
	}
	
	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Retorna o toString do objeto contato
	 *
	 */
	public String getContato(int posicao) {
		if (this.contatos[posicao - 1] == null) {
			throw new NoSuchElementException("Nenhum contato nessa posição");
		}else {
			return this.contatos[posicao - 1].toString();
				
			}
		
		}

	/**
	 * Cadastra um contato de acordo com a posição na lista. Se já existir um contato na mesma posição
	 * ele é substituido pelo novo.
	 * Antes de cadastrar verifica se o contato já está na lista.
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
			if (!equals(nome, sobrenome)){
				this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
				confirmacaoDeCadastro = 1;
			}else {
				confirmacaoDeCadastro = 0;
			}
			
		}

		/**
		 * Adiciona um contato existente na lista de favoritos.
		 * 
		 * @param contato posicao do contato na agenda
		 * @param posicao posicao que o contato vai ser adicionado na lista de favoritos
		 */
	public void adicionaFavoritos(int contato, int posicao) {
		if (posicao > 10 || posicao < 1) {
			throw new IndexOutOfBoundsException("Posição inválida");	
		}
		if (!equalsFavoritos(contatos[contato - 1].getNome(), contatos[contato - 1].getSobrenome())){
			favoritos[posicao - 1] = contatos[contato - 1].getNome() + " " + contatos[contato - 1].getSobrenome();
			confirmacaoDeCadastro = 1;
		}else {
			confirmacaoDeCadastro = 0;
		}
	}
	
	/**
	 * Compara o nome e sobrenome do contato, para verificar se o contato já está 
	 * cadastrado na agenda.
	 * 
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @return retorna true se o contato já está cadastrado, e false se o contato não estiver.
	 */

	public boolean equals(String nome, String sobrenome) {
		boolean retorno = false;
			for(int i = 0; i < contatos.length; i++) {
				if (contatos[i] != null) {
					if (this.contatos[i].getNome().equals(nome) && this.contatos[i].getSobrenome().equals(sobrenome)){
						retorno = true;
						break;}
					}
				}
		return retorno;
	}
	
	
	/**
	 * Compara o nome e sobrenome do contato, para verificar se o contato já está 
	 * cadastrado na lista de favoritos.
	 * 
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato 
	 * @return Retorna true se o contato já está cadastrado, e false se o contato não estiver.
	 */
	public boolean equalsFavoritos(String nome, String sobrenome) {
		boolean retorno = false;
		for(int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				String[] contatoFavorito = this.favoritos[i].split(" ");
				if(contatoFavorito[0].equals(nome) && contatoFavorito[1].equals(sobrenome)){
					retorno = true;
					break;
					}
				}
			}
		return retorno;
		}
	
	/**
	 * Verifica se o contato é favorito.
	 * 
	 * @param posicao posicao do contato na agenda
	 * @return Retorna true se o contato for favorito, e false se não for.
	 */
	public boolean verifica(int posicao) {
		
		boolean retorno = false;
			for(int i = 0; i < this.favoritos.length; i++) {
				if (this.favoritos[i] != null) {
					String[] contatoFavorito = this.favoritos[i].split(" ");
					if(contatoFavorito[0].equals(this.contatos[posicao - 1].getNome()) && contatoFavorito[1].equals(this.contatos[posicao - 1].getSobrenome())) {
							retorno = true;
							break;}
				}
			}
			return retorno;
	}
		
	
	/**
	 * Adiciona uma tag ao contato.
	 * 
	 * @param contato posição do contato na agenda
	 * @param tag uma string com a tag 
	 * @param posicaoTag posicao da tag que vai ser cadastrada em uma array de tags com 5 posições 
	 */

	public void adicionarTag(String contato, String tag, int posicaoTag) {
		
		String[] contatoList = contato.trim().split(" ");
		
		for (int i = 0; i < contatoList.length; i++) {
			int contatoInt = Integer.parseInt(contatoList[i]);
			this.contatos[contatoInt - 1].cadastrarTag(tag, (posicaoTag));
		}
		
	}
	
	
	/**
	 * Remove uma tag de um contato.
	 * 
	 * @param contato o contato da agenda
	 * @param posicaoTag posicao da tag na array de tags 
	 */
	public void removeTag(int contato, int posicaoTag) {
		this.contatos[contato - 1].removeTag(posicaoTag);
	}
	
	
	/**
	 * Remove um contato da lista de favoritos.
	 * 
	 * @param posicaoFavorito posicao do contato na lista de favoritos
	 */
	public void removeFavorito(int posicaoFavorito) {
		if (posicaoFavorito < 1 || posicaoFavorito > 10) {
				throw new IndexOutOfBoundsException("Posição inválida");
		}
		this.favoritos[posicaoFavorito - 1] = null;
		
	}
	/**
	 * Faz a confirmação do cadastro de um contato na agenda e na lista de favoritos.
	 * 
	 * @return Retorna true se o contato foi cadastrado com sucesso, e false se o cadastro não foi realizado.
	 */
	public boolean confirmacaoDeCadastro() {
		if(confirmacaoDeCadastro == 1) {
			return true;
		}else {
			return false;
		}
	}
}
