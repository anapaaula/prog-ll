package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public class BuscaAvancada implements Busca{
	
	/**
	 * BuscaAvancada realiza uma operação de busca a partir de metadados.
	 *
	 * Os documentos a serem retornados precisam conter todos os metadados do map passado.
	 *
	 */
	private Map<String, String> metadados;
	private String nome = "buscaAvancada";
	
	public BuscaAvancada(Map<String,String> metadados) {
		this.metadados = metadados;
	}
	
	
	/**
	 * Realiza a busca a partir do conjunto de documentos que o DocumentoService retorna.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	@Override
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		Set<Documento> docs = ds.busca();
		
		
		for(Documento controle : docs) {
			Map<String, String> metadados = controle.getMetadados();
			
			if	(verifica(metadados)) {
				respostaDocumento.put(controle, respostaDocumento.getOrDefault(controle, 0) + 1);
				
			}
	}
		 return respostaDocumento;
	}
	
	/**
	 * Verifica se os termos passados no map, então contidos nos metadados dos documentos. 
	 * 
	 * 
	 * @param metadados map dos metadados do documento
	 * @return true se todos os termos passados estiverem nos metadados do documento, e false se não tiver pelo menos um termo dos termos
	 */
	public boolean verifica(Map<String, String> metadados) {
		int contador = 0;
		for (Entry<String, String> entry : this.metadados.entrySet()) {
			if(metadados.containsKey(entry.getKey()) && metadados.get(entry.getKey()).equals(entry.getValue())) {
				contador += 1;
			}
		}
		if(contador == this.metadados.size()) {
			contador = 0;
			return true;
		}
			return false;
	
	}
	
	
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	@Override
	public String[][] descreveConsulta() {
		
		String[] metadados = new String[this.metadados.size()]; 
		int contador = 0;
		
		for (Entry<String, String> entry : this.metadados.entrySet()) {
	        metadados[contador] = entry.getKey() + " - " + entry.getValue();
	        contador += 1;
	        if(contador == this.metadados.size()) {
	        	break;
	        }
	    }

		
		String[][] resultado = new String[this.metadados.size()][];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = new String[] {"METADADOS" + (i + 1), metadados[i]};
		}
		return resultado;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuscaAvancada other = (BuscaAvancada) obj;
		return Objects.equals(nome, other.nome);
	}

}
	
	


