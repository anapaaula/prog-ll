package com.matheusgr.lunr;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoJava;

class DocumentoServiceTest {
	
	
	DocumentoService controle;
	
	
	@BeforeEach
	void inicializador() {
		this.controle = new DocumentoService();
		var exemplo = new DocumentoExemplos();
		this.controle.adicionaDocumento(new DocumentoHtml("HTML_ID", exemplo.sampleHTML()));
		this.controle.adicionaDocumento(new DocumentoJava("JAVA_ID", exemplo.sampleJava()));

	}

	@Test
	void testAdicionaDocumento() {
		this.controle.adicionaDocumento(new DocumentoHtml("html", "oie, tudo bem?"));
		var documentoOpt = this.controle.recuperaDocumento("html");
		assertEquals(documentoOpt.get().getId(), "html");
	}
	

	@Test
	void testRecuperaDocumento() {
		var documentoOpt = this.controle.recuperaDocumento("JAVA_ID");
		assertEquals(documentoOpt.get().getId(), "JAVA_ID");

	}

	@Test
	void testTotalDocumentos() {
		int totalDeDocumentos = this.controle.totalDocumentos();
		assertEquals(totalDeDocumentos, 2);
	}

	@Test
	void testConcatena() {
		String docsConcatenados = this.controle.concatena("JAVA_ID", "HTML_ID");
		assertEquals("_MERGEJAVA_ID|HTML_ID", docsConcatenados);
	}

	@Test
	void testSumariza() {
		this.controle.adicionaDocumento(new DocumentoJava("TXT_ID", "Sumariza Sumariza Sumariza \n"
				+ "Abacaxi Abacaxi \n"
				+ "Universidade Universidade Universidade Universidade Universidade \n"
				+ "programação \n"
				+ "matemática matemática matemática matemática \n"
				+ "fundamentos \n"
				+ "Física Física Física Física Física Física \n"));
		String[] docSumarizado = this.controle.sumariza("TXT_ID");
		String[] resultado = {"Física", "Universidade", "matemática" , "Sumariza", "Abacaxi"};
		assertEquals(docSumarizado.length, resultado.length);
		Assert.assertArrayEquals(docSumarizado, resultado);
		
	}


	@Test
	void testBusca() {
		Set<Documento> docs = this.controle.busca();
		var documentoOpt = this.controle.recuperaDocumento("HTML_ID");
		var documentoOpt2 = this.controle.recuperaDocumento("JAVA_ID");
		
		assertTrue(docs.contains(documentoOpt.get()));
		assertTrue(docs.contains(documentoOpt2.get()));
		assertEquals(docs.size(), 2);
			
		}
	}


