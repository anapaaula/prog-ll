package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.Map;


import biblitex.TransformaTexto;

/**
 * SuperClasse dos Documentos. Todos os documentos herdarão 
 * os metodos da classe DocumentoAbstract.
 * 
*/
public abstract class DocumentoAbstract implements Documento{
	
	protected String id;
	protected String original;
	protected String limpo;
	private String[] split;
	private ValidadorDocumentos validador;

	/**
	 * inicializa o objeto.
	 *  
	 * @param id identificação do documento
	 * @param original texto do documento
	 */
	public DocumentoAbstract(String id, String original) {
		this.validador = new ValidadorDocumentos();
		this.validador.validacao(id, original);
		this.id = id;
		this.original = original;
		
	}	
	
	/**
	 * Adiciona o texto limpo no documento.
	 * 
	 * @param limpo texto após passar pelo método clean da biblitex
	 */
	public void adicionaTxtLimpo(String limpo) {
		this.validador.validacao(limpo);
		this.limpo = limpo;
		
	}
	
	/**
	 * retorna uma proporção referente à quantidade de texto útil 
	 * (textos com termos que são expressivos ou de interesse para o sistema) 
	 * sobre o total de caracteres originais no documento
	 */
	public double metricaTextoUtil() {
		long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo)
				.length();
		return (1.0 * extractedSize) / this.original.length();
	}

	
	/**
	 * @return a identificação do documento
	 */
	public String getId() {
		return this.id;
	}

	
	/**
	 * @return  um array de termos não-vazios que são relevantes do documento
	 * 
	 */
	public String[] getTexto() {
		if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
					.split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
	}
	
	
	/**
	 * @return um mapa de metadados, ou seja, 
	 * informações úteis sobre o documento mas que não estão, 
	 * necessariamente, dentro do texto do documento. A chave descreve sobre o que se refere o metadado em questão,
	 * enquanto o valor é a representação em string do metadado em si.
	 * 
	 */
	@Override
	abstract public Map<String, String> getMetadados(); 
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoAbstract other = (DocumentoAbstract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
	
	

}
