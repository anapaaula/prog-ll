package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.similaridade.SimilaridadeService;

class SimilaridadeServiceTest {
	
	private DocumentoService documentoService;
	private SimilaridadeService controle;
	DocumentoController documentoController;

	@BeforeEach
	void inizializador() {
		this.documentoService = new DocumentoService();
		this.controle = new SimilaridadeService(this.documentoService);
		this.documentoController = new DocumentoController(this.documentoService);
		documentoController.adicionaDocumentoHtml("html", "Uma casa feliz é uma casa bonita");
		documentoController.adicionaDocumentoTxt("txt", "Um dia feliz é um bom dia");
	}

	@Test
	void testSimilaridade() {
		assertEquals(this.controle.similaridade("html", "txt"), 0.2);
		
	}
	
	@Test
	void testSimilaridadeValorLimite1() {
		documentoController.adicionaDocumentoHtml("java", "Uma casa feliz é uma casa bonita");
		documentoController.adicionaDocumentoTxt("txt2", "Uma casa feliz é uma casa bonita");
		assertEquals(this.controle.similaridade("java", "txt2"), 1);
	}
	
	@Test
	void testSimilaridadeValorLimite2() {
		documentoController.adicionaDocumentoHtml("java", "Uma casa feliz é uma casa bonita");
		documentoController.adicionaDocumentoTxt("txt3", "testando sem nenhum elemento igual");
		assertEquals(this.controle.similaridade("java", "txt3"), 0);
	}

}
