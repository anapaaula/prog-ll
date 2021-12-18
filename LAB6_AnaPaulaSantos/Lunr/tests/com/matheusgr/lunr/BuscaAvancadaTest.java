package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.busca.BuscaAvancada;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;


class BuscaAvancadaTest {
	private Map<String , String> metadados;
	private BuscaAvancada controle;
	private DocumentoController documentoController;
	private DocumentoService documentoService;
	
	@BeforeEach
	void testBuscaAvancada() {
		this.metadados = new HashMap<>();
		this.metadados.put("TIPO", "html");
		this.metadados.put("LINHAS", "3");
		this.documentoService = new DocumentoService();
		this.documentoController = new DocumentoController(this.documentoService); 
		this.documentoController.adicionaDocumentoHtml("HTML_ID", "Teste\n com \n três \n linhas");
		this.documentoController.adicionaDocumentoJava("JAVA_ID", "Teste \n com \n três \n linhas");
		this.documentoController.adicionaDocumentoTxt("TXT_ID", "Teste \n com \n três \n linhas");
		this.controle = new BuscaAvancada(this.metadados);
	
		
	}

	@Test
	void testBusca1() {
		Map<Documento, Integer> documentos = this.controle.busca(this.documentoService);
		assertEquals(documentos.size(), 1);
		for(Entry<Documento, Integer> entry : documentos.entrySet()) {
			var id = entry.getKey().getId();
			assertEquals(id, "HTML_ID");
		}
	}
	
	@Test
	void testBusca2() {
		Map<Documento, Integer> documentos = this.controle.busca(this.documentoService);
		assertEquals(documentos.size(), 1);
	}
	

	@Test
	void testDescreveConsulta() {
		var consulta = this.controle.descreveConsulta();
		String[][] resposta = {{"METADADOS1", "LINHAS - 3"}, {"METADADOS2", "TIPO - html"}};
		Assert.assertArrayEquals(consulta, resposta);
	}

	
	

}
