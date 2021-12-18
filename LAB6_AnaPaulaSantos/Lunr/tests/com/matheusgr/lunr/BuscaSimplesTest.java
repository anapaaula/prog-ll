package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.matheusgr.lunr.busca.BuscaSimples;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;

class BuscaSimplesTest {
	
	private String[] termos;
	private DocumentoController documentoController;
	private DocumentoService documentoService;
	private BuscaSimples controle;

	@BeforeEach
	void testHashCode() {
		var exemplo = new DocumentoExemplos();
		this.termos = new String[1];
		this.termos[0] = "LunrFacade";
		this.documentoService = new DocumentoService();
		this.documentoController = new DocumentoController(this.documentoService); 
		this.documentoController.adicionaDocumentoHtml("HTML_ID", exemplo.sampleHTML());
		this.documentoController.adicionaDocumentoJava("JAVA_ID", exemplo.sampleJava());
		this.controle = new BuscaSimples(this.termos);
	}

	@Test
	void testBusca() {
		Map<Documento, Integer> documentos = this.controle.busca(documentoService);
		assertEquals(documentos.size(), 1);
		for (Entry<Documento, Integer> entry : documentos.entrySet()) {
			assertEquals(entry.getKey().getId(), "JAVA_ID");
			
		}
		
	}

	@Test
	void testDescreveConsulta() {
		String[][] consulta = this.controle.descreveConsulta();
		String[][] resposta = {{"TERMO 1", "LunrFacade"}};
		Assert.assertArrayEquals(consulta, resposta);
	}

	

}
