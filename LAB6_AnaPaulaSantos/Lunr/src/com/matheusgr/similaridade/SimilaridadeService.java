package com.matheusgr.similaridade;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.matheusgr.lunr.documento.DocumentoService;


/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 */
public class SimilaridadeService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		// PEGA DOCUMENTO 1
				// PEGA DOCUMENTO 2
				// COLOCA TERMOS DO DOCUMENTO 1 EM UM CONJUNTO
				// COLOCA TERMOS DO DOCUMENTO 2 EM OUTRO CONJUNTO
				// A SIMILARIDADE É DETERMINADA PELO...
				// --> (TAMANHO DA INTERSEÇÃO) / (TAMANHO DA UNIÃO DOS CONJUNTOS)
		
		String[] id1 = this.documentoService.recuperaDocumento(docId1).get().getTexto();
		String[] id2 = this.documentoService.recuperaDocumento(docId2).get().getTexto();
		
		Set<String> id1SemRepeticao = Stream.of(id1).collect(Collectors.toSet());
		Set<String> id2SemRepeticao = Stream.of(id2).collect(Collectors.toSet());
		
		Set<String> intersecao = new HashSet<>();
		Set<String> uniao = new HashSet<>();
		
		for(String palavras : id2SemRepeticao) {uniao.add(palavras);}
		
		for(String palavra : id1SemRepeticao) {
			uniao.add(palavra);
			if(id2SemRepeticao.contains(palavra)) {intersecao.add(palavra);}
		}
		double similaridade = (double) intersecao.size() / uniao.size();
		
		if (similaridade > 1) {return 1;}
		if (similaridade < 0) {return 0;}
		
		return similaridade;	
	}
}

