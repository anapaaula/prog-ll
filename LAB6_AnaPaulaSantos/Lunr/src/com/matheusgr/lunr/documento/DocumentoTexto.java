package com.matheusgr.lunr.documento;


import java.util.HashMap;
import java.util.Map;


import biblitex.TransformaTexto;

/**
 * Documento de texto simples. Não precisa de tratamento complexos nem tem
 * metadados próprios.
 */
class DocumentoTexto extends DocumentoAbstract {

	private Map<String, String> metadados;


	/**
	 * Construtor padrão do documento de texto.
	 * @param id ID do documento.
	 * @param txt Texto do documento.
	 */
	public DocumentoTexto(String id, String txt) {
		super(id,txt);
		adicionaTxtLimpo((new TransformaTexto()).transforma(TransformaTexto.Algoritmos.clean, txt).strip());
	}


	@Override
	public String toString() {
		return "===" + this.id + System.lineSeparator() + this.limpo;
	}

	@Override
	public Map<String, String> getMetadados() {
		if (this.metadados != null) {
			return this.metadados;
		}
		this.metadados = new HashMap<String, String>();
		this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
		this.metadados.put("TAMANHO", "" + this.limpo.length());
		this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		this.metadados.put("TIPO", "" + "txt");
		return this.metadados;
	}
	
}
