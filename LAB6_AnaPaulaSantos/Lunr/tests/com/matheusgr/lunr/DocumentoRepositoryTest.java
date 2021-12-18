package com.matheusgr.lunr;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoRepositoryTest {
	
	private DocumentoRepository controle;
	
	@BeforeEach
	void inicializador() {
		this.controle = new DocumentoRepository();
		var exemplo = new DocumentoExemplos();
		this.controle.adiciona(new DocumentoHtml("HTML_ID",exemplo.sampleHTML()));
		this.controle.adiciona(new DocumentoHtml("JAVA_ID",exemplo.sampleJava()));
	}

	@Test
	void testAdiciona() {
		this.controle.adiciona(new DocumentoHtml("html","html"));
		var documento = this.controle.recupera("html");
		assertEquals(documento.get().getId(), "html");
	}

	@Test
	void testRecupera() {
		var documentoOpt = this.controle.recupera("JAVA_ID");
		assertEquals(documentoOpt.get().getId(), "JAVA_ID");
	}
	
	@Test
	void testRecuperaIdNull() {
		try {
			String id = null;
			this.controle.recupera(id);
			fail("ID inválido!");
		}catch(NullPointerException npe) {
			
		}
		
	}
	
	@Test
	void testRecuperaIdVazio() {
		try {
			String id = ""; 
			 this.controle.recupera(id);
			fail("ID inválido!");
		}catch(IllegalArgumentException iae) {
			
		}
		
	}
	
	
	@Test
	void testTotalDocumentos() {
		assertEquals(this.controle.totalDocumentos(), 2);
		
	}
	
	@Test
	void testBuscaString() {
		var docs = this.controle.busca("LunrFacade");
		assertEquals(docs.size(), 1);
	}

	@Test
	void testBusca() {
		var docs = this.controle.busca();
		assertEquals(docs.size(), 2);
		
	}

}
